package tools;

import java.io.IOException;

import javax.imageio.ImageIO;

public class BookOrbneon extends ToolContainer{

	public BookOrbneon() {
		name = "Book Orbneon";
		showTool = false;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/book-orbneon.png"));
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
}
