package me.sammynights.cartel;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import net.citizensnpcs.api.CitizensAPI;
import net.citizensnpcs.api.npc.NPC;

public class Main extends JavaPlugin {

    @Override
    public void onEnable(){
        //Fired when the server enables the plugin
    }

    @Override
    public void onDisable(){
        //Fired when the server stops and disables all plugins
    }
    int count = 1 + 1;
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
    		NPC npc = CitizensAPI.getNPCRegistry().createNPC(EntityType.PLAYER, "Pedro");
    		Player p = (Player) sender;
    		Location location = p.getLocation();
   			npc.isSpawned();
   			npc.getEntity();
   			npc.spawn(location);
   			p.performCommand("npc select");
  			p.performCommand("trait builder");
  			p.performCommand("builder load crackshack.schem");
  			p.performCommand("builder build ignoreair");
  			p.performCommand("acc clear self");
  			p.sendMessage("Hello " + p.getName() + " I'm Pedro!");
  			if(count == 300)
            {
            	p.sendMessage("See Ya Boss!");
    		    npc.destroy();
                return true;
            }
  			if(count != 300)
  			{
  				
  			}
            return true;
            }
            
    return false;
}
}
