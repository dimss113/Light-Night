package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Soil extends ToolContainer{

	public Soil() {
		name = "Soil";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_43.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_42.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}	
