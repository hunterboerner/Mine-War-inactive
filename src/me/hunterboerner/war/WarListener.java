package me.hunterboerner.war;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

public class WarListener implements Listener {

	private War plugin;
	
	public WarListener(War plugin){
		this.plugin	=	plugin;
	}
	
	@EventHandler
	public void onPlayerDeath(EntityDeathEvent event){
		if(event instanceof PlayerDeathEvent){
			Player victim 	= 	(Player) event.getEntity();
			Player killer	=	victim.getKiller();
			if(plugin.areAtWar(victim, killer)){
				((PlayerDeathEvent) event).setDeathMessage(ChatColor.DARK_PURPLE + "War has claimed another life. "+ChatColor.WHITE+victim.getDisplayName()+ChatColor.DARK_PURPLE + " was slain by "+ChatColor.WHITE + killer.getDisplayName()+ChatColor.DARK_PURPLE + ".");
			}
		}
	}
}