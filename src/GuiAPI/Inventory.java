package GuiAPI;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.bukkit.Bukkit;
import org.bukkit.inventory.InventoryHolder;

public class Inventory
{
		
	public static LinkedHashMap<org.bukkit.inventory.Inventory, Inventory> inventories = new LinkedHashMap<>();
	
	org.bukkit.inventory.Inventory inventory;
	
	public InventoryHolder owner;
	public String title;
	public int size;
	
	HashMap<Integer, Listener> slotsAndListeners;
	
	public Inventory(InventoryHolder owner, int size, String title)
	{
		this.owner = owner;
		this.title = title;
		this.size = size * 9;
		
		inventory = Bukkit.createInventory(this.owner, this.size, this.title);		
		slotsAndListeners = new HashMap<>();
		
		inventories.put(inventory, this);
	}
	
	public org.bukkit.inventory.Inventory getInventory() { return inventory; }
	
	public void setEventListener(int slot, Listener listener)
	{
		slotsAndListeners.put(slot, listener);
		inventories.put(inventory, this);
	}
	
	public void runClickEvent(int slot, boolean isRightClick)
	{
		if (slotsAndListeners.containsKey(slot))
		{
			slotsAndListeners.get(slot).onClick();
			if (isRightClick) slotsAndListeners.get(slot).onRightClick();
			else slotsAndListeners.get(slot).onLeftClick();
		}
	}

}
