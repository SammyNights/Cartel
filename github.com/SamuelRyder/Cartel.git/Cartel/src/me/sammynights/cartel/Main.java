package me.sammynights.cartel;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;


public class Main extends JavaPlugin implements Listener {

	NPC npc;
	Player p;
	Location location;
	
	@Override
	public void onEnable() {
		// Fired when the server enables the plugin
		npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Pedro");
		location = p.getLocation();
	}

	@Override
	public void onDisable() {
		// Fired when the server stops and disables all plugins
	}
/*	public static buildtimer(String[] args)
	{
		
	}
	int x = 1;  */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) 
    {	
	      	if(label.equalsIgnoreCase("cartel"))
    	{
    		if(!(sender instanceof Player)) 
    		{
    			sender.sendMessage("You need to be a player to start a Cartel");
    			return true;
    		}
    		if(!sender.hasPermission("cartel.use")) 
    		{
    			sender.sendMessage("You do not have permission to start a Cartel!");
    			return true;
    		}
    		// NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Pedro");
    		p = (Player) sender;
    		// Location location = p.getLocation();
   			npc.isSpawned();
   			npc.getEntity();
   			npc.getId();
   			npc.spawn(location);
   			p.performCommand("npc select");
  			p.performCommand("trait builder");
  			p.performCommand("builder load crackshack.schem");
  			p.performCommand("builder build ignoreair");
  			p.performCommand("acc clear self");
  			p.sendMessage("Hello " + p.getName() + " I'm Pedro!");
 			p.sendMessage("All Done Boss!");
      		npc.destroy();
      		return false;
       		}
       		
    return false;
}
}

