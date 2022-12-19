package environment;

import java.awt.Graphics2D;
import java.util.LinkedHashMap;

import main.GamePanel;
import main.GameSettings;

public class EnvironmentManager {
	GamePanel gp;
	public Lightning lightning;
	GameSettings gs;
	
	public EnvironmentManager(GamePanel gp, GameSettings gs) {
		this.gp = gp;
		this.gs = gs;
//		lightning = new Lightning(gp, gs, 320);
	}
	
	public void setup() {
		lightning = new Lightning(gp, gs, 320);
	}
	
	public void draw(Graphics2D g2) {
//		setup();
		lightning.draw(g2);
	}
}
