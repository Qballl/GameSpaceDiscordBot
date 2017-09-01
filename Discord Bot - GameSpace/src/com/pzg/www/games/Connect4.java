package com.pzg.www.games;

public class Connect4 {
	
	String emptySlot;
	String blueCoin;
	String redCoin;
	
	String board[][];
	
	public Connect4(String emptySlot, String blueCoin, String redCoin) {
		this.emptySlot = emptySlot;
		this.blueCoin = blueCoin;
		int width = 7;
		int height = 6;
		for (int w = 0; w < width; w++) {
			for (int h = 0; h < height; h++) {
				board[w][h] = emptySlot;
			}
		}
	}
	
	public void addRed(int slot) {
		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board[w].length; h++) {
				if (h == slot) {
					if (board[w][h] == emptySlot)
						continue;
					if (board[w][h] == redCoin) {
						if (board[w][h + 1] == emptySlot) {
							board[w][h + 1] = blueCoin;
						}
					}
					if (board[w][h] == blueCoin) {
						if (board[w][h + 1] == emptySlot) {
							board[w][h + 1] = blueCoin;
						}
					}
				}
			}
		}
	}
	
	public void addBlue(int slot) {
		for (int w = 0; w < board.length; w++) {
			for (int h = 0; h < board[w].length; h++) {
				if (h == slot) {
					if (board[w][h] == emptySlot)
						continue;
					if (board[w][h] == redCoin) {
						if (board[w][h + 1] == emptySlot) {
							board[w][h + 1] = blueCoin;
						}
					}
					if (board[w][h] == blueCoin) {
						if (board[w][h + 1] == emptySlot) {
							board[w][h + 1] = blueCoin;
						}
					}
				}
			}
		}
	}
	
	public String board() {
		String board = this.board[0].toString();
		for (int w = 1; w < this.board.length; w++) {
			board = board + "\n" + this.board[w].toString();
		}
		return board;
	}
}