package pe.bazan.luis.plugins.villagercontrol.events;

import org.bukkit.entity.WanderingTrader;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

public class WanderingTraderSpawn implements Listener {
  @EventHandler
  public void onWanderingTraderSpawn(EntitySpawnEvent e) {
    if(!(e.getEntity() instanceof WanderingTrader)) return;
    if(!VillagerControl.getInstance().isActive()) return;
    if(VillagerControl.getInstance().getConfigManager().getConfig().getBoolean("events.wandering-trader-spawn")) {
      e.setCancelled(true);
    }
  }
}
