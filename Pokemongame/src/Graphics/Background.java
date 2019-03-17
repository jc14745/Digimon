package Graphics;

import java.awt.Graphics;

public class Background extends Layer {
	
	Palette p;
	TileSheet ts;
	public byte[] tiles = new byte[64*64];
	public byte[] info = new byte[64*64];
	public int offsetX, offsetY;
	
	public Background(Palette pal, TileSheet t) {
		p = pal;
		ts = t;
	}
	@Override
	public void draw(Graphics g) {
		for (int i = 0; i < 33; i++) {
			for (int j = 0; j < 33; j++) {
				int k = ((j + offsetY/8) % 64) * 64 + (i + offsetX/8) % 64;
				Tile t = ts.getTile(tiles[k]);
				if (t != null ) {
					t.drawTile(i, j, offsetX%8, offsetY%8, bi, (byte) (info[k] % 16), (p), (byte) (info[k] >> 4));
				}
			}
		}
		super.draw(g);
	}
}
