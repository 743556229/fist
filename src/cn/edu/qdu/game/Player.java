package cn.edu.qdu.game;

public abstract class Player {
	private String playName;
	public String getPlayName() {
		return playName;
	}
	public void setPlayName(String playName) {
		this.playName = playName;
	}
	public int getWinningTimes() {
		return winningTimes;
	}
	public void setWinningTimes(int winningTimes) {
		this.winningTimes = winningTimes;
	}
	private int winningTimes;
	public abstract String inputName();
	public abstract int myFist();
}
