package yehric2018.snake.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Food {
	private int x, y;
	
	public Food(ArrayList<Point> body) {
		boolean occupied = true;
		do {
			x = (int) (Math.random() * (Level.GRID_WIDTH - 2) + 1);
			y = (int) (Math.random() * (Level.GRID_HEIGHT - 2) + 1);
			occupied = false;
			for (int i = 0; i < body.size(); i++) {
				if (body.get(i).equals(new Point(x, y))) {
					occupied = true;
				}
			}
		} while (occupied);
	}
	
	public void update() {}
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x * Level.TILE_SIZE, y * Level.TILE_SIZE, Level.TILE_SIZE, Level.TILE_SIZE);
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
}
