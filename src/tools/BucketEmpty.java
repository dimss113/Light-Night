package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BucketEmpty extends ToolContainer{
	
	public BucketEmpty() {
		name = "bucket empty";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/bucket_empty.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
