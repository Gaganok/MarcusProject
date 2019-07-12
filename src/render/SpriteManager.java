package render;

import java.io.IOException;

import render.model.SpriteSheet;

public class SpriteManager {
	
	private SpriteSheet dungeonSheet;
	private SpriteSheet activePlayer;
	private SpriteSheet idlePlayer;
	
	public SpriteManager() throws IOException {
		dungeonSheet = new SpriteSheet("spritesheet.png", 32, 32, true);
		/*activePlayer = new SpriteSheet();
		idlePlayer = new SpriteSheet();*/
	}
	
	public void update() {
		
	}

}
