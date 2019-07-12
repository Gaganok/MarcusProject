package render.model;

import java.io.IOException;

import render.Camera;
import service.DIService;

public class Player extends GameObject implements Animated{
	
	private SpriteSheet playerSheet;
	private int playerSpritePosition = 3;
	
	private int state = 0;
	private Sprite[] spriteSet;
	private int currentSpriteIndex = 0;
	private int spriteCount = 4;
	
	public Player(Sprite sprite, int posX, int posY) {
		super(sprite, posX, posY);
	}
	
	public Player(SpriteSheet spriteSheet, int posX, int posY) {
		super(null, posX, posY);
		playerSheet = spriteSheet;
	}
	
	public Player(String spriteSheetUrl, int spriteWidth, int spriteHeight, int posX, int posY) throws IOException {
		super(null, posX, posY);
		playerSheet = new SpriteSheet(spriteSheetUrl, spriteWidth, spriteHeight, true);
		getSpriteSet();
		animate();
	}
	
	public void getSpriteSet() {
		Sprite[] sprites = playerSheet.getSprites();
		spriteSet = new Sprite[spriteCount];
		
		for(int i = 0; i < spriteCount; i++) 
			spriteSet[i] = sprites[i + state * spriteCount];
	}

	@Override
	public void animate() {
		move();
		sprite = spriteSet[currentSpriteIndex++ % spriteCount];
	}
	
	private void move() {
		Camera camera = DIService.camera;
		posX = camera.width / 2 + camera.x;
		posY = camera.height /2 + camera.y;
	}
}
