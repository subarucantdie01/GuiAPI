package GuiAPI;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Plugin extends JavaPlugin
{
	
	public static Plugin instance;
	
	@Override
	public void onLoad()
	{ 
		instance = this;
		Bukkit.getConsoleSender().sendMessage("§7[§fGuiAPI§7] §aLoaded!");
	}
	
	@Override
	public void onEnable()
	{
		Bukkit.getPluginManager().registerEvents(new Events(), this);
		Bukkit.getConsoleSender().sendMessage("§7[§fGuiAPI§7] §aEnabled!");
	}
	
	@Override
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage("§7[§fGuiAPI§7] §cDisabled!");
	}
	
}
