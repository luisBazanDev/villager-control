package pe.bazan.luis.plugins.villagercontrol.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import pe.bazan.luis.plugins.villagercontrol.MessageFormat;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

import java.util.ArrayList;
import java.util.List;

public class MainCommand implements CommandExecutor, TabCompleter {
  private VillagerControl plugin;

  public MainCommand(VillagerControl villagerControl) {
    this.plugin = villagerControl;
    plugin.getCommand("villager-control").setExecutor(this);
    plugin.getCommand("villager-control").setTabCompleter(this);
  }
  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if(args.length < 1) return false;
    if(args[0].equalsIgnoreCase("reload")) {
      plugin.reload();
      plugin.getConfigManager().getConfig().getConfigurationSection("events").getKeys(false).forEach((k) -> {
        sender.sendMessage(MessageFormat.formatMC(String.format(
                "&a%s &e- %s",
                k,
                plugin.getConfigManager().getConfig().getBoolean("events."+k) ? "&aCancel" : "&7Indifferent"
        )));
      });
      sender.sendMessage(MessageFormat.formatMC("&f&lVC» &aReload the config!"));
      return true;
    }
    if(args[0].equalsIgnoreCase("set-status")) {
      if(args.length < 2) {
        sender.sendMessage(MessageFormat.formatMC("&f&lVC» &cError, &eUse: /villagerremove set-status enable/disable"));
        return true;
      }
      switch (args[1].toLowerCase()) {
        case "enable":
          plugin.setActive(true);
          sender.sendMessage(MessageFormat.formatMC("&f&lVC» &fSystem is now &a&lEnable"));
          break;
        case "disable":
          plugin.setActive(false);
          sender.sendMessage(MessageFormat.formatMC("&f&lVC» &fSystem is now &c&lDisable"));
          break;
        default:
          sender.sendMessage(MessageFormat.formatMC("&f&lVC» &cError, &eUse: /villagerremove set-status enable/disable"));
          break;
      }
      return true;
    }
    return false;
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
    List<String> tab = new ArrayList<>();
    if(args.length == 1) {
      String search = args[0].toLowerCase();
      if("reload".startsWith(search)) tab.add("reload");
      if("set-status".startsWith(search)) tab.add("set-status");
    }
    if(args.length == 2) {
      String search = args[1];
      if(args[0] == "set-status") {
        if("enable".startsWith(search)) tab.add("enable");
        if("disable".startsWith(search)) tab.add("disable");
      }
    }
    return tab;
  }
}
