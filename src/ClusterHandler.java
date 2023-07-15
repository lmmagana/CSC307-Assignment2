import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.awt.*;
public class ClusterHandler implements Observer {
    public void calculate(ArrayList<Dot> dots) {
        int size = dots.size();
        Dot minDot = dots.get(2);
        Dot newD = dots.get(size-1);
        double minDist = Math.pow(10.0, 100);
        int xDiff = 0;
        int yDiff = 0;

        for (int i = 2; i < size-1; i++) {
            Dot d = dots.get(i);
            xDiff = newD.getX() - d.getX();
            yDiff = newD.getY() - d.getY();
            double dDist = Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
            if (dDist < minDist) {
                minDist = dDist;
                minDot = d;
            }
        }
        newD.setColor(minDot.getColor());

    }

    @Override
    public void update(Observable o, Object arg) {
        DataSource src = ((DataSource)o);
        ArrayList<Dot> myDots = src.getInstance();
        myDots.get(0).setColor(Color.RED);
        myDots.get(1).setColor(Color.BLUE);
        calculate(myDots);
    }
}
