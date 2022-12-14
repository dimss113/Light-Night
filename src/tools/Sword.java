package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Sword extends ToolContainer{
	
	public Sword() {
		name = "sword";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/sword.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
