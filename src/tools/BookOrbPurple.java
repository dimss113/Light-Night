package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BookOrbPurple extends ToolContainer{
	
	public BookOrbPurple() {
		name = "Book Orb Purple";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/book-orbpurple.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
