package me.sammynights.cartel;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class Build extends BukkitRunnable {

    private final JavaPlugin plugin;
    public Build(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        // What you want to schedule goes here
        plugin.getServer().broadcastMessage("Welcome to Bukkit! Remember to read the documentation!");
    }

}