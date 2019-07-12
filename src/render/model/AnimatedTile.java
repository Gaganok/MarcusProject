package render.model;

public class AnimatedTile extends Tile implements Animated {

	private SpriteSheet spriteSheet;
	private Sprite[] spriteSet;
	private int spriteIndex = 0;
	private int spriteCount = 2;
	
	public long lastUpdate = System.currentTimeMillis();
	public int animationSpeed = 150;
	
	public AnimatedTile(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	public AnimatedTile(SpriteSheet spriteSheet, int x, int y, int startIndex, int endIndex) {
		super(x, y);
		this.spriteSheet = spriteSheet;
		getSpriteSet(startIndex, endIndex);
		animate();
	}
	
	public void getSpriteSet(int startIndex, int endIndex) {
		Sprite[] sprites = spriteSheet.getSprites();
		spriteSet = new Sprite[spriteCount];
		
		for(int i = startIndex; i <= endIndex; i++) 
			spriteSet[i - 1] = sprites[i];
	}

	@Override
	public void animate() {
		if(System.currentTimeMillis() - lastUpdate > animationSpeed) {
			sprite = spriteSet[spriteIndex++ % spriteCount];
			lastUpdate = System.currentTimeMillis();
		}
	}
	
}
