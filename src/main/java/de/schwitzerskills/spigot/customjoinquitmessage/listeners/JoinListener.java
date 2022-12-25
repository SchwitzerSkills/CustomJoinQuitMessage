package de.schwitzerskills.spigot.customjoinquitmessage.listeners;

import de.schwitzerskills.spigot.customjoinquitmessage.CustomJoinQuitMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinListener implements Listener {

    public String JoinMessage = CustomJoinQuitMessage.cfg.getString("JoinMessage");

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        Player p = e.getPlayer();
        JoinMessage = JoinMessage.replace("%player%", p.getName());
        JoinMessage = JoinMessage.replace("&", "§");

        e.setJoinMessage(JoinMessage);
    }
}
