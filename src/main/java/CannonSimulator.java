import Game5.GamePanel;

import javax.swing.JFrame;
 
public class CannonSimulator {

	public static void main(String[] args) {

		SingletonCannon object5 = SingletonCannon.getInstance();
		object5.show();
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setContentPane(new GamePanel());
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
	}
	
}
