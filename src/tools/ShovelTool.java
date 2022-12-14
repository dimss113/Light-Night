package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class ShovelTool extends ToolContainer{
	public ShovelTool() {
		name = "Shovel";
//		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/shovel.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
		
//		collision = true;
	}
}



