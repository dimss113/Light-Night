package tools;

import java.awt.image.ImagingOpException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chest2 extends ToolContainer{
	
	public Chest2(int index) {
		name = "chest2 " + index;
		showTool = true;
		switch(index) {
		case 1:
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_624 (1).png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			break;
		case 2:
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_38.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			break;
		case 3:
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_99.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		collision = true;
	}
	
}
