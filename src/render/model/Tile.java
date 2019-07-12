package render.model;

public class Tile extends GameObject{
	
	public Tile(Sprite sprite, int x, int y) {
		super(sprite, x, y);
	}
	
	public Tile(int x, int y) {
		super(x, y);
	}
	
	public void setCords(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void setZoom(int zoomX, int zoomY) {
		this.zoomX = zoomX;
		this.zoomY = zoomY;
	}
	
	public int getPosX() {
		return posX;
	}
	
	public void setPosX(int posX) {
		this.posX = posX;
	}
	
	public int getPosY() {
		return posY;
	}
	
	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
	
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
}
