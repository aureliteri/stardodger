import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Circle {
    private double x, y; // center of circle
    private double dx, dy; // speed
    public static final int RADIUS= 20;
    private Color color;
    private BufferedImage ball;

    public Circle() {
        x= 1020;
        y= (int) (560 * Math.random());
        dx= -1 * (5 * Math.random() + 2);
        dy= -1 * (5 * Math.random() + 2);
        try {
            ball= ImageIO.read(getClass().getResourceAsStream("/ball.png"));
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public void draw(Graphics g) {
        g.drawImage(ball, (int) x, (int) y, null);
    }

    public void updateLocation() {
        x+= dx;
        if (x < -20) {
            x= 1020;
        }
        y+= dy;
        if (y <= 0 || y >= 560) {
            dy= -dy;
        }
    }

    public int getX() {
        return (int) x;
    }

    public int getY() {
        return (int) y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color= color;
    }
}
