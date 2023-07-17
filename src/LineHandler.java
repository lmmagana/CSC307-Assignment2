import java.awt.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class LineHandler implements Observer {
    private DataSource dataSource;

    public LineHandler(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void drawLines(Graphics g) {
        List<Dot> data = dataSource.getData();
    
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
            // At this point, you can use this.dataSource to access the updated data source and do whatever you need with it
        }
    }
}
