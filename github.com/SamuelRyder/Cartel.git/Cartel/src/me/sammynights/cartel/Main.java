package me.sammynights.cartel;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

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

	int x = 1;  */
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {	
		// Check to see if the user entered the command 'cartel'
		if (label.equalsIgnoreCase("cartel")) {
			// Check and make sure sender is Player (not server)
			if (!(sender instanceof Player)) {
				sender.sendMessage("You need to be a player to start a Cartel");
				return true;
			}
			// Ensure sender has permissions to use the cartel command
			if(!sender.hasPermission("cartel.use")) {
				sender.sendMessage("You do not have permission to start a Cartel!");
				return true;
			}
			// We want the following to happen immediately following execution of /cartel
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

			// The following happens after the completion of the above commands.
			// To add a delay, we create an anonymous subclass of BukkitRunnable
			// in which we define the work we want to do.
			new BukkitRunnable() {
				@Override
				public void run() {
					// Then, we override the run method (which is what the )
					p.sendMessage("All Done Boss!");
					npc.despawn();
				}
				// Then, after defining the work we want to do, we tell bukkit to run this work
				// under 'this' plugin, after 3000 ticks (= 5 mins * 60 seconds/min * 10 ticks/s)
			}.runTaskLater(this, 3000);
			return false;
		}
  	return false;
	}
}
