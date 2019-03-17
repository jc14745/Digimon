package Graphics;

import javax.swing.JFrame;

public class Core extends JFrame {

  public Core(String name, Board b) {
    add(b);

    setFocusable(false);

    setResizable(true);
    pack();

    setTitle(name);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

}
