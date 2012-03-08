package me.hunterboerner.war;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class Commands implements CommandExecutor {
	
	private War plugin;
	
	public Commands(War war) {
		this.plugin	=	war;
	}


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,String[] args) { 
		if(cmd.getName().equalsIgnoreCase("war")){
			if(!(sender instanceof Player)){
				plugin.logMessage("Only a player may use the war command.");
			}else{
				Player player = (Player) sender;
				if(player.hasPermission("war.commands")){
					if(args.length==0){
						player.sendMessage(ChatColor.RED + "No argument specified");
						return false;
					}
					
					if(args[0].equals("declare")){
						if(args.length==2){
							player.sendMessage(ChatColor.RED + "You have declared war on " + args[1]);
							player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has declared war on " + args[1]);
							plugin.logMessage(player.getDisplayName() + " used "  + "/war " + args[0] + " on " + args[1]);
						}else{
							player.sendMessage("A target must be specified when declaring war!");
							return false;
						}
					}else if(args[0].equals("world")){
						player.sendMessage(ChatColor.RED + "You have started a world war!");
						player.getServer().broadcastMessage(ChatColor.RED + player.getDisplayName() + " has started a world war!");
						plugin.logMessage(player.getDisplayName() + " used " + "/war " + args[0]);
					}else if(args[0].equals("truce")){
						if(args.length==2){
							player.sendMessage(ChatColor.GREEN + "You have made peace with " + args[1]);
							player.getServer().broadcastMessage(ChatColor.GREEN + player.getDisplayName() + " has made peace with " + args[1]);
							plugin.logMessage(player.getDisplayName() + " used "  + "/war " + args[0] + " on " + args[1]);
						}else{
							player.sendMessage("A target must be specified when declaring a truce!");
							return false;
						}
					}
				}else{
					player.sendMessage(ChatColor.RED + "Permission denied" );
				}
							
			}
		}
		return true;
		
	}
}
