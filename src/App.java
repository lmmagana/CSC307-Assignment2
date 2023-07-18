import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    private WorkArea workArea;
    private JCheckBox clusterCheckbox, lineCheckbox;
    private ClusterHandler c;

    public App() {
        super("My Project Two");
        c = new ClusterHandler();
        DataSource.getInstance().addObserver(c);

        // west panel
        setLayout(new BorderLayout());
        JPanel westPanel = new JPanel(new GridLayout(10,1));
        westPanel.setBackground(Color.WHITE);

        //Left side menus
        clusterCheckbox = new JCheckBox("Cluster - K-means");
        lineCheckbox = new JCheckBox("Line - Nearest Neighbor");
        JButton run = new JButton("Run");
        westPanel.add(clusterCheckbox);
        westPanel.add(lineCheckbox);
        westPanel.add(run);
        clusterCheckbox.addActionListener(this);
        lineCheckbox.addActionListener(this);
        run.addActionListener(this);

        // Group the checkboxes
        ButtonGroup group = new ButtonGroup();
        group.add(clusterCheckbox);
        group.add(lineCheckbox);

        add(westPanel,BorderLayout.WEST);

        // work area
        workArea = new WorkArea();
        workArea.setBackground(Color.GRAY);
        add(workArea,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        App app = new App();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1000,550);
        app.setVisible(true);
        app.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Run")){
            if (clusterCheckbox.isSelected()){
                workArea.setDrawLinesFlag(false);  
                c.update(DataSource.getInstance(), workArea);         
                workArea.repaint(); 
            }
            if (lineCheckbox.isSelected()){
                workArea.setDrawLinesFlag(true);           
                LineHandler l = new LineHandler();
                DataSource.getInstance().addObserver(l);
                workArea.repaint(); 
            }
        }
    }
}
