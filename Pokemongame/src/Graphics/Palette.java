package Graphics;


import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Palette {
	public byte[][] localPalettes = new byte[16][16];
	public int[] globalPalette = new int[256];
	
	public Palette(File f) throws IOException {
		BufferedImage image = ImageIO.read(f);
		for (int i = 0; i < image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight(); j++) {
				int k = i * image.getHeight() + j;
				if (k >= globalPalette.length) {
					return;
				}
				globalPalette[k] = image.getRGB(j, i);
			}
		}
		
		for(int i = 0; i < localPalettes.length; i++) {
			for(int j = 0; j < localPalettes.length; j++) {
				localPalettes[i][j] = (byte) (i * 16 + j);
			}
		}
	}
	
	public int getColor(byte p, byte c) {
		if (c == 0) {
			return 0x0;
		}
		return globalPalette[localPalettes[p % 16][c % 16]] | 0xFF000000;
	}
}
