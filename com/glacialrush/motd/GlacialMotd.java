package com.glacialrush.motd;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;
import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.PacketListener;

public class GlacialMotd extends JavaPlugin
{
	private ProtocolManager protocolManager;
	private static GlacialMotd inst;
	
	public void onLoad()
	{
		this.protocolManager = ProtocolLibrary.getProtocolManager();
	}
	
	public void onEnable()
	{
		inst = this;
		this.getCommand("gmotd").setExecutor((CommandExecutor) new Commands());
		
		this.saveDefaultConfig();
		this.reloadCfg();
		this.protocolManager.addPacketListener((PacketListener) new Listeners(this).getPacketAdapter());
	}
	
	public static GlacialMotd getInst()
	{
		return inst;
	}
	
	public void reloadCfg()
	{
		this.reloadConfig();
		MOTDUtils.setMotds(ColorUtils.color(this.getConfig().getStringList("motds")));
	}
}
