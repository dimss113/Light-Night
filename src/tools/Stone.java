package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Stone extends ToolContainer{
	
	public Stone(int i) {
		name = "stone";
		showTool =  true;
		
		switch(i) {
		case 1:
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_1883.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_100.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		collision = true;
	}
}
