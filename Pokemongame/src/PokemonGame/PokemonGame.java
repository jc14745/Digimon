package PokemonGame;
import Graphics.*;
import java.awt.event.KeyEvent;
import java.util.Random;

import GameFunction.EnemyList;
import GameFunction.Fight;
import GameFunction.StartDeck;

public class PokemonGame {

  public DelayedUpdateAdapter dua;
  Background field;
  Palette pal;
  Random r = new Random(121);

  boolean hanging = false, doingDeath = false;

  int score = 0;
  int next = 2;

  int lastCounterSpin, lastClockSpin;

  int[][] blocks = new int[32][10];

  boolean gameOver = false;

  boolean[] isDying = new boolean[32];

  int fallX = 5, fallY = -4, speed = 10, apparentSpeed = speed;

  int[][] fallingBlock = new int[][] {{0, 0, 0, 0,}, {1, 1, 1, 1,}, {0, 0, 0, 0,}, {0, 0, 0, 0,}};

  int[][][] tetrominos = new int[][][] {{ // I
      {0, 0, 0, 0,}, {1, 1, 1, 1,}, {0, 0, 0, 0,}, {0, 0, 0, 0,}},
      { // T
          {0, 0, 0, 0,}, {0, 2, 2, 2,}, {0, 0, 2, 0,}, {0, 0, 0, 0,}},
      { // Z
          {0, 0, 0, 0,}, {0, 3, 3, 0,}, {0, 0, 3, 3,}, {0, 0, 0, 0,}},
      { // S
          {0, 0, 0, 0,}, {0, 0, 4, 4,}, {0, 4, 4, 0,}, {0, 0, 0, 0,}},
      { // L
          {0, 0, 0, 0,}, {0, 0, 0, 5,}, {0, 5, 5, 5,}, {0, 0, 0, 0,}},
      { // R
          {0, 0, 0, 0,}, {0, 6, 0, 0,}, {0, 6, 6, 6,}, {0, 0, 0, 0,}},
      { // M
          {0, 0, 0, 0,}, {0, 7, 7, 0,}, {0, 7, 7, 0,}, {0, 0, 0, 0,}},};

  public PokemonGame(Background b, Palette p, DelayedUpdateAdapter d) {
    field = b;
    pal = p;
    dua = d;

    pal.localPalettes[0] = new byte[] {0, 34, 40, 44, 46, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3,};
    pal.localPalettes[7] = new byte[] {0, 6, 7, 8, 7, 6, 7, 6, 7, 6, 7, 6, 7, 6, 7, 6,};
    pal.localPalettes[4] = new byte[] {0, 9, 10, 11, 10, 9, 10, 9, 10, 9, 10, 9, 10, 9, 10, 9};
    pal.localPalettes[5] = new byte[] {0, 12, 13, 14, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
    pal.localPalettes[2] = new byte[] {0, 16, 17, 18, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
    pal.localPalettes[3] = new byte[] {0, 19, 20, 21, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
    pal.localPalettes[1] = new byte[] {0, 22, 23, 24, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
    pal.localPalettes[6] = new byte[] {0, 25, 26, 27, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
    pal.localPalettes[8] = new byte[] {0, 11, 11, 10, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
    pal.localPalettes[9] = new byte[] {0, 26, 26, 25, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};

    field.offsetX = 0;
    field.offsetY = 0;

    for (int i = 0; i < 33; i++) {
      for (int j = 0; j < 33; j++) {
        if (i == 0 || i == 31 || j == 0 || j == 31) {
          field.tiles[(i * 64 + j)] = 23;
        } else {
          field.tiles[(i * 64 + j)] = 24;
        }
      }
    }
  }

  int frameCounter = 0;
  boolean wasCleared;
  int overCount = 0;

  public void doTick() {

    if (lastClockSpin > 0) {
      lastClockSpin -= 1;
    }

    if (lastCounterSpin > 0) {
      lastCounterSpin -= 1;
    }

    frameCounter++;
    if (frameCounter / 4 < 34 && !wasCleared) {
      int start = (frameCounter / 4) * 64 + 13;

      field.tiles[start + 0] = 5;
      field.tiles[start + 1] = 6;
      field.tiles[start + 2] = 5;
      field.tiles[start + 3] = 7;
      field.tiles[start + 4] = 8;
      field.tiles[start + 5] = 9;

    } else if (gameOver) {
      if (overCount < 32 * 32) {
        int m = overCount + 16;
        for (; overCount < m; overCount++) {
          field.tiles[(overCount / 32) * 64 + overCount % 32] = 0x01;
          field.info[(overCount / 32) * 64 + overCount % 32] = (byte) r.nextInt(7);
        }
      } else {
        gameOver = false;
        overCount = 0;
        clearBoard();
        score = 0;
        speed = 10;
        blocks = new int[32][10];
      }
    } else {

      if (!wasCleared) {
        clearBoard();
        wasCleared = true;
      } else {
        if (frameCounter % 3 == 0) {
          doInput();
        }
        if (!doingDeath) {
          drawBoard();
          drawScore();
          drawNext();
          if (frameCounter % apparentSpeed == 0) {
            if (!hanging) {
              doPhys();
              checkLines();
            } else {
              hanging = false;
            }
          }
        } else {
          doDeath();
        }
      }
    }
  }

  int count = 0;

  private void doDeath() {
    count++;

    byte inf = (byte) ((count / 3 % 2) + 8);

    if (count > 4 * 3) {
      doingDeath = false;
      count = 0;

      for (int k = 0; k < blocks.length; k++) {
        if (isDying[k]) {
          removeLine(k);
        }
      }

      return;
    }

    for (int j = 0; j < isDying.length; j++) {
      if (isDying[j]) {
        for (int k = 0; k < blocks[0].length; k++) {
          field.info[j * 64 + (k + 6)] = inf;
        }
      }
    }
  }

  public void flipClock() {

    int[][] tmp = new int[fallingBlock.length][fallingBlock[0].length];

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        tmp[j][i] = fallingBlock[i][3 - j];
      }
    }

    int backX = 0;

    while (wouldCrash(fallX + backX, fallY, tmp) == 2) {
      backX++;
    }
    while (wouldCrash(fallX + backX, fallY, tmp) == 1) {
      backX--;
    }

    if (wouldCrash(fallX + backX, fallY, tmp) == 0) {
      fallingBlock = tmp;
      fallX += backX;
      hanging = true;
    }
  }

  public void flipCounter() {

    int[][] tmp = new int[fallingBlock.length][fallingBlock[0].length];

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        tmp[j][i] = fallingBlock[3 - i][j];
      }
    }

    int backX = 0;

    while (wouldCrash(fallX + backX, fallY, tmp) == 2) {
      backX++;
    }
    while (wouldCrash(fallX + backX, fallY, tmp) == 1) {
      backX--;
    }

    if (wouldCrash(fallX + backX, fallY, tmp) == 0) {
      fallingBlock = tmp;
      fallX += backX;
      hanging = true;
    }
  }

  public void randomizeBlock() {
    int a = next;
    next = r.nextInt(7);

    for (int i = 0; i < 4; i++) {
      for (int j = 0; j < 4; j++) {
        fallingBlock[i][j] = tetrominos[a][i][j];
      }
    }
  }

  public void moveDown() {
    doPhys();
  }

  public void moveLeft() {
    if (!wouldCrash(fallX - 1, fallY)) {
      fallX--;
    }
  }

  public void moveRight() {
    if (!wouldCrash(fallX + 1, fallY)) {
      fallX++;
    }
  }

  private boolean wouldCrash(int fx, int fy) {
    return (wouldCrash(fx, fy, fallingBlock) != 0);
  }

  private int wouldCrash(int fx, int fy, int[][] blk) {
    for (int x = 0; x < 4; x++) {
      for (int y = 0; y < 4; y++) {
        if (blk[x][y] != 0) {
          if (fx + x >= 0 && fx + x < blocks[0].length && fy + y >= 0 && fy + y < blocks.length) {
            if (blocks[fy + y][fx + x] != 0) {
              return 4;
            }
          }
          if (fy + y >= 31) {
            return 3;
          }
          if (fx + x < 0) {
            return 2;
          }
          if (fx + x >= 10) {
            return 1;
          }
        }
      }
    }
    return 0;
  }

  private void lockFall() {
    for (int x = 0; x < 4; x++) {
      for (int y = 0; y < 4; y++) {
        if (fallingBlock[x][y] != 0) {
          if (fallX + x >= 0 && fallX + x < blocks[0].length && fallY + y >= 0
              && fallY + y < blocks.length) {
            blocks[fallY + y][fallX + x] = fallingBlock[x][y];
          }
        }
      }
    }
  }

  private void doInput() {
    if (dua.getKey(KeyEvent.VK_A)) {
      moveLeft();
    }
    if (dua.getKey(KeyEvent.VK_D)) {
      moveRight();
    }
    if (dua.getKey(KeyEvent.VK_Q) && lastCounterSpin <= 0) {
      lastCounterSpin = 4;
      flipCounter();
    }
    if (dua.getKey(KeyEvent.VK_E) && lastClockSpin <= 0) {
      lastClockSpin = 4;
      flipClock();
    }
    if (dua.getKey(KeyEvent.VK_S)) {
      apparentSpeed = speed / 3;
    } else {
      apparentSpeed = speed;
    }
  }

  private void doPhys() {

    if (wouldCrash(fallX, fallY + 1)) {
      lockFall();
      fallX = 3;
      fallY = -3;
      randomizeBlock();
      if (checkFail()) {
        gameOver = true;
      }

    } else {
      fallY++;
    }
  }

  private void clearBoard() {
    for (int i = 0; i < 33; i++) {
      for (int j = 0; j < 33; j++) {
        field.tiles[(i * 64 + j)] = 24;
        field.info[(i * 64 + j)] = 0x00;
      }
    }
    // draw scorebox
    for (int i = 18; i < 30; i++) {
      for (int j = 2; j < 5; j++) {
        if (i == 18 && j == 2) {
          field.tiles[(j * 64 + i)] = 20;
          field.info[(j * 64 + i)] = 0x10;
        } else if (i == 29 && j == 2) {
          field.tiles[(j * 64 + i)] = 20;
        } else if (i == 18 && j == 4) {
          field.tiles[(j * 64 + i)] = 20;
          field.info[(j * 64 + i)] = 0x30;
        } else if (i == 29 && j == 4) {
          field.tiles[(j * 64 + i)] = 20;
          field.info[(j * 64 + i)] = 0x20;
        } else if (i == 18) {
          field.tiles[(j * 64 + i)] = 21;
          field.info[(j * 64 + i)] = 0x10;
        } else if (i == 29) {
          field.tiles[(j * 64 + i)] = 21;
        } else if (j == 2) {
          field.tiles[(j * 64 + i)] = 22;
        } else if (j == 4) {
          field.tiles[(j * 64 + i)] = 22;
          field.info[(j * 64 + i)] = 0x20;
        }
      }

      for (int j = 9; j < 15; j++) {
        if (i == 18 && j == 9) {
          field.tiles[(j * 64 + i)] = 20;
          field.info[(j * 64 + i)] = 0x10;
        } else if (i == 29 && j == 9) {
          field.tiles[(j * 64 + i)] = 20;
        } else if (i == 18 && j == 14) {
          field.tiles[(j * 64 + i)] = 20;
          field.info[(j * 64 + i)] = 0x30;
        } else if (i == 29 && j == 14) {
          field.tiles[(j * 64 + i)] = 20;
          field.info[(j * 64 + i)] = 0x20;
        } else if (i == 18) {
          field.tiles[(j * 64 + i)] = 21;
          field.info[(j * 64 + i)] = 0x10;
        } else if (i == 29) {
          field.tiles[(j * 64 + i)] = 21;
        } else if (j == 9) {
          field.tiles[(j * 64 + i)] = 22;
        } else if (j == 14) {
          field.tiles[(j * 64 + i)] = 22;
          field.info[(j * 64 + i)] = 0x20;
        }
      }

    }


  }

  private void drawBoard() {
    for (int i = 0; i < 33; i++) {
      for (int j = 5; j < 17; j++) {
        if (j == 5 || j == 16 || i >= 31) {
          field.tiles[(i * 64 + j)] = 23;
        } else {
          drawBlock((i * 64 + j), blocks[i][j - 6]);
        }
      }
    }

    drawFalling();
  }

  private void drawNext() {
    for (int k = 0; k < 4; k++) {
      for (int m = 0; m < 4; m++) {

        drawBlock(((10 + k) * 64 + 22 + m), tetrominos[next][m][k]);

      }
    }
  }

  private void drawFalling() {
    int j = fallX + 6;
    int i = fallY;
    for (int k = 0; k < 4; k++) {
      for (int m = 0; m < 4; m++) {
        if (fallingBlock[m][k] != 0) {
          if (i + k >= 0) {
            drawBlock(((i + k) * 64 + j + m), fallingBlock[m][k]);

          }
        }
      }
    }
  }

  private void drawBlock(int index, int style) {
    if (style == 0) {
      field.tiles[index] = 24;
      field.info[index] = 0x00;
    } else {
      field.tiles[index] = (byte) (0x0);
      field.info[index] = (byte) (style % 16);
    }
  }

  private void drawScore() {
    int m = 1;
    for (int i = 27; i > 19; i--) {
      int j = (score / m) % 10;

      field.tiles[(3 * 64 + i)] = (byte) (0x0A + j);
      m *= 10;
    }
  }

  private boolean checkFail() {
    for (int i = 0; i < blocks[0].length; i++) {
      if (blocks[0][i] != 0) {
        return true;
      }
    }

    return false;
  }

  private void checkLines() {
    int s = 100;
    for (int i = 0; i < blocks.length; i++) {
      boolean b = checkRow(i);
      isDying[i] = b;
      if (b) {
        score += s;
        s *= 4;
        doingDeath = true;
      }
    }
  }

  private boolean checkRow(int i) {
    for (int j = 0; j < blocks[i].length; j++) {
      if (blocks[i][j] == 0) {
        return false;
      }
    }
    return true;
  }

  private void removeLine(int i) {
    for (int j = i; j > 0; j--) {
      blocks[j] = blocks[j - 1];
    }
    blocks[0] = new int[10];
  }
  
  	/*
	static EnemyList list1;
	static StartDeck deck1;
	public PokemonGame(Background b, Palette p, DelayedUpdateAdapter d, EnemyList list1, StartDeck deck1) {
		PokemonGame.list1 = list1;
		PokemonGame.deck1 = deck1;
		
		createEnemies();
		
	    field = b;
	    pal = p;
	    dua = d;

	    pal.localPalettes[0] = new byte[] {0, 34, 40, 44, 46, 1, 2, 3, 0, 1, 2, 3, 0, 1, 2, 3,};
	    pal.localPalettes[7] = new byte[] {0, 6, 7, 8, 7, 6, 7, 6, 7, 6, 7, 6, 7, 6, 7, 6,};
	    pal.localPalettes[4] = new byte[] {0, 9, 10, 11, 10, 9, 10, 9, 10, 9, 10, 9, 10, 9, 10, 9};
	    pal.localPalettes[5] = new byte[] {0, 12, 13, 14, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
	    pal.localPalettes[2] = new byte[] {0, 16, 17, 18, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
	    pal.localPalettes[3] = new byte[] {0, 19, 20, 21, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
	    pal.localPalettes[1] = new byte[] {0, 22, 23, 24, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
	    pal.localPalettes[6] = new byte[] {0, 25, 26, 27, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
	    pal.localPalettes[8] = new byte[] {0, 11, 11, 10, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};
	    pal.localPalettes[9] = new byte[] {0, 26, 26, 25, 0, 2, 3, 2, 1, 0, 4, 21, 32, 33, 34, 35};

	    field.offsetX = 0;
	    field.offsetY = 0;

	    for (int i = 0; i < 33; i++) {
	      for (int j = 0; j < 33; j++) {
	        if (i == 0 || i == 31 || j == 0 || j == 31) {
	          field.tiles[(i * 64 + j)] = 23;
	        } else {
	          field.tiles[(i * 64 + j)] = 24;
	        }
	      }
	    }
	  }
	
	 static EnemyList createEnemies() {
			
			list1.createCreature();
			return list1;
		}
	 
	 private void doAction() {
		    if (dua.getKey(KeyEvent.VK_A)) {
		      moveLeft();
		    }
		    if (dua.getKey(KeyEvent.VK_D)) {
		      moveRight();
		    }
		    if (dua.getKey(KeyEvent.VK_Q) && lastCounterSpin <= 0) {
		      lastCounterSpin = 4;
		      flipCounter();
		    }
		    if (dua.getKey(KeyEvent.VK_E) && lastClockSpin <= 0) {
		      lastClockSpin = 4;
		      flipClock();
		    }
		    if (dua.getKey(KeyEvent.VK_S)) {
		      apparentSpeed = speed / 3;
		    } else {
		      apparentSpeed = speed;
		    }
		    if(dua.getKey(KeyEvent.VK_1)) {
		    	
		    }
		    if(dua.getKey(KeyEvent.VK_2)) {
		    	
		    }
		    if(dua.getKey(KeyEvent.VK_3)) {
		    	
		    }
		    if(dua.getKey(KeyEvent.VK_4)) {
		    	
		    }
		  }
  
  	static void fight() {
  		Fight fight1 = new Fight( list1.enemyDeck, deck1.newDeck );
  		fight1.firstMove();
  	}
  */
  
  
}
