package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Stone extends ToolContainer{
	
	public Stone() {
		name = "stone";
		showTool =  true;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_1883.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		collision = true;
	}
}
