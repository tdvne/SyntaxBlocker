package me.tdvne.syntaxblocker;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("Syntax Blocker has successfully loaded.");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent Syntax) {
        if (Syntax.getMessage().split(" ")[0].contains(":")) {
            Syntax.setCancelled(true);
            Syntax.getPlayer().sendMessage("§cThis syntax is not accepted.");
        }
    }
}

