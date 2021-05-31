package me.pikachow.fortuned;

import me.pikachow.fortuned.commands.DiscordCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new BreakBlock(), this);
        getServer().getPluginCommand("discord").setExecutor(new DiscordCommand(this));
    }


    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
