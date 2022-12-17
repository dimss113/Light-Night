package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class exitHouse extends ToolContainer{

	public exitHouse() {
		name = "Exit House";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/home_132.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
