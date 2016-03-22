package com.glacialrush.motd;

import java.util.ArrayList;
import java.util.List;
import net.md_5.bungee.api.ChatColor;

public class CUBungee
{
	public static List<String> color(List<String> strings)
	{
		ArrayList<String> toReturn = new ArrayList<String>();
		for(String s : strings)
		{
			toReturn.add(ChatColor.translateAlternateColorCodes((char) '&', (String) s));
		}
		return toReturn;
	}
	
	public static String strip(String s)
	{
		return ChatColor.stripColor((String) s);
	}
}
