import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Main extends JComponent {

    public ArrayList<Figure> figures = new ArrayList<>();


    public void clearFigures() {
        figures.clear();
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D drp = (Graphics2D) g;
        boolean isFstDote = true;
       // Color color = Color.black;
        for (Figure figure : figures) {
            if (figure instanceof Dote && isFstDote) {
                figure.paint(drp, Color.red);
                isFstDote = false;
            } else
                figure.paint(drp, Color.black);
        }
    }

    public static void main(String[] args) {


        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Лабораторная 5");
        final Main comp = new Main();
        comp.setPreferredSize(new Dimension(1000, 600));
        frame.getContentPane().add(comp, BorderLayout.CENTER);
        JPanel buttonsPanel = new JPanel();
        JButton clearButton = new JButton("Clear");
        buttonsPanel.add(clearButton);
        frame.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
        buttonsPanel.setBackground(Color.blue);
        Window window = new Window();
        Polygon polygon = new Polygon();
        comp.figures.add(window);
        comp.figures.add(polygon);
        comp.repaint();

        comp.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Dote dote = new Dote(e.getX(), e.getY(), false);
                polygon.update(dote);
                comp.figures.add(dote);
                comp.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        clearButton.addActionListener(e -> {
            polygon.clear();
            comp.clearFigures();
            comp.figures.add(window);
            comp.figures.add(polygon);
        });

        frame.pack();
        frame.setVisible(true);
    }
}
