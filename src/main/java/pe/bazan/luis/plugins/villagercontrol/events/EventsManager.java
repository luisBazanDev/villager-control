package pe.bazan.luis.plugins.villagercontrol.events;

import org.bukkit.plugin.PluginManager;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

public class EventsManager {
  private VillagerControl villagerControl;
  public EventsManager(VillagerControl plugin) {
    this.villagerControl = plugin;
    registerEvents();
  }

  private void registerEvents() {
    final PluginManager pluginManager = villagerControl.getServer().getPluginManager();
    pluginManager.registerEvents(new TradeInventory(), villagerControl);
    pluginManager.registerEvents(new VillagerSpawn(), villagerControl);
    pluginManager.registerEvents(new PlayerTrade(), villagerControl);
    pluginManager.registerEvents(new WanderingTraderSpawn(), villagerControl);
  }
}
