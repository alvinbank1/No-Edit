package org.noedit.noedit;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class No_Edit extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this,this);
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[No Edit] Loaded!");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "[No Edit] Disabled!");
    }

    @EventHandler
    public void blockbreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        if(!p.isOp()){
            e.setCancelled(true);
            p.sendMessage("§e§l[!] §eYou Can't break that block here!");
        }
    }

    @EventHandler
    public void blockplace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        if(!p.isOp()) {
            e.setCancelled(true);
            p.sendMessage("§e§l[!] §eYou Can't place that block here!");
        }
    }

    @EventHandler
    public void attack(EntityDamageByEntityEvent e){
        Entity p = e.getDamager();
        if (!p.isOp()) {
            e.setCancelled(true);
            p.sendMessage("§e§l[!] §eYou Can't damage that entity here!");
        }
    }

    @EventHandler
    public void interaction(PlayerInteractEvent e){

        Player p = e.getPlayer();
        if (!p.isOp()){
            e.setCancelled(true);
            //p.sendMessage("§e§l[!] §eYou Can't do interaction here!");
        }
    }

    @EventHandler
    public void interactionentity(PlayerInteractEntityEvent e){
        Player p = e.getPlayer();
        if (!p.isOp()){
            e.setCancelled(true);
            p.sendMessage("§e§l[!] §eYou Can't interact that entity here!");
        }
    }
}
