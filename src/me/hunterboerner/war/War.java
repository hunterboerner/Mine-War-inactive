package me.hunterboerner.war;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class War extends JavaPlugin {
	private Logger log		=	Logger.getLogger("Minecraft");
	private Commands cmds	=	new Commands(this);;

	@Override
	public void onEnable() {
		getCommand("war").setExecutor(cmds);
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pdfFile.getName() + " version "
				+ pdfFile.getVersion() + " Is Enabled ");
		// plugin is being enabled and outputting to the console
	}

	@Override
	public void onDisable() {

		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println(pdfFile.getName() + " version "
				+ pdfFile.getVersion() + " Is Disabled ");
		// Same as enable but turns it off

	}
	
	public void logMessage(String msg){
		PluginDescriptionFile pdFile	=	this.getDescription();
		log.info("["+pdFile.getName()+" "+pdFile.getVersion()+"]: "+msg);
	}
}
