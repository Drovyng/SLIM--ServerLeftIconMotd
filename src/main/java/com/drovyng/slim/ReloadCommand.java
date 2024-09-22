package com.drovyng.slim;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class ReloadCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!sender.hasPermission("slim.reloadCommand")) return false;

        sender.sendMessage("[SLIM]: Reloading!");

        SLIM.Instance.loadConfigTexts();

        sender.sendMessage("[SLIM]: Successfully reloaded!");

        return true;
    }
}
