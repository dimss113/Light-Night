package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class AxeTool extends ToolContainer{
	
	public AxeTool() {
		name = "Axe";
		showTool =  true;
		
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/axe.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
