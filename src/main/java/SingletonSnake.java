import javax.swing.*;
import java.awt.event.ActionEvent;



import java.awt.event.ActionListener;
public class SingletonSnake {
    private static SingletonSnake instance = new SingletonSnake();

    private SingletonSnake() {
    }

    public static SingletonSnake getInstance() {
        return instance;
    }
    JButton b4=new JButton("Snake Game");
    JFrame f=new JFrame("The Game Hub");
    public void show() {
        b4.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                new SnakeGame();

            }
        });
        f.add(b4);
    }
}



