import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class DataSource extends Observable {

    private static DataSource _instance;
    private ArrayList<Dot> dots;

    private DataSource() {
        dots = new ArrayList<Dot>();
    }

    public static DataSource getInstance(){
        if(_instance == null){
            _instance = new DataSource();
        }
        return _instance;
    }

    public ArrayList<Dot> getData() {
        return this.dots;
    }

    public void addData(Dot d){
        dots.add(d);
        setChanged();
        notifyObservers();
    }

    public void setColor(int position, Color c){
        dots.get(position).setColor(c);
    }

    public int size(){
        return dots.size();
    }

    public Dot get(int position){
        return dots.get(position);
    }
}
