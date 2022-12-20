package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Hammer extends ToolContainer{
	
	public Hammer() {
		name = "hammer";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/smallhammer.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
