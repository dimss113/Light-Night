package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Well extends ToolContainer{
	
	public Well() {
		name = "well";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_622.png"));			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
