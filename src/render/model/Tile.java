package render.model;


public class Tile {
	
	private int posX, posY;
	private int zoomX, zoomY;
	private Sprite sprite;
	
	public Tile(Sprite sprite, int x, int y) {
		this.sprite = sprite;
		posX = x;
		posY = y;
	}
	
	public void setCords(int x, int y) {
		posX = x;
		posY = y;
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
	public int getZoomX() {
		return zoomX;
	}
	public void setZoomX(int zoomX) {
		this.zoomX = zoomX;
	}
	public int getZoomY() {
		return zoomY;
	}
	public void setZoomY(int zoomY) {
		this.zoomY = zoomY;
	}
	public Sprite getSprite() {
		return sprite;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
}
