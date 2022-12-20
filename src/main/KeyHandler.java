package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.Entity;
import entity.Player;
import environment.EnvironmentManager;
import tile.TileManager;
import tools.ToolContainer;

public class KeyHandler implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rightPressed, enterPressed;
	public boolean xPressed, zPressed;
	public boolean checkDrawTime;
	public int lightning = 0;
	
	Entity entity;
	
	GamePanel gp;
	
	public KeyHandler(GamePanel gp) {
		this.gp = gp;
		entity = new Entity(gp);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		
		// TITLE STATE
		if(gp.gameState == gp.titleState) {
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 2;
				}
				gp.playSE(6);
			}
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 2) {
					gp.ui.commandNum = 0;
				}
				gp.playSE(6);
			}
			if(code == KeyEvent.VK_ENTER) {
				switch(gp.ui.commandNum) {
				case 0:
					gp.gameState = gp.playState;
					gp.playMusic(0);
					break;
				case 1:
					gp.gameState = gp.playState;
					gp.playMusic(0);
					break;
				case 2:
					System.exit(0);
					break;
				}
				
				gp.playSE(7);
			}
		}
		
		// PLAY STATE
		if(gp.gameState == gp.playState) {
			if(code == KeyEvent.VK_W || code == KeyEvent.VK_UP) {
				upPressed = true;
			}
			if(code == KeyEvent.VK_S || code == KeyEvent.VK_DOWN) {
				downPressed = true;
			}
			if(code == KeyEvent.VK_A || code == KeyEvent.VK_LEFT) {
				leftPressed = true;
			}
			if(code == KeyEvent.VK_D || code == KeyEvent.VK_RIGHT) {
				rightPressed = true;
			}
			if(code == KeyEvent.VK_X) {
				if(gp.curMap == 2 && gp.ui.hasShovel == true) {
					gp.player.shoveCount++;
				}
				
				if(gp.curMap == 3) {
					
					if(gp.ui.hasBookOrbneon == true && gp.player.frontNeon == true) {
						gp.tool[3].showTool = true;
						gp.ui.hasBookOrbneon = false;
						gp.placedNeon = true;
						System.out.println(gp.keyH.lightning);
//						gp.keyH.lightning++;
					}
					
					if(gp.ui.hasBookOrbpurple == true && gp.player.frontPurple == true) {
						gp.tool[4].showTool = true;
						gp.ui.hasBookOrbpurple = false;
						gp.placedPurple = true;
						System.out.println(gp.keyH.lightning);
//						gp.keyH.lightning ++;
					}
					
					if(gp.tool[3].showTool == true && gp.tool[4].showTool == true) {
						gp.tool[5].showTool = false;
						gp.tool[6].showTool = false;
					}
				}
			
				xPressed = true;
				
			}
			if(code == KeyEvent.VK_Z) {
				zPressed = true;
			}
			if(code == KeyEvent.VK_SPACE || code ==  KeyEvent.VK_PAUSE || code == KeyEvent.VK_P) {
				gp.gameState = gp.pauseState;
			}
			
			if(code == KeyEvent.VK_ENTER) {
				enterPressed = true;
			}
			if(code == KeyEvent.VK_ESCAPE) {
				gp.gameState = gp.optionState;
			}
			
			if(code == KeyEvent.VK_E) {
				if(gp.ui.hasKey == true && gp.player.frontHome == true) {
						gp.curMap = 1;
						gp.setGs(new HomeSettings());
						System.out.println(gp.curMap);
						gp.tool = new ToolContainer[100]; // can contain 12 tools
						
						gp.monster = new Entity[100];
						
						gp.ui.gs = gp.gs;
						
						gp.aSetter = new AssetSetter(gp, gp.gs);
						gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
						gp.cChecker = new CollisionChecker(gp, gp.getGs());
						gp.player = new Player(gp, gp.getGs() ,gp.keyH, gp.getGs().getPlayerX(), gp.getGs().getPlayerY());
						
						gp.refreshMap();
						
						gp.player.frontHome = false;
					}
				
				else if(gp.curMap == 1 && gp.player.exitHome == true) {
					gp.curMap = 0;
					gp.setGs(gp.vilgGS);
					
					gp.tool = new ToolContainer[100]; // can contain 12 tools
					
					gp.monster = new Entity[100];
					
					gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
					gp.cChecker = new CollisionChecker(gp, gp.getGs());
					gp.player = new Player(gp, gp.getGs() ,gp.keyH, 23, 18);
					gp.ui.gs = gp.gs;
					gp.aSetter = new AssetSetter(gp, gp.gs);
					
					gp.refreshMap();
					
					gp.player.exitHome = false;
				}
				
				if(gp.player.frontCave == true) {
					System.out.println("enter");
					System.out.println(gp.curMap);
					if(gp.curMap == 0) {
						gp.curMap = 2;
						gp.setGs(gp.cave01GS);
						System.out.println(gp.curMap);
					}
					else if(gp.curMap == 2) {
						gp.curMap = 3;
						gp.setGs(gp.cave02GS);
						System.out.println(gp.curMap);
					}
					
					gp.tool = new ToolContainer[100]; // can contain 12 tools
					
					gp.monster = new Entity[100];
				
					gp.tileM = new TileManager(gp, gp.getGs(), gp.getGs().getStatus(), gp.getGs().getTotalSize(), gp.getGs().getFile(), gp.getGs().getFileCol());
					gp.cChecker = new CollisionChecker(gp, gp.getGs());
					gp.player = new Player(gp, gp.getGs() ,gp.keyH, gp.getGs().getPlayerX(), gp.getGs().getPlayerY());
					gp.ui.gs = gp.gs;
					gp.aSetter = new AssetSetter(gp, gp.gs);
					
					gp.refreshMap();
					
					gp.player.frontCave = false;
				}
				
				if(gp.player.exitCave == true) {
					System.out.println("exit");
					
					System.out.println(gp.player.hasLava);
					int temp = gp.curMap;
					if(gp.curMap == 2) {
						gp.curMap = 0;
						System.out.println(gp.curMap);
						gp.setGs(gp.vilgGS);
					}
					else if(gp.curMap == 3) {
						gp.curMap = 2;
						System.out.println(gp.curMap);
						gp.setGs(gp.cave01GS);
						
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
					gp.player.hasLava = false;
					
					gp.ui.gs = gp.gs;
					gp.aSetter = new AssetSetter(gp, gp.gs);
					gp.refreshMap();
					
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
		

		// PAUSE STATE
		else if(gp.gameState == gp.pauseState) {
			if(code == KeyEvent.VK_P || code == KeyEvent.VK_SPACE || code == KeyEvent.VK_PAUSE) {
				gp.gameState = gp.playState;
			}
		}
		
		// DIALOG STATE	
		else if(gp.gameState == gp.dialogState) {
			if(code == KeyEvent.VK_ENTER) {
				gp.gameState = gp.playState;
//				entity.increaseDialogIndex();
			}
//			if(code == KeyEvent.VK_SPACE) {
//				gp.gameState = gp.playState;
//			}
		}
		
		// OPTION STATE
		else if(gp.gameState == gp.optionState) {
			optionState(code);
		}
		
		
			
		if(gp.gameState == gp.gameOverState) {
			if(code == KeyEvent.VK_W) {
				gp.ui.commandNum--;
				if(gp.ui.commandNum < 0) {
					gp.ui.commandNum = 1;
				}
				
				gp.playSE(6);
			}
			
			if(code == KeyEvent.VK_S) {
				gp.ui.commandNum++;
				if(gp.ui.commandNum > 1) {
					gp.ui.commandNum = 0;
				}
				
				gp.playSE(6);
			}
			
			if(code == KeyEvent.VK_ENTER) {
				if(gp.ui.commandNum == 0) {
					gp.gameState = gp.playState;
					gp.retry();
				}
				
				if(gp.ui.commandNum == 1) {
					gp.gameState = gp.titleState;
			}
				gp.playSE(7);
		}
	}
}
	
	public void optionState(int code) {
		if(code == KeyEvent.VK_ESCAPE) {
			gp.gameState = gp.playState;
		}
		if(code == KeyEvent.VK_ENTER) {
			enterPressed = true;
		}
		if(code == KeyEvent.VK_W) {
			gp.ui.commandNum--;
			gp.playSE(9);
			if(gp.ui.commandNum < 0) {
				gp.ui.commandNum = 5;
			}
		}
		if(code == KeyEvent.VK_S) {
			gp.ui.commandNum++;
			gp.playSE(9);
			if(gp.ui.commandNum > 5) {
				gp.ui.commandNum = 0;
			}
		}
		
		if(code == KeyEvent.VK_A) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale > 0) {
					gp.music.volumeScale--;
					gp.music.checkVolume();
					gp.playSE(9);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale > 0) {
					gp.se.volumeScale--;
					gp.playSE(9);
				}

			}
		}
		if(code == KeyEvent.VK_D) {
			if(gp.ui.subState == 0) {
				if(gp.ui.commandNum == 1 && gp.music.volumeScale < 5) {
					gp.music.volumeScale++;
					gp.music.checkVolume();
					gp.playSE(2);
				}
				if(gp.ui.commandNum == 2 && gp.se.volumeScale < 5) {
					gp.se.volumeScale++;
					gp.playSE(2);
				}
				
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
