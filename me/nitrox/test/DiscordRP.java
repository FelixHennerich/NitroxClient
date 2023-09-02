package me.nitrox.test;

import net.arikia.dev.drpc.DiscordEventHandlers;
import net.arikia.dev.drpc.DiscordRPC;
import net.arikia.dev.drpc.DiscordRichPresence;
import net.arikia.dev.drpc.DiscordUser;
import net.arikia.dev.drpc.callbacks.ReadyCallback;

public class DiscordRP {
	
	private boolean running = true;
	private long create = 0;
	
	public void start() {
		
	    this.create = System.currentTimeMillis();
	    
	    DiscordEventHandlers handlers = new DiscordEventHandlers.Builder().setReadyEventHandler(new ReadyCallback() {
			
			@Override
			public void apply(DiscordUser user) {
				update("Booting up...", "");
				
			}
		}).build();
		
	    DiscordRPC.discordInitialize("744908690171232256", handlers, true);
	    
	    new Thread("Discord RPC Callback") {
	    	@Override
	    	public void run() {
	    		while(running) {
	    			DiscordRPC.discordRunCallbacks();
	    		}
	    	}
	    }.start();
	    
	}
	
	public void shutdown() {
		running = false;
		DiscordRPC.discordShutdown();
	}
	
	public void update(String first, String second) {
		DiscordRichPresence.Builder b = new DiscordRichPresence.Builder(second);
		b.setBigImage("large", "");
		b.setDetails(first);
		b.setStartTimestamps(create);
		
		DiscordRPC.discordUpdatePresence(b.build());
	}

}
