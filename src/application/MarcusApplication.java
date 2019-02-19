package application;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.io.IOException;

import javax.swing.JFrame;

import listener.MarcusMouseListener;
import render.Renderer;
import service.DIService;

public class MarcusApplication extends JFrame implements Runnable{

	private int WIDTH = 1280, HEIGHT = 704;
	private Renderer renderer;

	public static void main(String[] args) throws IOException {
		System.out.println(System.currentTimeMillis());
		new Thread(new MarcusApplication()).start();;
	}

	@Override
	public void run() {
		while(true) {

			try {renderer.update();} catch (IOException e1) {}
			renderer.render();
			
			try {Thread.sleep(50);} catch (InterruptedException e) {}
		}
	}

	MarcusApplication() throws IOException{
		renderer = new Renderer(WIDTH, HEIGHT);
		
		Canvas canvas = new Canvas();
		canvas.setBackground(Color.black);
		add(canvas);
		
		canvas.requestFocus();
		canvas.addMouseListener(new MarcusMouseListener());

		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		
		setVisible(true);

		canvas.createBufferStrategy(3);

		DIService.canvas = canvas;
		DIService.bs = canvas.getBufferStrategy();
		DIService.g = canvas.getBufferStrategy().getDrawGraphics();
	}
}
