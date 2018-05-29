package yehric2018.snake.gfx;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

import yehric2018.snake.objects.Level;

public class Display {
	private JFrame frame;
	private Canvas canvas;
	
	public Display(String title, int width, int height) {
		init(title, width, height);
	}
	private void init(String title, int width, int height) {
		frame = new JFrame();
		frame.setSize(new Dimension(Level.GRID_WIDTH * Level.TILE_SIZE + 6, Level.GRID_HEIGHT * Level.TILE_SIZE + 36));
		frame.setTitle(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		canvas = new Canvas();
		canvas.setBounds(0, 0, Level.GRID_WIDTH * Level.TILE_SIZE + 6, Level.GRID_HEIGHT * Level.TILE_SIZE + 36);
		canvas.setMaximumSize(new Dimension(Level.GRID_WIDTH * Level.TILE_SIZE + 6, Level.GRID_HEIGHT * Level.TILE_SIZE + 36));
		canvas.setMinimumSize(new Dimension(Level.GRID_WIDTH * Level.TILE_SIZE + 6, Level.GRID_HEIGHT * Level.TILE_SIZE + 36));
		canvas.setBackground(Color.BLUE);
		canvas.setFocusable(false);
		
		frame.add(canvas);
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	public JFrame getFrame() {
		return frame;
	}
}
