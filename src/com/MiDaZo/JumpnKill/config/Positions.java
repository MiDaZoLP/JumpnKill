package com.MiDaZo.JumpnKill.config;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.MiDaZo.JumpnKill.JumpnKill;

public class Positions {
	
	File f;
	FileConfiguration fc;
	private JumpnKill plugin;
	
	public Positions(JumpnKill plugin, Messages msg) {
		this.plugin = plugin;
		manage();
	}
	@SuppressWarnings("static-access")
	private void manage() {
		f = new File(plugin.getDataFolder() + File.separator + "System.yml");
		fc = new YamlConfiguration().loadConfiguration(f);
		fc.addDefault("totalarenas", 0);
	}
	public Object get(String path) {
		return fc.get(path);
	}
	public void set(String path, String value) {
		fc.addDefault(path, value);
	}
	public boolean isSet(String path) {
		return fc.isSet(path);
	}
}
