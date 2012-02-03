package me.hunterboerner.war;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginDescriptionFile;

public class War extends JavaPlugin {
	private Commands cmds;
	
	@Override
	public void onEnable() {
		cmds = new Commands(this);
		getCommand("war").setExecutor(cmds);
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " Is Enabled " );
		//plugin is being enabled and outputting to the console
	}
	
	@Override
	public void onDisable() {
		
		PluginDescriptionFile pdfFile = this.getDescription();
		System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " Is Disabled " );
		//Same as enable but turns it off
				
	}
}
