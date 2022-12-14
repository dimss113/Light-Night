package tools;

import java.io.IOException;
import java.text.CollationElementIterator;

import javax.imageio.ImageIO;

public class BucketWater extends ToolContainer{
	
	public BucketWater() {
		name = "bucket water";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/bucket_water.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		collision = true;
	}
	
	
}
