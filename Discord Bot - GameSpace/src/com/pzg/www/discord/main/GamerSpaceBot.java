package com.pzg.www.discord.main;

import java.util.HashMap;
import com.pzg.www.discord.object.Bot;
import com.pzg.www.games.Connect4;
import sx.blah.discord.api.events.EventSubscriber;
import sx.blah.discord.handle.impl.events.guild.member.UserJoinEvent;
import sx.blah.discord.handle.impl.events.guild.member.UserLeaveEvent;
import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IUser;

public class GamerSpaceBot {
	
	public Bot bot;
	
	boolean connect4 = false;
	HashMap<IUser, Boolean> c4Players = new HashMap<IUser, Boolean>();
	Connect4 c4Game;
	
	public GamerSpaceBot(String token, String prefix) {
		bot = new Bot(token, prefix);
		registerBot();
	}
	
	public void registerBot() {
		for (IGuild guild : bot.getBot().getGuilds()) {
			for (IChannel channel : guild.getChannels()) {
				System.out.println(channel.getName() + ": " + channel.getLongID());
			}
		}
		bot.getBot().getDispatcher().registerListener(this);
	}
	
	@EventSubscriber
	public void userJoin(UserJoinEvent event) {
		for (IChannel channel : event.getGuild().getChannels()) {
			if (channel.getName().equalsIgnoreCase("info")) {
				channel.getMessageHistory(1).bulkDelete();
				channel.sendMessage("Current users: " + event.getGuild().getUsers().size());
			}
		}
	}
	
	@EventSubscriber
	public void userLeave(UserLeaveEvent event) {
		for (IChannel channel : event.getGuild().getChannels()) {
			if (channel.getName().equalsIgnoreCase("info")) {
				channel.getMessageHistory(1).bulkDelete();
				channel.sendMessage("Current users: " + event.getGuild().getUsers().size());
			}
		}
	}
}