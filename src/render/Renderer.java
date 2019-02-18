package render;


import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import service.DIService;
import service.DataService;

public class Renderer {
	private int WIDTH = DataService.WIDTH, HEIGHT = DataService.HEIGHT;
	private GraphicsContext gc;
	private WritableImage view;

	private int line = 0;
	private Color color = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));;

	long current = System.currentTimeMillis();

	//private int[] pixels = ((DataBufferInt) view.getRaster().getDataBuffer()).getData();

	public Renderer() {
		gc = DIService.getGc();
		view = new WritableImage(WIDTH, HEIGHT);
	}

	private void scale() {

	};

	public void render() {
		DIService.imageView.setImage(view);
	};

	private void rotate() {};
	private void move() {};
	private void replace() {};
	private void translate() {};
	private void color() {};
	private void zoom() {};
	private void proportion() {}

	public void stop() {

	}

	public void run() {
		//private int delay = 1000 / frameRate

/*		new AnimationTimer() {

			@Override
			public void handle(long now) {
				render();
			}

		}.start();*/
		
		new Thread(() -> {
			while(true) {
				Platform.runLater(() -> render());
				try {
					Thread.sleep(15);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();

		new Thread(() -> {
			while(true) {
				update();
				try {
					Thread.sleep(3);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}

	private void update() {
		PixelWriter pw = view.getPixelWriter();

		if(line > 200) {
			line = 0;
			color = Color.rgb((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255));
		}

		for(int j = 0; j < HEIGHT; j++) 
			pw.setColor(line, j, color);
		

		line += 1;
	}
}
