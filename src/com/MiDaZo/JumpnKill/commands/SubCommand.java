package com.MiDaZo.JumpnKill.commands;

import org.bukkit.entity.Player;

public interface SubCommand {
	
	public abstract boolean onCommand(Player p, String args[]);

}
