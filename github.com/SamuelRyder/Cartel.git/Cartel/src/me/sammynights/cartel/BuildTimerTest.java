package me.sammynights.cartel;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public final class BuildTimerTest extends JavaPlugin {

    @Override
    public void onEnable() {
        new ExampleListener(this);
    }
}

class ExampleListener implements Listener {

    private final BuildTimerTest plugin;

    public ExampleListener(BuildTimerTest plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        // Create the task and schedule to run it once, after 20 ticks
        BukkitTask task = new ExampleTask(this.plugin).runTaskLater(this.plugin, 20);
    }

}