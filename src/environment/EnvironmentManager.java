package environment;

import java.awt.Graphics2D;
import java.util.LinkedHashMap;

import main.GamePanel;
import main.GameSettings;

public class EnvironmentManager {
	GamePanel gp;
	Lightning lightning;
	GameSettings gs;
	
	public EnvironmentManager(GamePanel gp, GameSettings gs) {
		this.gp = gp;
		this.gs = gs;
	}
	
	public void setup() {
		lightning = new Lightning(gp, gs, 320);
	}
	
	public void draw(Graphics2D g2) {
		lightning.draw(g2);
	}
}
