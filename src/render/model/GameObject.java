package render.model;

public abstract class GameObject{
	
	public Sprite sprite;
	public int posX, posY;
	public int zoomX, zoomY;
	public int rotation;
	
	public GameObject(Sprite sprite, int posX, int posY) {
		this.sprite = sprite;
		this.posX = posX;
		this.posY = posY;
	}
	
	public GameObject(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
}
