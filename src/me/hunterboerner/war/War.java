package me.hunterboerner.war;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.entity.Player;

public class War extends JavaPlugin {
	private Logger log							=	Logger.getLogger("Minecraft");
	private Commands cmds						=	new Commands(this);
	private Map<Player,Set<Player>> warMongers	=	Collections.synchronizedMap(new HashMap<Player,Set<Player>>());

	@Override
	public void onEnable() {
		getCommand("war").setExecutor(cmds);
		logMessage("Enabled");
		// plugin is being enabled and outputting to the console
	}

	@Override
	public void onDisable() {
		logMessage("Disabled");
		// Same as enable but turns it off

	}
	
	public void logMessage(String msg){
		PluginDescriptionFile pdFile	=	this.getDescription();
		log.info("["+pdFile.getName()+" "+pdFile.getVersion()+"]: "+msg);
	}
	
	
	/**
	 * Adds a war to the player's set of wars
	 * 
	 * @param monger The person initiating the war
	 * @param target The person upon which the war is being declared
	 * @return boolean True if the war was added, false if it was already there
	 */
	public boolean addWar(Player monger,Player target){
		if(!warMongers.containsKey(monger)){
			warMongers.put(monger, Collections.synchronizedSet(new HashSet<Player>()));
		}
		return warMongers.get(monger).add(target);
	}
	
	/**
	 * Removes a war from the player's set of wars
	 * 
	 * @param monger The person who initiated the war
	 * @param target The person upon which the war was declared
	 * @return boolean True if the war was removed, false if it was never there
	 */
	public boolean removeWar(Player monger, Player target){
		if(warMongers.containsKey(monger)){
			return warMongers.get(monger).remove(target);
		}
		return false;
	}
}
