package com.drovyng.slim;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

public class ServerPingEvent implements Listener {
    @EventHandler(priority = EventPriority.LOWEST)
    public void replacePingVersion(PaperServerListPingEvent event){
        var text = "§r§7" + event.getNumPlayers() + "§8/§7" + event.getMaxPlayers();
        while (text.length() < 15){
            text = " " + text;
        }
        event.setVersion("§r§f "+ ChatColor.translateAlternateColorCodes('&', SLIM.Texts.get((int)((System.currentTimeMillis() / 50) % SLIM.Texts.size())))+(SLIM.DefaultArrow ? " §l➤" : "§l")+"                                                 "+text+" §a✔");
        event.setProtocolVersion(0);
        event.setCancelled(false);
    }
}
