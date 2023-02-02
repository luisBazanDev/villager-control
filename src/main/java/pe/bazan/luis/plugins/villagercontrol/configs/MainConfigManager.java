package pe.bazan.luis.plugins.villagercontrol.configs;

import org.bukkit.configuration.file.FileConfiguration;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

public class MainConfigManager {
  private VillagerControl plugin;
  private CustomConfig configFile;

  public MainConfigManager(VillagerControl plugin) {
    this.plugin = plugin;
    registerConfig();
  }

  public void registerConfig(){
    configFile = new CustomConfig("config.yml", plugin);
    configFile.registerConfig();
  }

  public void load(){
    FileConfiguration config = configFile.getConfig();
  }

  public void reloadConfig(){
    configFile.reloadConfig();
    load();
  }

  public void setStatus(boolean newState) {
    configFile.getConfig().set("enabled", newState);
    configFile.saveConfig();
  }

  public FileConfiguration getConfig() {
    return configFile.getConfig();
  }
}
