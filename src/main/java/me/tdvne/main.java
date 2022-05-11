package me.tdvne;

import me.tdvne.util.CC;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.awt.*;
import java.util.regex.PatternSyntaxException;

public class main extends JavaPlugin implements Listener {
    private static main instance;

    public static PatternSyntaxException getPlugin() {
        return null;
    }

    public static main getInstance() {
        return instance;
    }

    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(this, this);
        System.out.println("[SyntaxBlocker] This plugin has successfully enabled.");
    }

    public void onDisable() {
        System.out.println("[SyntaxBlocker] This plugin has successfully disabled");
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent Syntax) {
        if (Syntax.getMessage().split(" ")[0].contains(":")) {
            Syntax.setCancelled(true);
            Syntax.getPlayer().sendMessage(ChatColor.RED + "This syntax is not accepted.");
        }

        if (Syntax.getMessage().trim().equalsIgnoreCase("/syntaxblocker")) {
            Syntax.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            Syntax.getPlayer().sendMessage(CC.translate("&4&lSyntax Blocker"));
            Syntax.getPlayer().sendMessage(CC.translate(" &c&l┃ &fAuthor: &ctdvne"));
            Syntax.getPlayer().sendMessage(CC.translate(" &c&l┃ &fDiscord: &ctdvne#0001"));
            Syntax.getPlayer().sendMessage(CC.translate(" &c&l┃ &fVersion: &cv1.0"));
            Syntax.getPlayer().sendMessage(CC.translate("&4&m--*----------------*--"));
            Syntax.setCancelled(true);
        }
    }
}

