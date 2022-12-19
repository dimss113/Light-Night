package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import tile.TileManager;
import tools.ToolContainer;

import environment.*;

public class GamePanel extends JPanel implements Runnable {
	
	public GameSettings getGs() {
		return gs;
	}

	public void setGs(GameSettings gs) {
		this.gs = gs;
	}
	
	public GameSettings gs = new VillageSettings();
	

	public KeyHandler keyH = new KeyHandler(this);
	
	TileManager tileM = new TileManager(this, gs, gs.getStatus(), gs.getTotalSize(), gs.getFile(), gs.getFileCol());
	
//	EnvironmentManager eManager = new EnvironmentManager(this, gs);
	
	Thread gameThread;
	
	public CollisionChecker cChecker = new CollisionChecker(this, gs);
	
	public Player player = new Player(this, gs, keyH, gs.getPlayerX(), gs.getPlayerY());
	
	public boolean fullScreenOn = false;
	Config config = new Config(this);
	
	//GAME STATE
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	public final int dialogState = 3;
	public final int titleState = 0;
	public final int optionState = 5;
	public final int gameOverState = 4; //5
	
	// Full Screen
	int fullScreenWidth = gs.getScreenWidth();
	int fullScreenHeight = gs.getScreenHeight();
	BufferedImage tempScreen;
	Graphics2D g2;
	
	// Entity AND OBJECT
	Sound music = new Sound();
	Sound se = new Sound();
	public Entity npc[] = new Entity[10];
	
	// FOR TOOLS ONLY
	public ToolContainer tool[] = new ToolContainer[100]; // can contain 12 tools
	public AssetSetter aSetter = new AssetSetter(this, gs);
	public Entity monster[] = new Entity[100];
	
	public UI ui = new UI(this, gs);
	public SubPanel subP = new SubPanel(this);
	
	
	//MAP
	public int curMap = 0 ; //0: Village 1:Home 2:Cave01 3:Cave02

	int FPS = 60;
	
	Lightning lightning = new Lightning(this, gs, 320);
	public GamePanel() {

		this.setPreferredSize(new Dimension(gs.getScreenWidth(), gs.getScreenHeight()));
		this.setBackground(Color.black);
		
		// if set to true, all the drawing from this component will be done in an offscreen painting buffere
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
		aSetter.setMonster();
//		eManager.setup();
		aSetter.setNPC();
//		playMusic(0);
		gameState = titleState;
		if(gameState == playState || gameState == pauseState) {
			playMusic(0);
		}
		tempScreen = new BufferedImage(gs.getScreenWidth(), gs.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
		g2 = (Graphics2D)tempScreen.getGraphics();
		
		if(fullScreenOn == true) {
			setFullScreen();	
		}
	}
	
	public void setFullScreen() {
		// Get local screen device
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice gd = ge.getDefaultScreenDevice();
		gd.setFullScreenWindow(Main.window);
		
		
		// Get Full Screen Width and Height
		fullScreenWidth = Main.window.getWidth();
		fullScreenHeight = Main.window.getHeight();
	}
	
	public void startGameThread() {
		// passing this gamepanel class to gameThread
		gameThread = new Thread(this);
		gameThread.start();
	}
	

	public void run() {
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		
		long timer = 0;
		int drawCount = 0;
		
		while(gameThread != null) {
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime)/drawInterval;
			timer = (currentTime - lastTime);
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
//				repaint();
				drawToTempScreen();
				drawToScreen();
				delta--;
				drawCount++;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS :" + drawCount);
			}
		}
	}
	
	public void update() {
		
		if(gameState == playState) {
			player.update();
			
			for(int i=0; i < monster.length; i++) {
				if(monster[i] != null) {
					monster[i].update();
				}
			}
			
			for(int i = 0; i < npc.length; i++) {
				if(npc[i] != null) {
					npc[i].update();
				}
			}
		}
		if(gameState == pauseState) {
//			 nothing for now
		}
	}
	
	
	public void retry() {
		player.setDefaultValues();
		aSetter.setObject();
		aSetter.setMonster();
//		eManager.setup();
		player.setDefaultItem();
	}
	
	public void drawToTempScreen() {
		// Debug stuff
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();			
		}
		
		// TTILE SCREEN
		if(gameState == titleState) {
			ui.draw(g2);
		}
		// OTHERS 
		else {
			
			// this is tile
			tileM.draw(g2);
			// replaced by this
			
			// this is tool
			for(int i=0;i<tool.length;i++) {
				if(tool[i] != null) {
					if(tool[i].showTool == true) {
						tool[i].draw(g2, this, gs);					
					}
				}
			}
			for(int i =0 ; i < npc.length ; i++) {
				if(npc[i] != null) {
					npc[i].draw(g2); 
				}
			}
			
			for(int i=0; i<monster.length; i++) {
				if(monster[i] != null) {
					monster[i].draw(g2);
				}
			}
			
			
//			eManager.draw(g2);
			lightning.draw(g2);
			
			// NPC
			
			// this is player
			subP.draw(g2);
			player.draw(g2);
			
			ui.draw(g2);
			
		}
		
		
		// DEBUG
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
			System.out.println("Draw Time: " + passed);			
		}		
	}
	
	public void drawToScreen() {
		Graphics g = getGraphics();
		g.drawImage(tempScreen, 0, 0, fullScreenWidth, fullScreenHeight, null);
		g.dispose();
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
//		g2.setColor(Color.white);
//		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		// Debug stuff
		long drawStart = 0;
		if(keyH.checkDrawTime == true) {
			drawStart = System.nanoTime();			
		}
		
		
		// this is tile
		tileM.draw(g2);
		// replaced by this
		
		// this is tool
		for(int i=0;i<tool.length;i++) {
			if(tool[i] != null) {
				if(tool[i].showTool == true) {
					tool[i].draw(g2, this, gs);					
				}
			}
		}
		

		for(int i=0; i<monster.length; i++) {
			if(monster[i] != null) {
				monster[i].draw(g2);
			}
		}
		
		for(int i =0 ; i < npc.length ; i++) {
			if(npc[i] != null) {
				npc[i].draw(g2); 
			}
		}
		
//		eManager.draw(g2);
		
		// this is player
		subP.draw(g2);
		player.draw(g2);
		
		ui.draw(g2);
		
		if(keyH.checkDrawTime == true) {
			long drawEnd = System.nanoTime();
			long passed = drawEnd - drawStart;
			g2.setColor(Color.white);
			g2.drawString("Draw Time: " + passed, 10, 400);
			System.out.println("Draw Time: " + passed);			
		}
		
		
		g2.dispose();
	}
	
	public void playMusic(int i) {
		
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	// short music
	public void playSE(int i) {
		se.setFile(i);
		se.play();
	}
}
