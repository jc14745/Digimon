package GameFunction;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import Graphics.*;
import PokemonGame.PokemonGame;




public class StartPoint {
	
	
	public static void main(String[] args) {
		 try {
		      new StartPoint();
		      
		    } catch (Exception e) {
		      System.err.print(e);
		    }
	}
	
	StartPoint() throws InterruptedException, IOException{
			 EnemyList list1 = new EnemyList();
			 StartDeck deck1 = new StartDeck();
			 Fight fight1 = new Fight(list1.enemyDeck, deck1.newDeck);
	            fight1.firstMove();
			/*
			File palFile = new File("Palette0.png");
			File tileFile = new File("pokemon.png");
		    //File tileFile = new File("tetris.png");
		   // File zubatFile = new File("Zubat.png");
		    
		    Tile[] tiles = getTiles(tileFile);
		    //Tile[] zubat = getTiles(zubatFile);
		   
		    
		    TileSheet ts = new TileSheet();
		    ts.tiles = tiles;

		    Palette pal = new Palette(palFile);
		    
		    Background b0 = new Background(pal, ts);

		    Layer[] layers = new Layer[] {b0};

		    final Board b = new Board(layers);
		   
		    PokemonGame tg = new PokemonGame(b0, pal, b.dua);
		   // PokemonGame pg = new PokemonGame(b0, pal, b.dua, list1, deck1);

		    b.dua.register(KeyEvent.VK_A);
		    b.dua.register(KeyEvent.VK_Q);
		    b.dua.register(KeyEvent.VK_E);
		    b.dua.register(KeyEvent.VK_D);
		    b.dua.register(KeyEvent.VK_S);
		    
		    b.dua.register(KeyEvent.VK_1);
		    b.dua.register(KeyEvent.VK_2);
		    b.dua.register(KeyEvent.VK_3);
		    b.dua.register(KeyEvent.VK_4);
		    
		    b.dua.register(KeyEvent.VK_ENTER);

		    b.frameEvents.add(() -> {
		      tg.doTick();
		    });

		    EventQueue.invokeLater(() -> {
		      Core c = new Core("DEMO", b);
		      c.setVisible(true);
		    });

		    Thread.sleep(8 * 60 * 1000);
		     
		
	}
	 public Tile[] getTiles(File tileFile) throws IOException {
		    BufferedImage image = ImageIO.read(tileFile);

		    Tile[] tiles = new Tile[image.getHeight() / 8];

		    for (int i = 0; i < image.getHeight() / 8; i++) {
		      tiles[i] = new Tile();
		      for (int k = 0; k < 8; k++) {
		        for (int j = 0; j < image.getWidth(); j++) {

		          int l = j * 8 + k;

		          int a = (image.getRGB(k, i * 8 + j) >> 4) & 0x0F;

		          if (k % 2 == 0) {
		            tiles[i].pixs[l / 2] = (byte) ((a << 4) | (tiles[i].pixs[l / 2] & 0x0F));
		          } else {
		            tiles[i].pixs[l / 2] = (byte) ((a) | (tiles[i].pixs[l / 2] & 0xF0));
		          }
		        }
		      }
		    }

		    tiles[24].pixs = new byte[] {

		        0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11,
		        0x11,

		        0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11, 0x11,
		        0x11,

		    };

		    return tiles;*/
		  }

}
