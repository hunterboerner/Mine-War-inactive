package me.hunterboerner.war;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class Commands implements CommandExecutor {
	public Commands(War war) {
	}
	public void cmds(War plugin) {
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) { 
		if(cmd.getName().equalsIgnoreCase("war")){ //if the player typed /war, do the following
			Logger log = Logger.getLogger("Minecraft");
			Player player = (Player) sender;
				if (!(sender instanceof Player)) {
					sender.sendMessage("This Command can only be run by a player!");
					
				return true;
				}
				
				
				 
				//player.sendMessage(ChatColor.RED + "You have made " + "" + " An Ememy of you!");
				//return true;
				
				if (args.length == 0 ) {
				player.sendMessage(ChatColor.RED + "Need to add declare after /war");
				// if you haven't put anything in, then it tells you that
				return true;
				}
				else if (args[0].equals("declare")) {
					if (args.length == 2){
						player.sendMessage(ChatColor.RED + "You have declared war on " + args[1]);
						player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has declared war on " + args[1]);
						log.info("[War] " + player.getDisplayName() + " used "  + "/war " + args[0] + " on " + args[1]);
				return true;
					}
					else {
						player.sendMessage("Error, incorrect!");
					}
					//end of declare
					
					
				return true;
				}
				else if (args[0].equals("world")) {
					player.sendMessage(ChatColor.RED + "You have started a world war!");
					player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has started a world war!");
					log.info("[War] " + player.getDisplayName() + " used " + "/war " + args[0]);
					return true;
				}
				//end of world
				
		// if this happened the function will break and return true. Otherwise it will go to false.
		}
		return false;
	}
}

