package com.glacialrush.motd;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.events.PacketContainer;

public class WrapperStatusServerOutPing extends AbstractPacket
{
	public static final PacketType TYPE = PacketType.Status.Server.OUT_PING;
	
	public WrapperStatusServerOutPing()
	{
		super(new PacketContainer(TYPE), TYPE);
		this.handle.getModifier().writeDefaults();
	}
	
	public WrapperStatusServerOutPing(PacketContainer packet)
	{
		super(packet, TYPE);
	}
	
	public long getTime()
	{
		return (Long) this.handle.getLongs().read(0);
	}
	
	public void setTime(long value)
	{
		this.handle.getLongs().write(0, (Long) value);
	}
}
