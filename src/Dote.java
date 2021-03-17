import java.awt.*;

public class Dote implements Figure{
    int x;
    int y;
    boolean isIntersectDote;
    boolean isUsed;

    public Dote(int x, int y, Boolean intersect) {
        this.x = x;
        this.y = y;
        isIntersectDote = intersect;
        isUsed = false;
    }

    public Dote(Dote d) {
        this(d.getX(), d.getY(), false);
    }

    @Override
    public void paint(Graphics2D g, Color color) {
        g.setColor(color);
        g.fillOval(x - 3, y - 3, 6, 6);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
