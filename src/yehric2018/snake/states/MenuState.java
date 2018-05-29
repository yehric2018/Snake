package yehric2018.snake.states;

import java.awt.Color;
import java.awt.Graphics;

import yehric2018.snake.Game;
import yehric2018.snake.gfx.Assets;
import yehric2018.snake.objects.Level;
import yehric2018.snake.ui.ClickListener;
import yehric2018.snake.ui.UIImageButton;
import yehric2018.snake.ui.UIManager;

public class MenuState extends State {

	private boolean[][] grid;
	private UIManager uiManager;
	
	public MenuState(Game game) {
		super(game);
		grid = new boolean[Level.GRID_HEIGHT][Level.GRID_WIDTH];
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[0].length; x++) {
				if (x == 0 || y == 0 || y == grid.length - 1 || x == grid[0].length - 1) {
					grid[y][x] = true;
				} else {
					grid[y][x] = false;
				}
			}
		}
		
		uiManager = new UIManager(game);
		game.getMouseManager().setUIManger(uiManager);
		
		uiManager.addObject(new UIImageButton(500, 200, 200, 100, Assets.restart, new ClickListener() {

			@Override
			public void onClick() {
				game.getMouseManager().setUIManger(null);
				State.setState(new GameState(game));
			}}));
	}
	
	@Override
	public void update() {
		uiManager.update();
	}

	@Override
	public void render(Graphics g) {
		for (int y = 0; y < grid.length; y++) {
			for (int x = 0; x < grid[y].length; x++) {
				if (grid[y][x]) {
					g.setColor(Color.RED);
					g.fillRect(x * Level.TILE_SIZE, y * Level.TILE_SIZE, Level.TILE_SIZE, Level.TILE_SIZE);
				}
			}
		}
		uiManager.render(g);
	}

}
