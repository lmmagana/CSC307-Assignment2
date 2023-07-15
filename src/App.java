import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App extends JFrame implements ActionListener {

    private WorkArea workArea;
    private static int lineSelect, clusterSelect = 0;

    public App() {
        super("My Project Two");

        // west panel
        setLayout(new BorderLayout());
        JPanel westPanel = new JPanel();
        westPanel.setLayout(new GridLayout(10,1));
        westPanel.setBackground(Color.WHITE);

        //Left side menus
        JCheckBox cluster = new JCheckBox("Cluster - K-means");
        JCheckBox line = new JCheckBox("Line - Nearest Neighbor");
        JButton run = new JButton("Run");
        westPanel.add(cluster);
        westPanel.add(line);
        westPanel.add(run);
        cluster.addActionListener(this);
        line.addActionListener(this);
        run.addActionListener(this);

        add(westPanel,BorderLayout.WEST);

        // work area
        WorkArea workArea = new WorkArea();
        workArea.setBackground(Color.GRAY);
        add(workArea,BorderLayout.CENTER);

        // south panel
        JPanel southPanel = new JPanel();
        southPanel.setLayout(new FlowLayout());

        /*
        not sure if we want to keep these

        JButton undo = new JButton("Undo");
        JButton erase = new JButton("Erase");

        undo.addActionListener(this);
        erase.addActionListener(this);

        southPanel.add(undo);
        southPanel.add(erase);

        add(southPanel,BorderLayout.SOUTH);
         */
    }

    public static void main(String[] args) {
        App app = new App();
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(1000,550);
        app.setVisible(true);
        app.setResizable(false);

        ClusterHandler c = new ClusterHandler();
        DataSource.getInstance().addObserver(c);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if (e.getActionCommand().equals("Run")){
            if (clusterSelect == 1){
                // perform cluster thing
                System.out.println("Perform Cluster");

            }
            if (lineSelect == 1){
                // perform line thing
                System.out.println("Perform Line");
            }
        }
        //Theres probably a better way to do these if statements but I dont have the time rn.
        // Also these might not actually work, it may have something to do with needed selections.
        if (e.getActionCommand().equals("Cluster - K-means")){
            if (clusterSelect == 0) {
                clusterSelect = 1;
            } else if (clusterSelect == 1) {
                clusterSelect = 0;
            }
        }
        if (e.getActionCommand().equals("Line - Nearest Neighbor")){
            if (lineSelect == 0) {
                lineSelect = 1;
            } else if (lineSelect == 1) {
                lineSelect = 0;
            }
        }
    }
}
