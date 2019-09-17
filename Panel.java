import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Panel extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID= 1L;
    private Protag protag;
    private Obstacle obs;
    private javax.swing.Timer timer;
    private Frame f;
    private boolean time= true;
    private int timerCount= 0;
    private int score= 10000;
    private boolean upArrow= false;
    private boolean downArrow= false;
    private boolean rArrow= false;
    private boolean lArrow= false;
    private BufferedImage door;

    public Panel(int width, int height, Frame ff) {
        f= ff;
        obs= new Obstacle(getWidth(), getHeight());
        protag= new Protag(10, 280);
        setBackground(Color.BLACK);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        timer= new javax.swing.Timer(50, new TimerListener());
        timer.start();

        try {
            door= ImageIO.read(getClass().getResourceAsStream("/door.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

        addKeyListener(new Keys());
        setFocusable(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        requestFocusInWindow();
        obs.draw(g);
        protag.draw(g);
        g.drawImage(door, 820, 200, null);
    }

    private void stopper() {
        timer.stop();
        setTime(false);
    }

    public void reset() {
        obs= new Obstacle(getWidth(), getHeight());
        protag= new Protag(10, 280);
        timer.start();
        f.update("");
        setTime(true);
        timerCount= 0;
        score= 10000;
        f.updateScore(score);
    }

    public void updateProtag() {
        int x= protag.getX();
        int y= protag.getY();

        if (upArrow && y > 0)
            protag.updateLocation(0, -5);
        if (downArrow && y < 530)
            protag.updateLocation(0, 5);
        if (lArrow && x > 0)
            protag.updateLocation(-5, 0);
        if (rArrow && x < 910)
            protag.updateLocation(5, 0);

        if (x >= 790 && y >= 170 && y <= 340) {
            stopper();
            f.update("YOU WIN!");
        }
    }

    public boolean isTime() {
        return time;
    }

    public void setTime(boolean time) {
        this.time= time;
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateProtag();
            obs.update();
            if (obs.check(protag)) {
                stopper();
                f.update("GAME OVER");
            }
            timerCount+= 100;
            if (timerCount % 1000 == 0) {
                score-= 10;
                f.updateScore(score);
                if (score <= 0) {
                    stopper();
                    f.update("GAME OVER");
                }
            }
            repaint();
        }
    }

    private class Keys extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upArrow= true;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downArrow= true;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                lArrow= true;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rArrow= true;
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                upArrow= false;
            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                downArrow= false;
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                lArrow= false;
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rArrow= false;
            }
        }
    }
}
