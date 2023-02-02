package pe.bazan.luis.plugins.villagercontrol.events;

import io.papermc.paper.event.player.PlayerTradeEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

public class PlayerTrade implements Listener {
  @EventHandler
  public void onPlayerTrade(PlayerTradeEvent e) {
    if(!VillagerControl.getInstance().isActive()) return;
    if(VillagerControl.getInstance().getConfigManager().getConfig().getBoolean("events.player-trade")) {
      e.setCancelled(true);
    }
  }
}
