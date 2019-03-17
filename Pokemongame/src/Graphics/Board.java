package Graphics;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

  Layer[] layers;

  public DelayedUpdateAdapter dua = new DelayedUpdateAdapter();

  private Timer timer;

  public List<FrameEvent> frameEvents = new ArrayList<FrameEvent>();

  public Board(Layer[] l) {
    initBoard();
    layers = l;
  }

  private void initBoard() {
    addKeyListener(dua);
    setBackground(Color.gray);
    setFocusable(true);

    // This attempts to set the proper frame-rate.
    // Whether or not that works, is as good your guess as mine.
    timer = new Timer(1000 / 40, this);
    timer.start();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    doDrawing(g);
  }

  private void doDrawing(Graphics g) {
    for (int i = 0; i < layers.length; i++) {
      layers[i].draw(g);
    }
    Toolkit.getDefaultToolkit().sync();
  }

  @Override
  public void actionPerformed(ActionEvent e) {

    for (FrameEvent f : frameEvents) {
      f.Frame();
    }

    repaint();
  }
}
