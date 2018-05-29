package yehric2018.snake.objects;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.snake.Game;

public class Level {
	public static final int GRID_WIDTH = 90, GRID_HEIGHT = 60;
	public static final int TILE_SIZE = 15;
	
	private boolean[][] grid;
	private Snake snake;
	
	public Level(Game game) {
		grid = new boolean[GRID_HEIGHT][GRID_WIDTH];
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				if (x == 0 || y == 0 || y == grid.length - 1 || x == grid[0].length - 1) {
					grid[y][x] = true;
				} else {
					grid[y][x] = false;
				}
			}
		}
		snake = new Snake(game);
	}
	public void update() {
		snake.update();
	}
	public void render(Graphics g) {
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x]) {
					g.setColor(Color.RED);
					g.fillRect(x * TILE_SIZE, y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
				}
			}
		}
		snake.render(g);
	}
}
