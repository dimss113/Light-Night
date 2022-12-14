package tools;

import java.awt.image.ImagingOpException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Chest extends ToolContainer{

	public Chest(int index) {
		name = "Chest " + index;
		showTool = true;
		if(index == 1) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_1675.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if(index == 2) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_2011.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}else if(index == 3) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_1959.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		else if(index == 4) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_921.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
			collision = true;
			showTool = true;
		}
		collision = true;
	}
	
}
