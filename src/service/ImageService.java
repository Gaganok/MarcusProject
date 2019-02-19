package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageService {
	
	public static BufferedImage loadImage(String url) throws IOException {
		return loadImage(new File(url));
	}
	
	public static BufferedImage loadImage(File file) throws IOException {
		BufferedImage image = ImageIO.read(file);
		BufferedImage formattedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
		formattedImage.getGraphics().drawImage(image, 0, 0, null);
		return formattedImage;
	}
	
	public static void cropImage(BufferedImage image) {
		
	}
	
	public static void alpha(BufferedImage image, Color alpha, Color targer) {
		
	}
	
	public static void size(BufferedImage image) {
		
	}
	
}
