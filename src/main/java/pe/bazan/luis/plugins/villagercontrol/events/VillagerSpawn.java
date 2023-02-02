package pe.bazan.luis.plugins.villagercontrol.events;

import com.destroystokyo.paper.event.entity.EntityAddToWorldEvent;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

public class VillagerSpawn implements Listener {
  @EventHandler
  public void onVillagerSpawn(EntitySpawnEvent e) {
    if(!(e.getEntity() instanceof Villager)) return;
    if(!VillagerControl.getInstance().isActive()) return;
    if(VillagerControl.getInstance().getConfigManager().getConfig().getBoolean("events.villager-spawn")) {
      e.setCancelled(true);
    }
  }
  @EventHandler
  public void onVillagerGenerate(EntityAddToWorldEvent e) {
    // Development
    if(!(e.getEntity() instanceof Villager) || true) return;
    if(!VillagerControl.getInstance().isActive()) return;
    if(VillagerControl.getInstance().getConfigManager().getConfig().getBoolean("events.villager-spawn")) {
      if(e.getEntity() != null && !e.getEntity().isEmpty()) e.getEntity().remove();
    }
  }
}
