package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Potion extends ToolContainer{
	
	public Potion() {
		name = "potion";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/poison_potion.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
