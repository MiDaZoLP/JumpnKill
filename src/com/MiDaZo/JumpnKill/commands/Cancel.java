package com.MiDaZo.JumpnKill.commands;

import org.bukkit.entity.Player;

import com.MiDaZo.JumpnKill.JumpnKill;
import com.MiDaZo.JumpnKill.config.Messages;

public class Cancel implements SubCommand {
	
	private Messages msg;

	public Cancel(JumpnKill plugin, Messages msg) {
		this.plugin = plugin;
		this.msg = msg;
	}

	@Override
	public boolean onCommand(Player p, String[] args) {
		String messageprefix = (String) msg.get("messages.prefix");
		if(p.hasPermission("jnk.createlobbysign.cancel")) {
		    if(!plugin.SignPlayers.contains(p.getName())) {
			    p.sendMessage(messageprefix + "&4Du hast nicht '/jnk setsign' ausgeführt!");
		    } else {
		    	plugin.SignPlayers.remove(p.getName());
		    	p.sendMessage(messageprefix + msg.get("messages.canceled"));
		    }
		}
		return false;
	}
	private JumpnKill plugin;
}
