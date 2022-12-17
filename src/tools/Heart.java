package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;

public class Heart extends ToolContainer{
	public Heart() {
		name = "bucket empty";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/heart_full.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/tools/heart_half.png"));
			image3 = ImageIO.read(getClass().getResourceAsStream("/tools/heart_blank.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
