package com.drovyng.slim;

import com.destroystokyo.paper.event.server.PaperServerListPingEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;


public class ServerPingEvent implements Listener {
    @EventHandler
    public void lol(PaperServerListPingEvent event){
        var text = event.getNumPlayers() + "§8/§7" + event.getMaxPlayers();
        if (text.length() < 7) text = " " + text;
        if (text.length() < 7) text = " " + text;
        event.setVersion("§r§f"+ ChatColor.translateAlternateColorCodes('&', SLIM.Texts.get((int)(System.currentTimeMillis() % SLIM.Texts.size())))+" §l➤                                                    §r§7"+text+" §a✔");
        event.setProtocolVersion(0);
        event.setCancelled(false);
    }
}
