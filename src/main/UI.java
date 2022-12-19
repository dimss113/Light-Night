package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
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
import tools.Heart;
import tools.Key;
import tools.Potion;
import tools.ShovelTool;
import tools.Sword;
import tools.ToolBoots;
import tools.ToolContainer;

public class UI {

	GamePanel gp;
	Font arial_40;
	BufferedImage shovelImage, axeImage, hammerImage, bootsImage, 
	swordImage, potionImage, bucketEmptyImage, bucketFullImage, keyImage, bookOrbneonImage, textPanel, bookOrbPurpleImage;
	public boolean messageOn = false;
	public String message = "";
	int messageCounter = 0;
	public boolean gameFinished = false;
	public boolean hasKey = true;
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
	
	public String currentDialog = "";	
	
	public int commandNum = 0;
	
	int subState = 0;
	
	BufferedImage heartFull, heartHalf, heartBlank;
	
	Graphics2D g2;
	
	int retryX;
	int exitX;
	int retryY;
	int exitY;
	
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
		
		//Create Heart UI
		ToolContainer heart = new Heart();
		heartFull = resizeImage(heart.image, gp.getGs().getTileSize(), gp.getGs().getTileSize());
		heartHalf = resizeImage(heart.image2, gp.getGs().getTileSize(), gp.getGs().getTileSize());
		heartBlank = resizeImage(heart.image3, gp.getGs().getTileSize(), gp.getGs().getTileSize());
		
		
		
	}

	public void showMessage(String text) {
		message = text;
		messageOn = true;
		showTextPanel = true;
	}
	
	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) {
	    BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    Graphics2D graphics2D = resizedImage.createGraphics();
	    graphics2D.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
	    graphics2D.dispose();
	    return resizedImage;
	}
	
	public void draw(Graphics2D g2) {
		
		System.out.println(gp.gameState);
		
		if(gp.gameState == gp.playState && gp.gameState != gp.titleState) {
			g2.setFont(arial_40);
			g2.setColor(Color.white);
			g2.drawImage(axeImage, tileSize/2, tileSize/2 -10, tileSize/2, tileSize/2, null);
			g2.drawImage(hammerImage, tileSize/2 + 50, tileSize/2 - 20, tileSize/2, tileSize, null);
			g2.drawString("x " + gp.player.hasAxe, 50, 30);
			g2.drawString("x " + gp.player.hasHammer, 50 + tileSize/2 + 25, 30);
			drawPlayerLife(g2);
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
			
			//Game State

			
			// messasge
			if(messageOn = true && showTextPanel == true) {
				g2.setFont(g2.getFont().deriveFont(20F));
				g2.setColor(Color.BLACK);
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
		this.g2 = g2;
		
		g2.setFont(arial_40);
		g2.setColor(Color.white);
		
		// TITLE STATE
		if(gp.gameState == gp.titleState) {
			drawTitleScreen();
		}
		
		// PLAY STATE	
		if(gp.gameState == gp.playState) {
			// do player stuff later
		}
		
		// OVER STATE
		if(gp.gameState == gp.gameOverState) {
			drawGameOverScreen(g2);
		}
		
		
		// Pause STATE 
		if(gp.gameState == gp.pauseState) {
			drawPauseScreen();
		}
		
		// Dialog State
		if(gp.gameState == gp.dialogState) {
			drawDialogScreen();
		}
		
		if(gp.gameState == gp.optionState) {
			drawOptionScreen();
		}
	}
	
	public void drawOptionScreen() {
		g2.setColor(Color.white);
		g2.setFont(g2.getFont().deriveFont(32F));
		
		// SUB WINDOW
		int frameX = gp.gs.getTileSize()*4;
		int frameY = gp.gs.getTileSize() + 20;
		int frameWidth = gp.gs.getTileSize() * 7;
		int frameHeight = gp.gs.getTileSize() * 9;
		
		drawSubWindow(frameX, frameY, frameWidth, frameHeight);
		
		switch(subState) {
		case 0:
			topOption(frameX, frameY);
			break;
		case 1:
			fullScreenOptionNotif(frameX, frameY);
			break;
		case 2:
			controlOption(frameX, frameY);
			break;
		case 3:
			endGameOption(frameX, frameY);
			break;
		}
		
		gp.keyH.enterPressed = false;
		
	}
	
	public void topOption(int frameX, int frameY) {
		int textX;
		int textY;
		
		// TITLE
		String text = "Options";
		textX = getXCenterText(g2, text) - 20;
		textY = frameY + gp.gs.getTileSize();
		g2.setFont(g2.getFont().deriveFont(20F));
		g2.drawString(text, textX, textY);
		
		// Full Screen on/of
		textX = frameX + gp.gs.getTileSize();
		textY += gp.gs.getTileSize() + 20;
		g2.drawString("Full Screen", textX, textY);
		
		if(commandNum == 0) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				if(gp.fullScreenOn == false) {
					gp.fullScreenOn = true;
				}
				else if(gp.fullScreenOn == true) {
					gp.fullScreenOn = false;
				}
				subState = 1;
			}
		}
		
		// MUSIC
		textY += gp.gs.getTileSize();
		g2.drawString("MUSIC", textX, textY);
		
		if(commandNum == 1) {
			g2.drawString(">", textX-15, textY);
		}
		
		// SE
		textY += gp.gs.getTileSize();
		g2.drawString("SE", textX, textY);
		
		if(commandNum == 2) {
			g2.drawString(">", textX-15, textY);
		}
		
		// CONTROL
		textY += gp.gs.getTileSize();
		g2.drawString("CONTROL", textX, textY);
		
		if(commandNum == 3) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 2;
				commandNum = 0;
			}
		}
		
		// END GAME
		textY += gp.gs.getTileSize();
		g2.drawString("End Game", textX, textY);
		
		if(commandNum == 4) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 3;
				commandNum = 0;
			}
		}
		
		// BACK
		textY += gp.gs.getTileSize() * 2;
		g2.drawString("Back", textX, textY);
		
		if(commandNum == 5) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				gp.gameState = gp.playState;
				commandNum = 0;
			}
		}
		
		// FULL SCREEN CHECK BOX
		textX = frameX + gp.gs.getTileSize()*4;
		textY = frameY + gp.gs.getTileSize()*2;
		g2.setStroke(new BasicStroke(3));
		g2.drawRect(textX, textY, 24, 24);
		if(gp.fullScreenOn == true) {
			g2.fillRect(textX, textY, 24, 24);
		}
		
		// MUSIC VOLUME
		textY += gp.gs.getTileSize();
		g2.drawRect(textX, textY, 120, 24); // 120/5 = 24
		int volumeWidth = 24 * gp.music.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		// SOUND EFFECT
		textY += gp.gs.getTileSize();
		g2.drawRect(textX, textY, 120, 24);
		volumeWidth = 24 * gp.se.volumeScale;
		g2.fillRect(textX, textY, volumeWidth, 24);
		
		gp.config.saveConfig();
		
	}
	
	public void fullScreenOptionNotif(int frameX, int frameY) {
		int textX = frameX + gp.gs.getTileSize() - 20;
		int textY = frameY + gp.gs.getTileSize()*3;
		
		currentDialog = "The Change will take \neffect after restating \nthe game.";
		
		for(String line: currentDialog.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 40;
		}
		
		// BACK
		textY = frameY + gp.gs.getTileSize()*8;
		g2.drawString("Back", textX, textY);
		
		if(commandNum == 0) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
			}
		}
	}
	
	public void controlOption(int frameX, int frameY) {
		int textX;
		int textY;
		
		// TITLE
		String text = "Control";
		textX = getXCenterText(g2, text);
		textY = frameY + gp.gs.getTileSize();
		g2.setFont(g2.getFont().deriveFont(20F));
		g2.drawString(text, textX, textY);
		
		textX = frameX + gp.gs.getTileSize();
		textY += gp.gs.getTileSize();
		g2.drawString("Move", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("Confirm/attack", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("Shoot/Cast", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("Character Screen", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("Pause", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("Options", textX, textY); textY += gp.gs.getTileSize();
		
		textX = frameX + gp.gs.getTileSize()*4 + 30;
		textY = frameY + gp.gs.getTileSize()*2;
		g2.drawString("WASD", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("ENTER", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("F", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("C", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("P/Space", textX, textY); textY += gp.gs.getTileSize();
		g2.drawString("ESC", textX, textY); textY += gp.gs.getTileSize();
		
		// BACK
		textX = frameX + gp.gs.getTileSize();
		textY = frameY + gp.gs.getTileSize()*8;
		g2.drawString("Back", textX, textY);  
		if(commandNum == 0) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 3;
			}
		}
		
	}
	
	public void endGameOption(int frameX, int frameY) {
		
		int textX = frameX + gp.gs.getTileSize();
		int textY = frameY + gp.gs.getTileSize()*3;
		
		g2.setFont(g2.getFont().deriveFont(20F));
		currentDialog = "Quit the game and \nreturn to home";
		for(String line: currentDialog.split("\n")) {
			g2.drawString(line, textX, textY);
			textY += 30;
		}
		
		// YES Option
		String text = "Yes";
		textX = getXCenterText(g2, text);
		textY += gp.gs.getTileSize()*3;
		g2.drawString(text, textX, textY);
		if(commandNum == 0) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				gp.gameState = gp.titleState;
			}
		}
		
		// NO Option
		text = "No";
		textX = getXCenterText(g2, text);
		textY += gp.gs.getTileSize();
		g2.drawString(text, textX, textY);
		if(commandNum == 1) {
			g2.drawString(">", textX-15, textY);
			if(gp.keyH.enterPressed == true) {
				subState = 0;
				commandNum = 4;
			}
		}
	}
	
	public void drawTitleScreen() {
		// TITLE NAME
		BufferedImage imageLogo;
		try {
			g2.drawRect(0, 0, gp.gs.getScreenWidth(),gp.gs.getScreenHeight());
			g2.fillRect(0, 0, gp.gs.getScreenWidth(), gp.gs.getScreenHeight());
			imageLogo = ImageIO.read(getClass().getResourceAsStream("/tools/logo.png"));
			g2.drawImage(imageLogo, 0, 0, gp.gs.getScreenWidth(), gp.gs.getScreenHeight(), null);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		// MENU OPTION
		String text = "";
		int x = getXCenterText(g2, "");
		int y = gp.gs.getTileSize()*3;
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 28F));
		text = "NEW GAME";
		x = getXCenterText(g2, text);
		y += gp.gs.getTileSize()*5 + 60;
		g2.drawString(text, x, y);
		
		if(commandNum == 0) {
			g2.drawString(">", x-gp.gs.getTileSize() + 10, y);
		}
		
		text = "LOAD GAME";
		x = getXCenterText(g2, text);
		y += gp.gs.getTileSize() - 10;
		g2.drawString(text, x, y);
		
		if(commandNum == 1) {
			g2.drawString(">", x-gp.gs.getTileSize() + 10, y);
		}
		
		text = "QUIT GAME";
		x = getXCenterText(g2, text);
		y += gp.gs.getTileSize() - 10;
		g2.drawString(text, x, y);
		
		if(commandNum == 2) {
			g2.drawString(">", x-gp.gs.getTileSize() + 10, y);
		}
		
	}
	
	public void drawDialogScreen() {
		// dialog window 	
		int x = gp.gs.getTileSize()*2;
		int y = gp.gs.getTileSize()/2;
		int width = gp.gs.getScreenWidth() - (gp.gs.getTileSize()*4);
		int height = gp.gs.getTileSize()*5-10;
		

		
		drawWindow(x, y, width, height);
	}
	
	public void drawSubWindow(int x, int y, int width, int height) {
		Color c = new Color(0, 0, 0, 200);
		g2.setColor(c);
		g2.fillRoundRect(x, y, width, height, 35, 35);
		
		c = new Color(255, 255, 255);
		g2.setColor(c);
		g2.setStroke(new BasicStroke(5));
		g2.drawRoundRect(x+5, y+5, width-10, height-10, 25, 25);
		
		
	}
	
	public void drawWindow(int x, int y, int width, int height) {
		BufferedImage windowImage;
		try {
			windowImage = ImageIO.read(getClass().getResourceAsStream("/tools/windowpanel.png"));
			g2.drawImage(windowImage, x, y, width, height, null);
		}catch(IOException e) {
			e.printStackTrace();
		}
		for(String line: gp.ui.currentDialog.split("\n")) {
			g2.setFont(g2.getFont().deriveFont(15F));
			g2.setColor(Color.DARK_GRAY);
			g2.drawString(line, x+50, y+100);
			y+= 30;
			
		}
		
		
	}
	public void drawPauseScreen( ) {
		g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
		String text =  "PAUSED";
		int x = getXCenterText(g2, text);
		int y = gp.gs.getScreenHeight()/2;
		
		g2.drawString(text, x, y);
	}
	
	public void drawPlayerLife(Graphics2D g2) {
		
		int x = 10;
		int y = gp.getGs().getTileSize() + 10;
		
		
		for(int i=0; i< gp.player.maxLife/2; i++) {
			g2.drawImage(heartBlank, x, y, null);
			x += gp.getGs().getTileSize();
		}
		
		//RESET
		x = 10;
		y = gp.getGs().getTileSize() + 10;
		

		for(int i=0; i < gp.player.curLife/2 ; i++) {
			g2.drawImage(heartFull, x, y, null);
			x += gp.getGs().getTileSize();
		}
		
		if(gp.player.curLife % 2 == 1) {
		
			g2.drawImage(heartHalf, x, y, null);
		}
		
		
	}
	
	 public int getXCenterText(Graphics page, String s) {
		    // Find the size of string s in the font of the Graphics context "page"
		    FontMetrics fm   = page.getFontMetrics(page.getFont());
		    java.awt.geom.Rectangle2D rect = fm.getStringBounds(s, page);
		    int textWidth  = (int)(rect.getWidth());
		   
		    // Center text horizontally and vertically within provided rectangular bounds
		    int textX = (gp.gs.getScreenWidth()- textWidth)/2;
		    return textX;
		  }

	public void drawGameOverScreen(Graphics2D g2) {
		g2.setColor(new Color(0, 0, 0, 150));
		g2.fillRect(0,  0,  gp.gs.getScreenWidth(), gp.gs.getScreenHeight());
		
		int x;
		int y;
		String text;
		
		g2.setFont(g2.getFont().deriveFont(Font.BOLD, 110f));
		text = "GAME OVER";
		
		//SHADOW
		g2.setColor(Color.BLACK);
		x = getXCenterText(g2, text);
		y = gp.gs.getTileSize()*4;
		g2.drawString(text, x, y);
		
		//MAIN
		g2.setColor(Color.WHITE);
		g2.drawString(text, x-4, y-4);
		
		//Retry
		g2.setFont(g2.getFont().deriveFont(50f));
		text = "Retry";
		x = getXCenterText(g2, text);
		y += gp.gs.getTileSize()*4;
		
		retryX = x;
		retryY = y;
		g2.drawString(text, x, y);
		if(commandNum == 0) {
			g2.drawString(">", x-40, y);
		}
		
		//Exit
		text = "Exit";
		x = getXCenterText(g2, text);
		y += 70;
		
		exitX = x;
		exitY = y;
		g2.drawString(text, x, y);
		if(commandNum == 1) {
			g2.drawString(">", x-40, y);
		}
	}
}

