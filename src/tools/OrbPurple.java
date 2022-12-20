package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OrbPurple extends ToolContainer{
	
	public OrbPurple() {
		name = "Orb Purple";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/orbPurple.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
