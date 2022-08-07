package me.tdvne.syntaxblocker;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
    private static Main instance;
    Main plugin = this;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        Bukkit.getServer().getConsoleSender().sendMessage("§a[SyntaxBlocker] Registering Listeners...");
        getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getConsoleSender().sendMessage("§aSyntaxBlocker has successfully registered listeners & loaded.");
    }

    public void onDisable() {
        Bukkit.getServer().getConsoleSender().sendMessage("§aSyntaxBlocker has successfully unloaded & disabled.");
    }

    // Listener & Tasks
    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent Syntax) {
        if (Syntax.getMessage().split(" ")[0].contains(":")) {
            Syntax.setCancelled(true);
            Syntax.getPlayer().sendMessage(ChatColor.RED + "This syntax is not accepted.");
        }
    }
}

