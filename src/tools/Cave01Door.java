package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Cave01Door extends ToolContainer{

	public Cave01Door() {
		name = "Cave01 Door";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/villagemap_641.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
