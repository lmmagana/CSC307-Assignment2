import java.util.Observable;
import java.util.Observer;
import java.util.ArrayList;
import java.awt.*;
public class ClusterHandler implements Observer {
    public void calculate(DataSource dots) {
        int size = dots.size();
        if(size < 3) return;
        Dot minDot = dots.get(0);
        Dot newD;
        double minDist;
        int xDiff = 0;
        int yDiff = 0;

        for (int j = 2; j < size; j++) {
            minDist = Math.pow(10.0, 100);
            newD = dots.get(j);
            for (int i = 0; i < j; i++) {
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
    }

    @Override
    public void update(Observable o, Object arg) {
        DataSource src = DataSource.getInstance();
        src.setColor(0, Color.RED);
        if(src.size() >= 2){
            src.setColor(1, Color.BLUE);
        }
        calculate(src);
    }
}
