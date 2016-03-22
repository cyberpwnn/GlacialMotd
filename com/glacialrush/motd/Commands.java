package com.glacialrush.motd;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Commands implements CommandExecutor
{
	public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args)
	{
		if(args.length == 0)
		{
			sender.sendMessage("\u00a77LeftMOTD - \u00a78MOTD on the left side of server.");
			sender.sendMessage("\u00a77Plugin created by su1414.");
			sender.sendMessage("\u00a7a#\u00a7e-----\u00a76COMMANDS\u00a7e-----");
			sender.sendMessage("\u00a7a#/LeftMOTD reload - \u00a72Reloads the config file.");
			sender.sendMessage("\u00a7a#/LeftMOTD add - \u00a72Adds MOTD to config. \u00a77(\u00a78Not working yet!\u00a77)");
			sender.sendMessage("\u00a7a#/LeftMOTD remove - \u00a72Removes MOTD from config. \u00a77(\u00a78Not working yet!\u00a77)");
			sender.sendMessage("\u00a7a#\u00a7e-----\u00a76COMMANDS\u00a7e-----");
			return false;
		}
		if(!sender.hasPermission("gmotd.*"))
		{
			sender.sendMessage("\u00a74You don't have permission.");
			return false;
		}
		if(args[0].equalsIgnoreCase("reload"))
		{
			GlacialMotd.getInst().reloadCfg();
			sender.sendMessage("\u00a7aReload complete.");
		}
		return false;
	}
}
