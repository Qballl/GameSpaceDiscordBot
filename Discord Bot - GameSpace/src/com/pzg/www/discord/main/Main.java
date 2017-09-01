package com.pzg.www.discord.main;

import java.util.Scanner;

public class Main {
	
	public static GamerSpaceBot gsBot;
	
	public static boolean running;
	
	public static void main(String[] args) {
		running = true;
		
		gsBot = new GamerSpaceBot("MzUxODY3NjIwNTIzMjQ1NTc4.DIY-CA.NqNSrxdF4k8nM4jt5dZraQPuEDA", "!");
		
		Scanner scan = new Scanner(System.in);
		while (running) {
			if (scan.nextLine().equalsIgnoreCase("stop")) {
				System.out.println("Stopping the bots.");
				running = false;
				gsBot.bot.getBot().logout();
				scan.close();
			}
		}
	}
}