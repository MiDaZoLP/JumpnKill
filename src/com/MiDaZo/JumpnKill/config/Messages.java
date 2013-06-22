package com.MiDaZo.JumpnKill.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.MiDaZo.JumpnKill.JumpnKill;

public class Messages {

	File f;
	FileConfiguration fc;
	private JumpnKill plugin;
	
	public Messages(JumpnKill plugin) {
		this.plugin = plugin;
		manage();
	}
	@SuppressWarnings("static-access")
	public void manage() {
		f = new File(plugin.getDataFolder() + File.separator + "messages.yml");
		fc = new YamlConfiguration().loadConfiguration(f);
		fc.addDefault("messages.prefix", "&c[&4JNK&c]");
		fc.addDefault("messages.nopermission", "&4Du hast keine Rechte, um dies zu tun!");
		fc.addDefault("messages.signset", "&4Du hast erfolgreich ein Lobbyschild erstellt!");
		fc.addDefault("messages.arenaset", "&4Du hast erfolgreich eine Arena gesetzt!");
		fc.addDefault("messages.arenalobbyset", "&4Du hast erfolgreich den Spawn für %arena% gesetzt!");
		fc.addDefault("messages.commandnotexist", "&4Dieses Kommando existiert nicht!");
		fc.addDefault("messages.canceled", "&4Du hast den Vorgang erfolgreich abgebrochen!");
		fc.addDefault("messages.needrightclick", "&4Du musst jetzt ein Schild mit der richtigen Aufschrift rechtsklicken um ein Lobbyschild zu erstellen oder gib '/jnk cancel' ein!");
		fc.addDefault("messages.arenaspawnteamset", "&4Du hast erfolgreich den Spawn für das Team %team% gesetzt!");
	}
	public Object get(String path) {
		return fc.get(path);
	}
}
