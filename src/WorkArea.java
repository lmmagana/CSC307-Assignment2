import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JPanel;

public class WorkArea extends JPanel implements MouseListener {

    DataSource dots = new DataSource();
    private int x, y;

    public WorkArea() {
        addMouseListener(this);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        x=e.getX();
        y=e.getY();
        dots.addData(new Dot(x,y, Color.DARK_GRAY));
        repaint();
    }

    public void paintComponent (Graphics g) {

        setBackground(Color.GRAY);
        super.paintComponent(g);

        if(dots.getInstance()!=null) {
            for(Dot dot: dots.getInstance()) dot.draw(g);
        }
        g.setColor(Color.DARK_GRAY);
        g.drawOval(x-4, y-4, 7, 7);
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

}

    /*
    public void undo() {
        if (!shapes.isEmpty()) shapes.pop();
        repaint();
    }

    public void erase() {
        if (!shapes.isEmpty()) shapes.clear();
        repaint();
    }
    */