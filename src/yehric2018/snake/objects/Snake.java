package yehric2018.snake.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import yehric2018.snake.Game;
import yehric2018.snake.states.MenuState;
import yehric2018.snake.states.State;

public class Snake {
	
	private ArrayList<Point> body;
	private boolean activated;
	private Game game;
	
	//0 = up, 1 = down, 2 = left, 3 = right
	private int direction;
	private int next;
	
	private int speed;
	private int wait;
	
	private Food food;
	private int growth;
	
	public Snake(Game game) {
		body = new ArrayList<Point>();
		body.add(new Point(4, 4));
		activated = false;
		this.game = game;
		
		direction = 5;
		next = 5;
		
		speed = 1;
		wait = 0;
		
		food = new Food(body);
		growth = 0;
	}
	
	public void update() {
		if (isDead()) {
			State.setState(new MenuState(game));
		}
		
		//Update the direction
		if (game.getKeyManager().up) {
			if (direction != 1) {
				next = 0;
			}
		} else if (game.getKeyManager().down) {
			if (direction != 0) {
				next = 1;
			}
		} else if (game.getKeyManager().right) {
			if (direction != 2) {
				next = 3;
			}
		} else if (game.getKeyManager().left) {
			if (direction != 3) {
				next = 2;
			}
		}													
		
		if (!activated) {
			activated = checkActivated();
		} else {
			if (wait == speed) {
				Point head = body.get(body.size() - 1);
				if (next != direction) {
					direction = next;
				}
				if (direction == 0) {
					body.add(new Point(head.x, head.y - 1));
				} else if (direction == 1) {
					body.add(new Point(head.x, head.y + 1));
				} else if (direction == 2) {
					body.add(new Point(head.x - 1, head.y));
				} else if (direction == 3) {
					body.add(new Point(head.x + 1, head.y));
				}
				
				if (growth == 0) {
					body.remove(0);
				} else {
					growth--;
				}
				wait = 0;
				if (head.equals(new Point(food.getX(), food.getY()))) {
					growth = 30;
					food = new Food(body);
				}
			}
			wait++;
		}
	}
	public void render(Graphics g) {
		food.render(g);
		for (int i = 0; i < body.size(); i++) {
			g.setColor(Color.YELLOW);
			g.fillRect(body.get(i).x * Level.TILE_SIZE, body.get(i).y * Level.TILE_SIZE, Level.TILE_SIZE, Level.TILE_SIZE);
			g.setColor(Color.BLACK);
			g.drawRect(body.get(i).x * Level.TILE_SIZE, body.get(i).y * Level.TILE_SIZE, Level.TILE_SIZE, Level.TILE_SIZE);
		}
	}
	private boolean checkActivated() {
		if (next >= 0 && next <= 3) {
			System.out.println("ACTIVATED");
			direction = next;
			return true;
		}
		return false;
	}
	private boolean isDead() {
		Point a = body.get(body.size() - 1);
		if (a.y == 0 || a.x == 0 || a.y == Level.GRID_HEIGHT - 1 || a.x == Level.GRID_WIDTH - 1) {
			return true;
		}
		for (int i = 0; i < body.size() - 1; i++) {
			if (a.equals(body.get(i))) {
				return true;
			}
		}
		return false;
	}
}
class Point {
	public int x;
	public int y;
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public boolean equals(Point b) {
		if (this.x == b.x && this.y == b.y) {
			return true;
		}
		return false;
	}
}
