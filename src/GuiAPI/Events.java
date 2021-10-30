package GuiAPI;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class Events implements Listener
{
	
	@EventHandler
	public void InventoryCloseEvent(InventoryCloseEvent e) 
	{
		if (Inventory.inventories.containsKey(e.getInventory()))
			Inventory.inventories.remove(e.getInventory());
	}
	
	@EventHandler
	public void InventoryClickEvent(InventoryClickEvent e)
	{
		if (Inventory.inventories.containsKey(e.getInventory())) e.setCancelled(true);
		if (Inventory.inventories.containsKey(e.getClickedInventory()))
			Inventory.inventories.get(e.getClickedInventory()).runClickEvent(e.getSlot(), e.isRightClick());
	}

}
