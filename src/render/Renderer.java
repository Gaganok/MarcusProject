package render;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import render.model.Sprite;
import render.model.SpriteSheet;
import render.model.Tile;
import service.DIService;
import service.ImageService;

public class Renderer {
	private SpriteSheet dungeonSheet;
	private BufferedImage view;
	private int[] pixels;

	int color = 0;

	public Renderer(int WIDTH, int HEIGHT) throws IOException{
		view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
		
		dungeonSheet = new SpriteSheet(
				ImageService.loadImage(System.getProperty("user.dir") + "/src/resourses/spritesheets/spritesheet.png"), 32, 32, true);
	}

	public void render() {
		BufferStrategy bs = DIService.bs;
		Graphics g = bs.getDrawGraphics();

		g.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
		g.dispose();

		bs.show();
	}

	public void update() throws IOException {
		Tile tile = new Tile(dungeonSheet.getSprites()[19], 200, 200);
		
		//drawTile(tile);
		fillView(tile);
		view.getGraphics().drawImage(dungeonSheet.getSprites()[0].getSprite(), 0, 0, null);
	}
	
	private void drawTile(Tile tile) {
		drawSprite(tile.getSprite(), tile.getPosX(), tile.getPosY());
	}
	
	private void drawSprite(Sprite sprite, int x, int y) {
		int[] spritePixels = sprite.getPixels();
		
		for(int i = 0; i < sprite.getHeight(); i++) {
			for(int j = 0; j < sprite.getWidth(); j++) {
				pixels[j + i * view.getWidth() + x + (y * view.getWidth())] = spritePixels[j + i * sprite.getWidth()];
			}
		}
		
	}
	
	private void fillView(Tile tile) {
		int width = tile.getSprite().getWidth();
		int height = tile.getSprite().getHeight();
		
		for(int i = 0; i <= view.getHeight() - height; i = i + height) {
			for(int j = 0; j <= view.getWidth() - width; j = j + width) {
				tile.setCords(j, i);
				drawTile(tile);
			}
		}
	}
}
