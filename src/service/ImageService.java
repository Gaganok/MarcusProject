package service;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageService {
	
	public static final String RESOURCE_SPRITESHEETS = System.getProperty("user.dir") + "/src/resourses/spritesheets/";
	
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
	
	public static void alpha(BufferedImage image, int target) throws IOException {
		int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
		
		for(int i = 0; i < pixels.length; i++) 
			if(pixels[i] == target)
				pixels[i] = DataService.alpha;
		
		File outputfile = new File("image.png");
		ImageIO.write(image, "png", outputfile);
	}
	
	public static void size(BufferedImage image) {
		
	}
}
