package yehric2018.snake;

import yehric2018.snake.objects.Level;

public class Launcher {
	public static void main(String[] args) {
		Game game = new Game("Snake", Level.GRID_WIDTH * Level.TILE_SIZE, Level.GRID_HEIGHT * Level.TILE_SIZE);
		game.start();
	}
}
