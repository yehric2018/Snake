package yehric2018.snake.gfx;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage restart;
	
	public static void init() {
		restart = ImageLoader.loadImage("/textures/replay.png");
	}
}
