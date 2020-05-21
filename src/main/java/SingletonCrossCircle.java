import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SingletonCrossCircle {
    private static SingletonCrossCircle instance = new SingletonCrossCircle();

    private SingletonCrossCircle() {
    }

    public static SingletonCrossCircle getInstance() {
        return instance;
    }
    JButton b3=new JButton("CrossCircle");
    JFrame f=new JFrame("The Game Hub");
    public void show() {
        b3.setBounds(310,220,200,50);
        b3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                new CrossCircle();

            }
        });
        f.add(b3);
    }
}
