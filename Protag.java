import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Protag {
    private double x, y; // center of circle
    public static final int RADIUS= 10;
    private BufferedImage Astronaut;

    public Protag(int x, int y) {
        this.x= x;
        this.y= y;
        try {
            Astronaut= ImageIO.read(getClass().getResourceAsStream("/as.png"));
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void draw(Graphics g) {
        // Draw a circle with the given center and radius. The edge of the circle should be
        // black and use the color variable for the fill.
        g.drawImage(Astronaut, (int) x, (int) y, null);

    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public void setX(int xx) {
        x= xx;
    }

    public void setY(int yy) {
        y= yy;
    }

    public void updateLocation(int mx, int my) {
        x+= mx;
        y+= my;
    }
}
