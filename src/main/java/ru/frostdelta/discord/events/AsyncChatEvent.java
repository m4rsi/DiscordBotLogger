package ru.frostdelta.discord.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import ru.looprich.discordlogger.modules.DiscordBot;

import static ru.looprich.discordlogger.modules.DiscordBot.sendMessageChannel;

public class AsyncChatEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    void chat(AsyncPlayerChatEvent event) {
        Player player = event.getPlayer();
        String msg = event.getMessage();
        if(event.isCancelled()){
            return;
        }
        if (event.getRecipients().size() == Bukkit.getOnlinePlayers().size()) {
            sendMessageChannel("[G]<" + player.getName() + "> " + msg.replace("!", ""));
        } else {
            if (DiscordBot.isLocalEnabled()) {
                sendMessageChannel("[L]<" + player.getName() + "> " + msg);
            }
        }
    }

}
