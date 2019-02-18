package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import render.Renderer;
import service.DIService;
import service.DataService;

public class MarcusApplication extends Application{
		
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas canvas = new Canvas();
		ImageView imageView = new ImageView();
		Group group = new Group(imageView);
		
		DIService.setGc(canvas.getGraphicsContext2D());
		DIService.imageView = imageView;
		
		primaryStage.setScene(new Scene(group, DataService.WIDTH, DataService.HEIGHT));
		primaryStage.setResizable(false);
		primaryStage.show();
		
		Renderer renderer = new Renderer();
		renderer.render();
		renderer.run();
		renderer.stop();
	}

}
