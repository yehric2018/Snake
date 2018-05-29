package yehric2018.snake.states;

import java.awt.Graphics;

import yehric2018.snake.Game;

public abstract class State {
	
	private static State currentState = null;
	
	public static void setState(State state) {
		currentState = state;
	}
	public static State getState() {
		return currentState;
	}
	
	//CLASS
	protected Game game;
	
	public State(Game game) {
		this.game = game;
	}
	
	public abstract void update();
	public abstract void render(Graphics g);
}
