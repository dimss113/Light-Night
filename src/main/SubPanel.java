package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.plugins.tiff.FaxTIFFTagSet;

public class SubPanel {
	
	GamePanel gPanel;
	BufferedImage image;
	BufferedImage image2;
	BufferedImage textPanel;
	public boolean showTextPanel = false;
	
	public SubPanel(GamePanel gp){
		this.gPanel = gp;
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/tools/panelgame-removebg-preview.png"));
			image2 = ImageIO.read(getClass().getResourceAsStream("/tools/panelkiri-removebg-preview.png"));
//			textPanel = ImageIO.read(getClass().getResourceAsStream("/tools/textpanel.png"));
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(image, 2, 2, 200, 50, null);
		g2.drawImage(image2, 513, 2, 245, 50, null);
//		if(gPanel.subP.showTextPanel == true) {
//			g2.drawImage(textPanel, 50, 470, 690, 100, null);			
//		}
		
	}
}
