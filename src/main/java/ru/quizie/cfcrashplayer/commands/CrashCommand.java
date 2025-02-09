package ru.quizie.cfcrashplayer.commands;

import lombok.AllArgsConstructor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import ru.quizie.cfcrashplayer.CFCrashPlayer;
import ru.quizie.cfcrashplayer.crash.CrashManager;

@AllArgsConstructor
public class CrashCommand implements CommandExecutor {

    private final CrashManager crashManager;

    private final String playerNotFound = ChatColor.RED + "Player not found!";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("crashplayer.use")) {
            sender.sendMessage(ChatColor.RED + "No permission");
            return true;
        }

        if (args.length < 1) {
            sender.sendMessage(playerNotFound);
            return true;
        }

        final Player target = Bukkit.getPlayer(args[0]);
        if (target == null) {
            sender.sendMessage(playerNotFound);
            return true;
        }

        crashManager.crashPlayer(target);
        return true;
    }
}
