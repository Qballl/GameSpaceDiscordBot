package com.pzg.www.discord.object;

import java.util.List;

import sx.blah.discord.handle.obj.IChannel;
import sx.blah.discord.handle.obj.IGuild;
import sx.blah.discord.handle.obj.IMessage;
import sx.blah.discord.handle.obj.IUser;
import sx.blah.discord.handle.obj.Permissions;
import sx.blah.discord.util.PermissionUtils;

public class CommandMethod extends Command {
	
	private Method method;
	private String permission;
	
	public CommandMethod(String label, String permission, Method method) {
		super(label);
		this.method = method;
		this.permission = permission;
	}
	
	public void runCommand(IUser user, IChannel channel, IGuild guild, String label, List<String> args, IMessage message) {
		if (permission.isEmpty() || permission == null || permission == "") {
			method.method(user, channel, guild, label, args, message);
			return;
		}
		if (PermissionUtils.hasPermissions(channel, user, Permissions.valueOf(permission))) {
			method.method(user, channel, guild, label, args, message);
			return;
		} else channel.sendMessage("Sorry " + user.mention() + " you don't have the permissions needed for that.");
	}
	
	public void runCommand(IUser user, IChannel channel, IGuild guild, String label, List<String> args) {
		if (permission.isEmpty() || permission == null || permission == "") {
			method.method(user, channel, guild, label, args);
			return;
		}
		if (PermissionUtils.hasPermissions(channel, user, Permissions.valueOf(permission))) {
			method.method(user, channel, guild, label, args);
			return;
		} else channel.sendMessage("Sorry " + user.mention() + " you don't have the permissions needed for that.");
	}
}