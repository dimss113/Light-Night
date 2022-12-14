package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BucketFull extends ToolContainer{
	
	public BucketFull() {
		name = "bucket empty";
		showTool = true;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/bucket_water.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
