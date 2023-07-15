import java.util.ArrayList;
import java.util.Observable;

public class DataSource extends Observable {

    private static ArrayList<Dot> _instance;

    protected DataSource(){}

    public static ArrayList<Dot> getInstance(){
        if(_instance.size() == 0){
            _instance = new ArrayList<Dot>();
        }
        return _instance;
    }

    public void addData(Dot d){
        _instance.add(d);
        setChanged();
        notifyObservers();
    }
}
