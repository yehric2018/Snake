package yehric2018.snake.ui;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import yehric2018.snake.Game;

public class UIManager {
	
	private Game game;
	private ArrayList<UIObject> objects;
	
	public UIManager(Game game) {
		this.game = game;
		objects = new ArrayList<UIObject>();
	}
	
	public void update() {
		for (UIObject o : objects) {
			o.update();
		}
	}
	public void render(Graphics g) {
		for (UIObject o : objects) {
			o.render(g);
		}
	}
	public void onMouseMove(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseMove(e);
		}
	}
	public void onMouseRelease(MouseEvent e) {
		for (UIObject o : objects) {
			o.onMouseRelease(e);
		}
	}
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public ArrayList<UIObject> getObjects() {
		return objects;
	}

	public void setObjects(ArrayList<UIObject> objects) {
		this.objects = objects;
	}

	public void addObject(UIObject o) {
		objects.add(o);
	}
	public void removeObjects(UIObject o) {
		objects.remove(o);
	}
}
