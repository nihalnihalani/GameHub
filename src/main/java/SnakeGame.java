import Game4.WindowState;

import javax.swing.*;

public class SnakeGame {

	public static void main(String[] args) {
		SingletonSnake object4 = SingletonSnake.getInstance();
		object4.show();
		//Creating the window with all its awesome snaky features
		WindowState f1= new WindowState();
		
		//Setting up the window settings
		f1.setTitle("Snake");
		f1.setSize(300,300);
		f1.setVisible(true);
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);             

	}
}
