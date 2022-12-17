package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class exitCave extends ToolContainer{
	public exitCave() {
		
		name = "Exit Cave";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/exit.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
}
