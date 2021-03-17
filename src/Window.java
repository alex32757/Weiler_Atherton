import java.awt.*;

public class Window implements Figure{
    @Override
    public void paint(Graphics2D g, Color color) {
        g.setColor(Color.black);
        g.drawRect(350,100, 300, 400);

    }
}
