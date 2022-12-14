package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.imageio.plugins.tiff.FaxTIFFTagSet;
import javax.swing.text.DefaultEditorKit.BeepAction;

import tools.AxeTool;
import tools.BookOrbPurple;
import tools.BookOrbneon;
import tools.BucketEmpty;
import tools.BucketFull;
import tools.Hammer;
import tools.Key;
import tools.Potion;
import tools.ShovelTool;
import tools.Sword;
import tools.ToolBoots;

public class UI {

	GamePanel gp;
	Font arial_40;
	BufferedImage shovelImage, axeImage, hammerImage, bootsImage, 
	swordImage, potionImage, bucketEmptyImage, bucketFullImage, keyImage, bookOrbneonImage, textPanel, bookOrbPurpleImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public boolean hasKey = false;
	public boolean hasShovel = false;
	public boolean hasBoots = false;
	public boolean hasSword = false;
	public boolean hasPotion = false;
	public boolean hasBucketEmpty = false;
	public boolean isBucketFull = false;
	public boolean hasBookOrbneon = false;
	public boolean showTextPanel = false;
	public boolean hasBookOrbpurple = false;
	public int tileSize;
	
	public UI(GamePanel gp, GameSettings gs) {
		this.gp = gp;
		arial_40 = new Font("Arial", Font.PLAIN, 20);
		ShovelTool shovel = new ShovelTool();
		AxeTool axe = new AxeTool();
		Hammer hammer = new Hammer();
		ToolBoots boots = new ToolBoots();
		Sword sword = new Sword();
		Potion potion = new Potion();
		BucketEmpty bE = new BucketEmpty();
		BucketFull bF = new BucketFull();
		Key key = new Key();
		BookOrbneon bo = new BookOrbneon();
		BookOrbPurple bp = new BookOrbPurple();
		keyImage = key.image;
		bucketEmptyImage = bE.image;
		shovelImage = shovel.image;
		axeImage = axe.image;
		hammerImage = hammer.image;
		bootsImage = boots.image;
		swordImage = sword.image;
		potionImage = potion.image;
		bucketFullImage = bF.image;
		bookOrbPurpleImage = bp.image;
		bookOrbneonImage = bo.image;
		this.tileSize = gs.getTileSize();
		try {
			textPanel = ImageIO.read(getClass().getResourceAsStream("/tools/textpanel.png"));			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
		showTextPanel = true;
	}
	
	public void draw(Graphics2D g2) {
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		g2.drawImage(axeImage, tileSize/2, tileSize/2 -10, tileSize/2, tileSize/2, null);
		g2.drawImage(hammerImage, tileSize/2 + 50, tileSize/2 - 20, tileSize/2, tileSize, null);
		g2.drawString("x " + gp.player.hasAxe, 50, 30);
		g2.drawString("x " + gp.player.hasHammer, 50 + tileSize/2 + 25, 30);
		
		if(gp.ui.hasBookOrbneon == true) {
			g2.drawImage(bookOrbneonImage, 544, tileSize/2 - 10, tileSize/2, tileSize/2, null);
		}
		
		if(gp.ui.hasBoots == true) {
			g2.drawImage(bootsImage, 572, tileSize/2 - 10, tileSize/2, tileSize/2, null);
		}
		
		if(gp.ui.hasSword == true) {
			g2.drawImage(swordImage, 600, tileSize/2 - 10, tileSize/2, tileSize/2, null);
		}
		
		if(gp.ui.hasShovel == true) {
			g2.drawImage(shovelImage, 628, tileSize/2 - 10, tileSize/2, tileSize/2, null);
		}
		
		if(gp.ui.hasPotion == true) {
			g2.drawImage(potionImage, 656, tileSize/2 - 10, tileSize/2, tileSize/2, null);
		}
		
		if(gp.ui.hasBucketEmpty == true) {
			if(isBucketFull == false) {
				g2.drawImage(bucketEmptyImage, 678, tileSize/2 - 10, tileSize/2, tileSize/2, null);				
			}else {
				g2.drawImage(bucketFullImage, 678, tileSize/2 - 10, tileSize/2, tileSize/2, null);
			}
		}
		
		if(gp.ui.hasKey == true) {
			g2.drawImage(keyImage, 710, tileSize/2-10, tileSize/2, tileSize/2, null);
		}
		
		if(gp.ui.hasBookOrbpurple == true) {
			g2.drawImage(bookOrbPurpleImage, 522, tileSize/2 - 10, tileSize/2, tileSize/2, null);
		}
		
		// messasge
		if(messageOn = true && showTextPanel == true) {
			g2.setFont(g2.getFont().deriveFont(20F));
			g2.drawImage(textPanel, 50, 470, 690, 100, null);
			g2.drawString(message, 120, 522);
//			messageOn = false;
			messageCounter++;
			
			if(messageCounter > 240) {
				System.out.println("masuk counter");
				messageCounter = 0;
				messageOn = false;
				showTextPanel = false;
				message = "";
			}
		}
	}
}

