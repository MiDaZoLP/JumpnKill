package com.MiDaZo.JumpnKill;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.entity.Player;

import com.MiDaZo.JumpnKill.config.Messages;
import com.MiDaZo.JumpnKill.config.Positions;

public class GameManager {

	private Positions pos;
	private Messages msg;

	private GameManager(JumpnKill plugin, Positions pos, Messages msg){
		this.plugin = plugin;
		this.msg = msg;
		this.pos = pos;
		games = new ArrayList<Object>();
		PGL = new HashMap<String, String>();
	}
	public void addPlayer(Player p, String Arena) {
		if(pos.isSet("arenas." + Arena + ".lobby.x") &&
				pos.isSet("arenas." + Arena + ".lobby.y") &&
				pos.isSet("arenas." + Arena + ".lobby.z") &&
				pos.isSet("arenas." + Arena + ".lobby.world") &&
				pos.isSet("arenas." + Arena + ".spawn.x") &&
				pos.isSet("arenas." + Arena + ".spawn.y") &&
				pos.isSet("arenas." + Arena + ".spawn.z") &&
				pos.isSet("arenas." + Arena + ".spawn.world")) {
			PGL.put(p.getName(), Arena);
		}
		else {
			p.sendMessage(msg.get("messages.prefix") + "§4Diese Arena hat einen Fehler oder exestiert nicht!");
		}
	}
	public boolean isPlayerIngame(Player p) {
		return PGL.containsKey(p.getName());
	}
	public void addArena(int Arena) {
		if(games.contains(Arena)) {}
		else{
	        games.add(Arena);
		}
	}
    public void RemovePlayer(Player p) {
    	PGL.remove(p.getName());
    }
    public void reloadGames() {
    	LoadGames();
    }
    public void LoadGames() {
    	games.clear();
    	int loaded = 0;
    	int no = (Integer)pos.get("totalarenas");
    	for(int a = 1; loaded < no; a++) {
    		if(pos.isSet("arenas." + a + ".lobby.x") &&
    				pos.isSet("arenas." + a + ".lobby.y") &&
    				pos.isSet("arenas." + a + ".lobby.z") &&
    				pos.isSet("arenas." + a + ".lobby.world") &&
    				pos.isSet("arenas." + a + ".spawn.x") &&
    				pos.isSet("arenas." + a + ".spawn.y") &&
    				pos.isSet("arenas." + a + ".spawn.z") &&
    				pos.isSet("arenas." + a + ".spawn.world")) {
    			System.out.println("[JNK] Lädt Arena: " + a);
    			loaded++;
    			games.add(a);
    			System.out.println("[JNK] Erfolgreich geladen.");
    		}
    	}
    }
		private JumpnKill plugin;
		private HashMap<String, String> PGL;
		private ArrayList<Object> games;
}
