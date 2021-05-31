package me.pikachow.fortuned.commands;

import me.pikachow.fortuned.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DiscordCommand implements CommandExecutor {
    private final Main main;

    public DiscordCommand(Main main) {
        this.main = main;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            player.sendMessage( ChatColor.AQUA +"https://discord.gg/QJxnnXgJY6");
        } else {
            main.getLogger().info("https://discord.gg/QJxnnXgJY6");
        }
        return false;
    }
}
