package me.sammynights.cartel;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;


public class Main extends JavaPlugin {

	NPC npc;
	Player p;
	Location location;
	Server server;
	
	@Override
	public void onEnable() {
		// Fired when the server enables the plugin
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
    		npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Pedro");
    		p = (Player) sender;
    		location = p.getLocation();
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
  			buildtimer();
  			// npc.;
  			// p.sendMessage("All Done Boss!");
      		// npc.despawn();
      		return false;
       		}
    return false;
}
}

