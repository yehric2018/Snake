package yehric2018.snake.states;

import java.awt.Graphics;

import yehric2018.snake.Game;
import yehric2018.snake.objects.Level;

public class GameState extends State {

	private Level level;
	
	public GameState(Game game) {
		super(game);
		level = new Level(game);
	}
	
	@Override
	public void update() {
		level.update();
	}

	@Override
	public void render(Graphics g) {
		level.render(g);
	}

}
