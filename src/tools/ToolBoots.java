package tools;

import java.io.IOException;
import java.util.jar.Attributes.Name;

import javax.imageio.ImageIO;

public class ToolBoots extends ToolContainer{
	
	public ToolBoots() {
		name = "Boots";
//		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/boots.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}

