package render.model;

import java.awt.image.BufferedImage;

public class Sprite {
	
	private int[] pixels;
	private BufferedImage sprite;
	private int width, height;
	
	Sprite(BufferedImage spriteSheet, int i) {
		
	}
	
	Sprite(BufferedImage image){
		
	}

	public Sprite(int[] pixels, int spriteWidth, int spriteHeight) {
		this.pixels = pixels;
		width = spriteWidth;
		height = spriteHeight;
	}

	public int[] getPixels() {
		return pixels;
	}

	public BufferedImage getSprite() {
		return sprite;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}
