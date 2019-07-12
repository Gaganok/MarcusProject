package render;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.IOException;
import java.util.Collection;

import render.model.Animated;
import render.model.GameObject;
import render.model.Player;
import render.model.Sprite;
import render.model.SpriteSheet;
import render.model.Tile;
import service.DIService;
import service.DataService;

public class Renderer {
	private SpriteSheet dungeonSheet;
	private Player player;

	private BufferedImage view;
	private int[] pixels;
	private Camera camera;
	int color = 0;

	private int lastPosX = 0 , lastPosY = 0;

	public Renderer(int WIDTH, int HEIGHT) throws IOException{
		view = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();
		camera = new Camera(0, 0, WIDTH, HEIGHT);
		DIService.camera = camera;

		//dungeonSheet = new SpriteSheet("spritesheet.png", 32, 32, true);
		player = new Player("guyLad.png", 22, 33, 200, 200);
	}

	public void render(Graphics g) {
		g.drawImage(view, 0, 0, view.getWidth(), view.getHeight(), null);
	}

	public void refresh() {
		for(int i = 0; i < pixels.length; i++) 
			pixels[i] = 0;//-65315;
	}

	public void update() throws IOException {
		player.animate();
	}

	private void drawTile(Tile tile) {
		drawSprite(tile.getSprite(), tile.getPosX(), tile.getPosY(), tile.zoomX, tile.zoomY);
	}

	private void drawSprite(Sprite sprite, int posX, int posY, int zoomX, int zoomY) {
		int[] spritePixels = sprite.getPixels();

		for(int y = 0; y < sprite.getHeight(); y++) 
			for(int x = 0; x < sprite.getWidth(); x++) 
				for(int zoomPosX = 0; zoomPosX < zoomX; zoomPosX++) 
					for(int zoomPosY = 0; zoomPosY < zoomY; zoomPosY++) {
						int xPos = x * zoomX + zoomPosX + posX;
						int yPos = y * zoomY + zoomPosY + posY;

						if(xPos > lastPosX + 1 || yPos > lastPosY +1) {
							System.out.println();
						}
						setPixel(x * zoomX + zoomPosX + posX, y * zoomY + zoomPosY + posY, spritePixels[x + y * sprite.getWidth()]);
						lastPosX = xPos;
						lastPosY = yPos;
					}
	}

	private void setPixel(int x, int y, int pixel) {
		if(x >= camera.x && y >= camera.y && x <= camera.x + camera.width && y <= camera.y + camera.height) {
			int pixelIndex = (x - camera.x) + (y - camera.y) * view.getWidth();
			if(pixels.length > pixelIndex && pixel != DataService.alpha) 
				pixels[pixelIndex] = pixel;
		}
	}

	public void fillView(Tile tile) {

		int incX = tile.getSprite().getWidth() * tile.zoomX;
		int incY = tile.getSprite().getHeight() * tile.zoomY;

		for(int y = camera.y - incY - (camera.y % incY); y < camera.y + camera.height; y += incY) 
			for(int x = camera.x - incX - (camera.x % incX); x < camera.x + camera.width; x += incX ) 
				drawSprite(tile.getSprite(), x, y, tile.zoomX, tile.zoomY);
	}
	
	public void animate(Collection<Animated> animated) {
		animated.forEach(a -> a.animate());
	}
	
	public void renderObject(Collection<GameObject> gameObject) {
		gameObject.forEach(obj -> 
			drawSprite(obj.sprite, obj.posX, obj.posY, DIService.zoom, DIService.zoom)
		);
	}

	public void renderPlayer() {
		player.animate();
		drawSprite(player.sprite, player.posX, player.posY, DIService.zoom, DIService.zoom);
	}
}
