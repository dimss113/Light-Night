package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Water extends ToolContainer{
	
	public Water(int index) {
		name = "water " + index;
		showTool = true;
		if(index == 1) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_682.png"));				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 2) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_746.png"));				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 3) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_681.png"));
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 4) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tools/villagemap_745.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		collision = true;
	}
	
}
