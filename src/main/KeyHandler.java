package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile.TileManager;
import tools.ToolContainer;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed;
	public boolean xPressed, zPressed;
	public boolean checkDrawTime;
	
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_W) {
			upPressed = true;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = true;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = true;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = true;
		}
		if(code == KeyEvent.VK_X) {
			xPressed = true;
		}
		if(code == KeyEvent.VK_Z) {
			zPressed = true;
		}
		if(code == KeyEvent.VK_P) {
			if(gp.gameState == gp.playState) {
				gp.gameState = gp.pauseState;
			}
			else if(gp.gameState == gp.pauseState) {
				gp.gameState = gp.playState;
			}
		}
		
		if(code == KeyEvent.VK_E) {
			if(gp.ui.hasKey == true && gp.player.frontHome == true) {
					gp.curMap = 1;
					gp.setGs(new HomeSettings());
					System.out.println(gp.curMap);
					gp.tool = new ToolContainer[100]; // can contain 12 tools
					
					gp.monster = new Entity[100];
					
					gp.ui = new UI(gp, gp.gs);
					
					gp.aSetter = new AssetSetter(gp, gp.gs);
					gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
					gp.cChecker = new CollisionChecker(gp, gp.getGs());
					gp.player = new Player(gp, gp.getGs() ,gp.keyH, gp.getGs().getPlayerX(), gp.getGs().getPlayerY());
					
					gp.player.frontHome = false;
				}
			
			else if(gp.curMap == 1 && gp.player.exitHome == true) {
				gp.curMap = 0;
				gp.setGs(new VillageSettings());
				
				gp.tool = new ToolContainer[100]; // can contain 12 tools
				
				gp.monster = new Entity[100];
				
				gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
				gp.cChecker = new CollisionChecker(gp, gp.getGs());
				gp.player = new Player(gp, gp.getGs() ,gp.keyH, 23, 18);
				gp.ui = new UI(gp, gp.gs);
				gp.subP = new SubPanel(gp);
				gp.aSetter = new AssetSetter(gp, gp.gs);
				gp.setupGame();
				
				gp.player.exitHome = false;
			}
			
			if(gp.player.frontCave == true) {
				System.out.println("enter");
				System.out.println(gp.curMap);
				if(gp.curMap == 0) {
					gp.curMap = 2;
					gp.setGs(new Cave01Settings());
					System.out.println(gp.curMap);
				}
				else if(gp.curMap == 2) {
					gp.curMap = 3;
					gp.setGs(new Cave02Settings());
					System.out.println(gp.curMap);
				}
				
				gp.tool = new ToolContainer[100]; // can contain 12 tools
				
				gp.monster = new Entity[100];
			
				gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
				gp.cChecker = new CollisionChecker(gp, gp.getGs());
				gp.player = new Player(gp, gp.getGs() ,gp.keyH, gp.getGs().getPlayerX(), gp.getGs().getPlayerY());
				gp.ui = new UI(gp, gp.gs);
				gp.subP = new SubPanel(gp);
				gp.aSetter = new AssetSetter(gp, gp.gs);
				gp.setupGame();
				
				gp.player.frontCave = false;
			}
			
			if(gp.player.exitCave == true) {
				System.out.println("exit");
				System.out.println(gp.curMap);
				int temp = gp.curMap;
				if(gp.curMap == 2) {
					gp.curMap = 0;
					System.out.println(gp.curMap);
					gp.setGs(new VillageSettings());
				}
				else if(gp.curMap == 3) {
					gp.curMap = 2;
					System.out.println(gp.curMap);
					gp.setGs(new Cave01Settings());
				}
				
				gp.tool = new ToolContainer[100]; // can contain 12 tools
				
				gp.monster = new Entity[100];
			
				gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
				gp.cChecker = new CollisionChecker(gp, gp.getGs());
				if(temp == 2) {
					gp.player = new Player(gp, gp.getGs() ,gp.keyH, 2, 10);
				}
				else if(temp == 3) {
					gp.player = new Player(gp, gp.getGs() ,gp.keyH, 14, 1);
				}
				
				gp.ui = new UI(gp, gp.gs);
				gp.subP = new SubPanel(gp);
				gp.aSetter = new AssetSetter(gp, gp.gs);
				gp.setupGame();
				
				gp.player.exitCave = false;
			}
		}

		// DEBUG draw time
		if(code == KeyEvent.VK_T) {
			if(checkDrawTime == false) {
				checkDrawTime = true;
			}else if(checkDrawTime == true) {
				checkDrawTime = false;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_W) {
			upPressed = false;
		}
		if(code == KeyEvent.VK_S) {
			downPressed = false;
		}
		if(code == KeyEvent.VK_A) {
			leftPressed = false;
		}
		if(code == KeyEvent.VK_D) {
			rightPressed = false;
		}		
		if(code == KeyEvent.VK_X) {
			xPressed = false;
		}
		if(code == KeyEvent.VK_Z) {
			zPressed = false;
		}
	}
	
}
