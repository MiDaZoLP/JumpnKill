package com.MiDaZo.JumpnKill;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import com.MiDaZo.JumpnKill.commands.SetSign;
import com.MiDaZo.JumpnKill.commands.SubCommand;
import com.MiDaZo.JumpnKill.config.Messages;

public class CommandHandler implements CommandExecutor {

	private Messages msg;
	
	public CommandHandler(JumpnKill plugin, Messages msg) {
		this.msg = msg;
		this.plugin = plugin;
		commands = new HashMap<Object, Object>();
		loadCommands();
	}
	
	private void loadCommands() {
		commands.put("setsign", new SetSign(plugin, msg));
	}
//----------------------------------------------------------------
	@Override
	public boolean onCommand(CommandSender sender, Command cmd1, String commandLabel, String args[]) {
		String messageprefix = (String)msg.get("messages.prefix");
		String cmd = cmd1.getName();
		Player p = null;
		if(sender instanceof Player) {
			p = (Player)sender;
		} else {
			sender.sendMessage("[JNK] Nur Ingamespieler können JumpnKill Kommandos benutzen!");
			return true;
		}
		if(cmd.equalsIgnoreCase("jnk")) {
			if(args == null || args.length < 1) {
				p.sendMessage("§6JumpnKill - §lMiDaZoLP");
				p.sendMessage("§6Gib '/jnk help' für die Hilfe ein");
				return true;
			}
		}
		String sub = args[1];
		Vector<String> l = new Vector<String>();
		l.addAll(Arrays.asList(args));
		l.remove(0);
		args = (String[])l.toArray(new String[0]);
		if(!commands.containsKey(sub)) {
			p.sendMessage(messageprefix + msg.get("messages.commandnotexist"));
			p.sendMessage("§6Gib '/jnk help' für die Hilfe ein!");
			return true;
		} try {
			((SubCommand)commands.get(sub)).onCommand(p, args);
		} catch(Exception e) {
			e.printStackTrace();
			p.sendMessage(messageprefix + "§4Ein Fehler ist aufgetreten, bitte wende dich an einen Admin!");
			p.sendMessage(messageprefix + ChatColor.RED + "Gib '/jnk help' für die Hilfe ein!");
		}
		
		return false;
	}
	//----------------------------------------------------------------
	private JumpnKill plugin;
	private HashMap<Object, Object> commands;
}
