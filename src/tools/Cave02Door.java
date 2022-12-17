package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Cave02Door extends ToolContainer{

	public Cave02Door() {
		name = "Cave02 Door";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_38.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
