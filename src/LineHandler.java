import java.awt.*;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
    private DataSource dataSource;


    public void drawLines(Graphics g) {
        List<Dot> data = dataSource.getInstance().getData();
    
        if (data.size() >= 2) {
            // Sort the points based on x-axis
            data.sort((dot1, dot2) -> Integer.compare(dot1.getX(), dot2.getX()));
            for (int i = 0; i < data.size() - 1; i++) {
                Dot dot1 = data.get(i);
                Dot dot2 = data.get(i + 1);
                g.drawLine(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY());
            }
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof DataSource) {
            this.dataSource = (DataSource) o;
        }
    }
}
