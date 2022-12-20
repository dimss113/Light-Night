package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Lava extends ToolContainer{
	
	public Lava(int index) {
		name = "lava " + index;
		showTool = true;
		if(index == 1) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_11.png"));				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 2) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_10.png"));				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 3) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_82.png"));
				
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(index == 4) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_83.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 5) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_85.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 6) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_109.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 7) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_112.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 8) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_88.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 9) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_42.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 10) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_41.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 11) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_40.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 12) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_64.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 13) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_63.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 14) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_62.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 15) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_61.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 16) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_60.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 17) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_36.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		if(index == 18) {
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/tiles/cave01_12.png"));
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		collision = true;
	}
	
}
