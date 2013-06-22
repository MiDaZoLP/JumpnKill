package com.MiDaZo.JumpnKill.commands;

import org.bukkit.entity.Player;

import com.MiDaZo.JumpnKill.JumpnKill;
import com.MiDaZo.JumpnKill.config.Messages;

public class SetSign implements SubCommand {

	public SetSign(JumpnKill plugin, Messages msg) {
		this.plugin = plugin;
		this.msg = msg;
	}

	@Override
	public boolean onCommand(Player p, String args[]) {
		    String messageprefix = (String) msg.get("messages.prefix");
		    if(!p.hasPermission("jnk.createlobbysign") && !p.isOp()) {
		    	p.sendMessage(messageprefix + msg.get("messages.nopermission"));
		    	return true;
		    } else {
		    	p.sendMessage(messageprefix + msg.get("messages.needrightclick"));
		    	plugin.SignPlayers.add(p.getName());
		    }
		return false;
	}
	private JumpnKill plugin;
	private Messages msg;
}
