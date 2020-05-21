import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class SingletonCannon {
    private static SingletonCannon instance = new SingletonCannon();

    private SingletonCannon() {
    }

    public static SingletonCannon getInstance() {
        return instance;
    }
    JButton b5=new JButton("Cannon Simulator");
    JFrame f=new JFrame("The Game Hub");
    public void show() {
        b5.setBounds(310,220,200,50);
        b5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){

                new CannonSimulator();

            }
        });
        f.add(b5);
    }
}
