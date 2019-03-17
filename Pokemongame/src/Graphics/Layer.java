package Graphics;


import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Layer {
	
	public BufferedImage bi;
	
	protected Layer() {
		bi = new BufferedImage(256, 256, BufferedImage.TYPE_4BYTE_ABGR);
	}
	public void draw(Graphics g) {
		int l = Math.min(g.getClipBounds().width, g.getClipBounds().height);
		g.drawImage(bi, (g.getClipBounds().width - l) / 2, 2, l, l, null);
	}
}
