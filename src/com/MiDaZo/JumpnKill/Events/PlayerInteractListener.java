package com.MiDaZo.JumpnKill.Events;


import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import com.MiDaZo.JumpnKill.JumpnKill;
import com.MiDaZo.JumpnKill.config.Messages;
import com.MiDaZo.JumpnKill.config.Positions;

public class PlayerInteractListener implements Listener {

	private Positions pos;
	private Messages msg;
	
	public PlayerInteractListener(JumpnKill plugin, Positions pos, Messages msg) {
		this.plugin = plugin;
		this.pos = pos;
		this.msg = msg;
	}
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		Player p = event.getPlayer();
		String messageprefix = (String)msg.get("messages.prefix");
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if(event.getClickedBlock().getState() instanceof Sign) {
				Sign s = (Sign)event.getClickedBlock().getState();
				if(s.getLine(0).equalsIgnoreCase("[JNK]")) {
					if(s.getLine(1).equalsIgnoreCase("Arena")) {
						String arena = s.getLine(2);
						if(pos.isSet("arenas." + arena + ".lobby.x") &&
								pos.isSet("arenas." + arena + ".lobby.y") &&
								pos.isSet("arenas." + arena + ".lobby.z") &&
								pos.isSet("arenas." + arena + ".lobby.world") &&
								pos.isSet("arenas." + arena + ".spawn.x") &&
								pos.isSet("arenas." + arena + ".spawn.y") &&
								pos.isSet("arenas." + arena + ".spawn.z") &&
								pos.isSet("arenas." + arena + ".spawn.world")) {
							
						} else {
							p.sendMessage(messageprefix + "§4Die Arena hat einen Fehler oder exestiert nicht!");
						}
					}
				}
			}
		}
	}
		private JumpnKill plugin;
}
