package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile.TileManager;
import tools.ToolContainer;

public class GamePanel extends JPanel implements Runnable {
	
	public GameSettings getGs() {
		return gs;
	}

	public void setGs(GameSettings gs) {
		this.gs = gs;
	}
	
	GameSettings gs = new VillageSettings();
	

	KeyHandler keyH = new KeyHandler(this);
	
	TileManager tileM = new TileManager(this, gs, gs.getStatus(), gs.getTotalSize(), gs.getFile(), gs.getFileCol());
	
	EnvironmentManager eManager = new EnvironmentManager(this, gs);
	
	Thread gameThread;
	
	public CollisionChecker cChecker = new CollisionChecker(this, gs);
	
	public Player player = new Player(this, gs ,keyH, gs.getPlayerX(), gs.getPlayerY());
	
	public int gameState;
	public final int playState = 1;
	public final int pauseState = 2;
	
	// Entity AND OBJECT
	Sound music = new Sound();
	Sound se = new Sound();
	
	// FOR TOOLS ONLY
	public ToolContainer tool[] = new ToolContainer[100]; // can contain 12 tools
	public AssetSetter aSetter = new AssetSetter(this, gs);
	public Entity monster[] = new Entity[100];
	
	public UI ui = new UI(this, gs);
	public SubPanel subP = new SubPanel(this);
	
	
	//MAP
	public int curMap;
	int FPS = 60;
	
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
		eManager.setup();
		playMusic(0);
		gameState = playState;
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
				repaint();
				delta--;
				drawCount++;
			}
			if(timer >= 1000000000) {
				System.out.println("FPS :" + drawCount);
			}
		}
	}
	
	public void update() {
		player.update();
		
		for(int i=0; i < monster.length; i++) {
			if(monster[i] != null) {
				monster[i].update();
			}
		}
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
		
		eManager.draw(g2);
		
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
