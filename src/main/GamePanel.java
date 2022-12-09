package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entity.Player;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	GameSettings gs = new VillageSettings();	
	KeyHandler keyH = new KeyHandler();
	
	TileManager tileM = new TileManager(this, gs, gs.getStatus(), gs.getMaxCol(), gs.getFile(), gs.getFileCol());
	
	Thread gameThread;
	
	public CollisionChecker cChecker = new CollisionChecker(this, gs);
	
	public Player player = new Player(this, gs ,keyH, gs.getPlayerX(), gs.getPlayerY());
	
	int FPS = 60;
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(gs.getScreenWidth(), gs.getScreenHeight()));
		this.setBackground(Color.black);
		
		// if set to true, all the drawing from this component will be done in an offscreen painting buffere
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void startGameThread() {
		// passing this gamepanel class to gameThread
		gameThread = new Thread(this);
		gameThread.start();
	}
	
//	public void run() {
//		
//		double drawInterval = 1000000000/FPS; // draw screen 60 time per second
//		double nextDrawTime = System.nanoTime() + drawInterval;
//		
//		
//		
//		// selama gameThread exist maka akan terus 
//		while(gameThread != null) {
////			System.out.println("Game loop is running");
//				
//			// 1. Update Char position
//			// 2. Draw screen with updated information
//			update();
//			repaint();
//			
//			try {
//				double remainingTime = nextDrawTime - System.nanoTime();
//				remainingTime = remainingTime/1000000;
//				if(remainingTime < 0) {
//					remainingTime = 0;
//				}
//				
//				Thread.sleep((long)remainingTime);
//				nextDrawTime += drawInterval;
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}
//	}
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
//		if(keyH.upPressed == true) {
//			playerY -= playerSpeed;
//		}
//		else if(keyH.downPressed ==  true) {
//			playerY += playerSpeed;
//		}else if(keyH.leftPressed == true) {
//			playerX -= playerSpeed;
//		}else if(keyH.rightPressed == true) {
//			playerX += playerSpeed;
//		}
		
		// replaced by this
		player.update();
	}
	
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
//		g2.setColor(Color.white);
//		g2.fillRect(playerX, playerY, tileSize, tileSize);
		
		tileM.draw(g2);
		// replaced by this
		player.draw(g2);
		g2.dispose();
	}
}
