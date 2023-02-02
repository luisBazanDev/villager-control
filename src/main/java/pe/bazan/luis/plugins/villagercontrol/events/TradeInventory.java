package pe.bazan.luis.plugins.villagercontrol.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import pe.bazan.luis.plugins.villagercontrol.VillagerControl;

public class TradeInventory implements Listener {
  @EventHandler
  public void onTradeInventory(InventoryOpenEvent e) {
    if(!e.getInventory().getType().equals(InventoryType.MERCHANT)) return;
    if(!VillagerControl.getInstance().isActive()) return;
    if(VillagerControl.getInstance().getConfigManager().getConfig().getBoolean("events.trade-inventory")) {
      e.setCancelled(true);
    }
  }
}
