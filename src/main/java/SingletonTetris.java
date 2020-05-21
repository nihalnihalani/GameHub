import javax.swing.*;
import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
public class SingletonTetris {
    private static SingletonTetris instance = new SingletonTetris();

    private SingletonTetris() {
    }

    public static SingletonTetris getInstance() {
        return instance;
    }
    JButton b1=new JButton("Tetris");
    JFrame f=new JFrame("The Game Hub");
    public void show() {
        b1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new TetrisMain().main();

            }
        });
        f.add(b1);
    }
}



