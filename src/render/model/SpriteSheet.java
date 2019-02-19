package render.model;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	
	private BufferedImage spriteSheet;
	private Sprite[] sprites;
	private int[] pixels;
	private int spriteWidth, spriteHeight;
	private boolean loaded;
	
	public SpriteSheet(String url, int tileWidth, int tileHeight) throws IOException{
		//loadSpriteSheet(url);
		
		this.spriteWidth = tileWidth;
		this.spriteHeight = tileHeight;
		
		loaded = false;
	}
	
	public SpriteSheet(BufferedImage spriteSheet, int spriteWidth, int spriteHeight, boolean load) {
		
		this.spriteWidth = spriteWidth;
		this.spriteHeight = spriteHeight;
		this.spriteSheet = spriteSheet;
		
		if(load)
			load(spriteSheet, spriteWidth, spriteHeight);
	}
	
	public void load(BufferedImage spriteSheet, int spriteWidth, int spriteHeight) {
		sprites = new Sprite[(spriteSheet.getWidth() / spriteWidth) * (spriteSheet.getHeight() / spriteHeight)];
		
		int spriteIndex = 0;
		for(int i = 0; i < spriteSheet.getWidth(); i = i + spriteWidth) 
			for(int j = 0; j < spriteSheet.getHeight(); j = j + spriteHeight)
				sprites[spriteIndex++] = new Sprite(
						spriteSheet.getRGB(i, j, spriteWidth, spriteHeight, null, 0, spriteWidth), spriteWidth, spriteHeight);
		
		loaded = true;
	}
	
	public void testLoad(BufferedImage spriteSheet, int spriteWidth, int spriteHeight) {
		sprites = new Sprite[1];
		sprites[0] = new Sprite(spriteSheet.getRGB(0, 0, 64, 64, null, 0, 64), 64, 64);
	}

	public BufferedImage getSpriteSheet() {
		return spriteSheet;
	}

	public void setSpriteSheet(BufferedImage spriteSheet) {
		this.spriteSheet = spriteSheet;
	}

	public int[] getPixels() {
		return pixels;
	}

	public void setPixels(int[] pixels) {
		this.pixels = pixels;
	}

	public int getTileWidth() {
		return spriteWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.spriteWidth = tileWidth;
	}

	public int getTileHeight() {
		return spriteHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.spriteHeight = tileHeight;
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	public void setSprites(Sprite[] sprites) {
		this.sprites = sprites;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public void setSpriteWidth(int spriteWidth) {
		this.spriteWidth = spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}

	public void setSpriteHeight(int spriteHeight) {
		this.spriteHeight = spriteHeight;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	
}
