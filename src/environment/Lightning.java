package environment;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import main.GamePanel;
import main.GameSettings;

public class Lightning {
	GamePanel panel;
	
	BufferedImage darknessFilter;
	public Color color[];
	public float fraction[];
	
	public Lightning(GamePanel gp, GameSettings gs, int circleSize) {
		darknessFilter = new BufferedImage(gs.getScreenWidth(), gs.getScreenHeight(), BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)darknessFilter.getGraphics(); 
		
		Area screenArea = new Area(new Rectangle2D.Double(0, 0, gs.getScreenWidth(), gs.getScreenHeight()));
		
		int centerX = gp.player.screenX + (gs.getTileSize()/2);
		int centerY = gp.player.screenY + (gs.getTileSize()/2);
		
		double x = centerX - (circleSize/2);
		double y = centerY - (circleSize/2);
		
		// create a light circle shape
		Shape circlShape = new Ellipse2D.Double(x, y, circleSize, circleSize);
		
		Area lightArea = new Area(circlShape);
		
		// substract the light circle from the screen rectangle
		screenArea.subtract(lightArea);
		
		color = new Color[12];
		fraction = new float[12];
		color[0] = new Color(0,0,0,0.02f);
		color[1] = new Color(0,0,0,0.2f);
		color[2] = new Color(0,0,0,0.52f);
		color[3] = new Color(0,0,0,0.61f);
		color[4] = new Color(0,0,0,0.69f);
		color[5] = new Color(0,0,0,0.76f);
		color[6] = new Color(0,0,0,0.82f);
		color[7] = new Color(0,0,0,0.87f);
		color[8] = new Color(0,0,0,0.91f);
		color[9] = new Color(0,0,0,0.94f);
		color[10] = new Color(0,0,0,0.96f);
		color[11] = new Color(0,0,0,0.98f);
		
		
		fraction[0] = 0f;
		fraction[1] = 0.2f;
		fraction[2] = 0.5f;
		fraction[3] = 0.6f;
		fraction[4] = 0.65f;
		fraction[5] = 0.7f;
		fraction[6] = 0.75f;
		fraction[7] = 0.8f;
		fraction[8] = 0.85f;
		fraction[9] = 0.9f;
		fraction[10] = 0.95f;
		fraction[11] = 1f;
		
		
		// create a gradation paint settings for the light circle
		RadialGradientPaint gPaint = new RadialGradientPaint(centerX, centerY, (circleSize/2), fraction, color);
		
		// set the gradient data on g2
		g2.setPaint(gPaint);
		
		// draw the light circle
		g2.fill(lightArea);
		
//		g2.setColor(new Color(0,0,0,0.95f));
		
		// draw the screen rectangle without the light circle area
		
		g2.fill(screenArea);
		
		g2.dispose();
		
	}
	
	public void draw(Graphics2D g2) {
		g2.drawImage(darknessFilter, 0, 0, null);
	}
	
}
