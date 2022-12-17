package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class exitHome extends ToolContainer{
	public exitHome() {
		
		name = "Exit Home";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/home_135.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}