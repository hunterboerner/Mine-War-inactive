package me.hunterboerner.war;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.entity.Player;

public class DamageListener implements Listener {

	private War plugin;

	public DamageListener(War plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerDamage(EntityDamageByEntityEvent event) {
		if (event.getEntity() instanceof Player
				&& event.getDamager() instanceof Player) {
			Player victim = (Player) event.getEntity();
			Player killer = (Player) event.getDamager();
			if (plugin.areAtWar(victim, killer)) {
				victim.sendMessage(ChatColor.RED
						+ "You are being attacked by an enemy: "
						+ killer.getName());
			}
		}
	}

}