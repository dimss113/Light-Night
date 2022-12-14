package tools;

import java.io.IOException;
import java.util.jar.Attributes.Name;

import javax.imageio.ImageIO;

public class Jamur extends ToolContainer{
	
	public Jamur() {
		name = "jamur";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_230.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
	
}
