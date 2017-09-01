package com.pzg.www.discord.object;

public class CommandMessage extends Command {
	
	private String message;
	
	public CommandMessage(String label, String message) {
		super(label);
		this.message = message;
	}
	
	public String getReturnMessage() {
		return message;
	}
	
	public void setReturnMessage(String message) {
		this.message = message;
	}
}