package com.glacialrush.motd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MOTDUtils
{
	private static List<String> motds;
	private static final Random RAND;
	
	static
	{
		RAND = new Random();
	}
	
	public static String getMOTDToSend(boolean customSlots, String versionName, int players, int maxPlayers)
	{
		String MOTD = motds.get(RAND.nextInt(motds.size()));
		String s = "";
		s = String.valueOf(s) + MOTD;
		if(customSlots)
		{
			int i = 0;
			while(i < 95 - ColorUtils.strip(versionName).length())
			{
				s = String.valueOf(s) + " ";
				++i;
			}
			s = String.valueOf(s) + versionName;
		}
		else
		{
			String slots = "\u00a77" + players + "\u00a78/\u00a77" + maxPlayers;
			int i = 0;
			while(i < 95 - ColorUtils.strip(slots).length())
			{
				s = String.valueOf(s) + " ";
				++i;
			}
			s = String.valueOf(s) + slots;
		}
		return s;
	}
	
	public static void setMotds(List<String> motd)
	{
		motds = null;
		motds = new ArrayList<String>();
		motds = motd;
	}
}
