import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SingletonMinesweeper {
    private static SingletonMinesweeper instance = new SingletonMinesweeper();

    private SingletonMinesweeper() {
    }

    public static SingletonMinesweeper getInstance() {
        return instance;
    }
    JButton b2=new JButton("Minesweeper");
    JFrame f=new JFrame("The Game Hub");
    public void show() {
        b2.setBounds(310,220,200,50);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                new Minesweeper();

            }
        });
        f.add(b2);
    }
}
