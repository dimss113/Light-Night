package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Key extends ToolContainer{
	
	public Key() {
		name = "key";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/key.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
