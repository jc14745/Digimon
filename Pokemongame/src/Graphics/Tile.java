package Graphics;


import java.awt.image.BufferedImage;

public class Tile {
	public byte[] pixs = new byte[32];
	
	public void drawTile(int tx, int ty, int px, int py, BufferedImage bi, byte tilePal, Palette pal, byte flips) {
		int x = tx * 8 - px;
		int y = ty * 8 - py;
		if ((flips & 0x03) == 0) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (x + i >= 0 && x + i < bi.getWidth() && y + j >= 0 && y + j < bi.getHeight()) {
						
						byte k = pixs[(j * 8 + i) / 2];
						
						byte num = (byte) ((i % 2 == 0)? (k & 0xF0) >> 4 : k & 0x0F);
						
						bi.setRGB(x + i, y + j, pal.getColor(tilePal, num));
					}
				}
			}
		} else if ((flips & 0x03) == 1) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (x + i >= 0 && x + i < bi.getWidth() && y + j >= 0 && y + j < bi.getHeight()) {
						
						byte k = pixs[(j * 8 + i) / 2];
						
						byte num = (byte) ((i % 2 == 0)? (k & 0xF0) >> 4 : k & 0x0F);
						
						bi.setRGB(x + (7-i), y + j, pal.getColor(tilePal, num));
					}
				}
			}
		} else if ((flips & 0x03) == 2) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (x + i >= 0 && x + i < bi.getWidth() && y + j >= 0 && y + j < bi.getHeight()) {
						
						byte k = pixs[(j * 8 + i) / 2];
						
						byte num = (byte) ((i % 2 == 0)? (k & 0xF0) >> 4 : k & 0x0F);
						
						bi.setRGB(x + i, y + (7 - j), pal.getColor(tilePal, num));
					}
				}
			}
		} else if ((flips & 0x03) == 3) {
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j < 8; j++) {
					if (x + i >= 0 && x + i < bi.getWidth() && y + j >= 0 && y + j < bi.getHeight()) {
						
						byte k = pixs[(j * 8 + i) / 2];
						
						byte num = (byte) ((i % 2 == 0)? (k & 0xF0) >> 4 : k & 0x0F);
						
						bi.setRGB(x + (7 - i), y + (7 - j), pal.getColor(tilePal, num));
					}
				}
			}
		}
	}
}
