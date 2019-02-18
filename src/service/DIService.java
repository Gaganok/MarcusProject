package service;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;

public class DIService {
	public static Canvas canvas;
	public static GraphicsContext gc;
	public static ImageView imageView;
	
	public static void setCanvas(Canvas canvas) {
		DIService.canvas = canvas;
	}
	
	public static void setGc(GraphicsContext gc) {
		DIService.gc = gc;
	}
	
	public static Canvas getCanvas() {
		return canvas;
	}
	
	public static GraphicsContext getGc() {
		return gc;
	}	
}
