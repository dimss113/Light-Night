package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class HouseDoor extends ToolContainer{

	public HouseDoor() {
		name = "House Door";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/villagemap_1047.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
