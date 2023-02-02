package pe.bazan.luis.plugins.villagercontrol;

import org.bukkit.plugin.java.JavaPlugin;
import pe.bazan.luis.plugins.villagercontrol.commands.MainCommand;
import pe.bazan.luis.plugins.villagercontrol.configs.MainConfigManager;
import pe.bazan.luis.plugins.villagercontrol.events.EventsManager;

public final class VillagerControl extends JavaPlugin {
  private boolean active;
  private static VillagerControl instance;
  private MainConfigManager configManager;

  @Override
  public void onEnable() {
    this.configManager = new MainConfigManager(this);
    this.active = configManager.getConfig().getBoolean("enabled");
    instance = this;
    new EventsManager(this);
    new MainCommand(this);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }

  public static VillagerControl getInstance() {
    return instance;
  }

  public boolean isActive() {
    return active;
  }

  public MainConfigManager getConfigManager() {
    return configManager;
  }

  public void reload() {
    this.configManager.reloadConfig();
    this.active = configManager.getConfig().getBoolean("enabled");
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
