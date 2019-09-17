import java.awt.Graphics;
import java.util.ArrayList;

public class Obstacle {
    private int width, height; // panel size
    private ArrayList<Circle> list= new ArrayList<>();

    public Obstacle(int w, int h) {
        setWidth(w);
        setHeight(h);
        for (int i= 0; i < 20; i++ ) {
            list.add(new Circle());
        }
    }

    public void update() {
        for (Circle c : list) {
            c.updateLocation();
        }
    }

    public void draw(Graphics g) {
        for (Circle c : list)
            c.draw(g);
    }

    public boolean check(Protag p) {
        for (int i= 0; i < list.size(); i++ ) {
            if (Math.abs(p.getX() - list.get(i).getX()) <= 30 &&
                Math.abs(p.getY() - list.get(i).getY()) <= 30) {
                return true;
            }
        }
        return false;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
