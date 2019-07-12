package application;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JFrame;

import listener.MarcusKeyboardListener;
import listener.MarcusMouseListener;
import render.Renderer;
import render.model.Animated;
import render.model.AnimatedTile;
import render.model.GameObject;
import render.model.SpriteSheet;
import render.model.Tile;
import service.DIService;

public class MarcusApplication extends JFrame implements Runnable{

	private AnimatedTile bloodPool;

	private int WIDTH = 1280, HEIGHT = 704;
	private Renderer renderer;
	private SpriteSheet dungeonSheet;
	private Canvas canvas;


	public static void main(String[] args) throws IOException {
		new Thread(new MarcusApplication()).start();
	}

	@Override
	public void run() {
		long current = System.currentTimeMillis();
		int fps = 10;
		while(true) {
			if(System.currentTimeMillis() - current > fps ) {
				update();
				render();
				current = System.currentTimeMillis();
			}
		}
	}

	MarcusApplication() throws IOException{

		dungeonSheet = new SpriteSheet("spritesheet.png", 32, 32, true);
		
		bloodPool = new AnimatedTile(dungeonSheet, 0, 0, 1, 2);
		bloodPool.setZoom(DIService.zoom, DIService.zoom);

		canvas = new Canvas();
		canvas.setBackground(Color.black);
		add(canvas);

		canvas.requestFocus();
		MarcusMouseListener mouseListener = new MarcusMouseListener();
		canvas.addMouseListener(mouseListener);
		canvas.addMouseWheelListener(mouseListener);
		canvas.addKeyListener(new MarcusKeyboardListener());

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);

		setVisible(true);

		canvas.createBufferStrategy(3);

		renderer = new Renderer(WIDTH, HEIGHT);
	}

	public void render() {
		BufferStrategy bs = canvas.getBufferStrategy();
		Graphics g = bs.getDrawGraphics();
		super.paint(g);

		Tile tile = new Tile(dungeonSheet.getSprites()[DIService.spriteIndex], 0, 0);
		tile.setZoom(DIService.zoom, DIService.zoom);		

		Collection<Animated> anim = new ArrayList<Animated>();
		anim.add(bloodPool);

		Collection<GameObject> gameObject = new ArrayList<GameObject>();
		gameObject.add(bloodPool);

		renderer.animate(anim);

		bloodPool.setZoom(DIService.zoom, DIService.zoom);

		renderer.fillView(bloodPool);
		renderer.renderPlayer();

		renderer.renderObject(gameObject);

		renderer.render(g);

		g.dispose();

		bs.show();
		renderer.refresh();
	}

	public void update() {

		if(DIService.update) 
			DIService.camera.x += DIService.moveSpeed;
	}

	public void init() {

	}
}
