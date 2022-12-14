package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Root extends ToolContainer{

	public Root(int index) {
		name = "Root " + index;
		showTool = true;
		
		if(index == 1) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_2129.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}	
		}else if(index == 2) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_2130.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		collision = true;
	}
	
}
