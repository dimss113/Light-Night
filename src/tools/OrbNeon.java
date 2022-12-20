package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OrbNeon extends ToolContainer{
	
	public OrbNeon() {
		name = "Orb Purple";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/orbNeon.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
