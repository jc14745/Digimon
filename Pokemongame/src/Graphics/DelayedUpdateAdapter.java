package Graphics;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

public class DelayedUpdateAdapter implements KeyListener {

  private Map<Integer, Boolean> keystates = new HashMap<Integer, Boolean>();

  public void register(int k) {
    keystates.put(k, false);
  }

  public void keyTyped(KeyEvent e) {} // unused

  public void keyPressed(KeyEvent e) {
    keystates.put(e.getKeyCode(), true);
  }

  public void keyReleased(KeyEvent e) {
    keystates.put(e.getKeyCode(), false);
  }

  public boolean getKey(int key) {
    if (keystates.containsKey(key)) {
      return keystates.get(key);
    }
    return false;
  }
}
