package de.schwitzerskills.spigot.customjoinquitmessage.listeners;

import de.schwitzerskills.spigot.customjoinquitmessage.CustomJoinQuitMessage;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    public String QuitMessage = CustomJoinQuitMessage.cfg.getString("QuitMessage");

    @EventHandler
    public void onQuit(PlayerQuitEvent e){

        Player p = e.getPlayer();
        QuitMessage = QuitMessage.replace("%player%", p.getName());
        QuitMessage = QuitMessage.replace("&", "§");

        e.setQuitMessage(QuitMessage);
    }
}
