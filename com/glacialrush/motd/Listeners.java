package com.glacialrush.motd;

import java.util.Arrays;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketEvent;
import com.comphenix.protocol.wrappers.WrappedServerPing;

public class Listeners
{
	private PacketAdapter packetAdapter;
	private GlacialMotd inst;
	
	public Listeners(GlacialMotd instance)
	{
		this.inst = instance;
		this.packetAdapter = new PacketAdapter((Plugin) this.inst, ListenerPriority.HIGHEST, new PacketType[] {PacketType.Status.Server.OUT_SERVER_INFO})
		{
			
			public void onPacketSending(PacketEvent e)
			{
				if(e.getPacketType() != PacketType.Status.Server.OUT_SERVER_INFO)
				{
					return;
				}
				WrapperStatusServerOutServerInfo packet = new WrapperStatusServerOutServerInfo(e.getPacket());
				WrappedServerPing ping = packet.getJsonResponse();
				ping.setVersionProtocol(3);
				if(Listeners.this.inst.getConfig().getBoolean("show-slots"))
				{
					String names = "\u2771 " + (Arrays.asList(Bukkit.getOnlinePlayers()).size() - 1) + " Online " + "\u2770";
					ping.setVersionName(MOTDUtils.getMOTDToSend(true, names, 0, 0));
				}
				else
				{
					ping.setVersionName(MOTDUtils.getMOTDToSend(false, "", Arrays.asList(Bukkit.getOnlinePlayers()).size(), Bukkit.getMaxPlayers()));
				}
			}
		};
	}
	
	public PacketAdapter getPacketAdapter()
	{
		return this.packetAdapter;
	}
	
}
