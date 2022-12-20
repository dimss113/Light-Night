package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class caveFloor extends ToolContainer{

	public caveFloor() {
		name = "Cave Floor";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_107.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
