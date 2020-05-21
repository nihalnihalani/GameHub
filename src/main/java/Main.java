


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
public class Main {
	public static void main(String[] args) {

		JFrame f=new JFrame("The Game Hub");

		final JLabel tl=new JLabel("Select Game!");
		tl.setBounds(370,50, 150,20);


		JButton b1=new JButton("Tetris");
		b1.setBounds(310,120,200,50);
		SingletonTetris object = SingletonTetris.getInstance();
		object.show();
		b1.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e){
				new TetrisMain().main(args);

			}
		});







		JButton b2=new JButton("Minesweeper");
		b2.setBounds(310,220,200,50);
		SingletonMinesweeper object2 = SingletonMinesweeper.getInstance();
		object2.show();
		b2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				new Minesweeper().main(args);

			}
		});




		JButton b3=new JButton("Cross-Circles");
		SingletonCrossCircle object3 = SingletonCrossCircle.getInstance();
		object3.show();
		b3.setBounds(310,320,200,50);
		b3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				new CrossCircle().main(args);


			}
		});


		JButton b4=new JButton("Snake game");
		SingletonSnake object4 = SingletonSnake.getInstance();
		object4.show();
		b4.setBounds(310,420,200,50);
		b4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				new SnakeGame().main(args);


			}
		});

		JButton b5=new JButton("Cannon Simulator");
		SingletonCannon object5 = SingletonCannon.getInstance();
		object5.show();
		b5.setBounds(310,520,200,50);
		b5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){

				new CannonSimulator().main(args);


			}
		});


		f.add(tl);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);



		f.setSize(800,800);
		f.setLayout(null);
		f.setVisible(true);


		try {
			f.getContentPane().add(new JPanelWithBackground("bg.jpg"));
		}
		catch(Exception ep)
		{
			ep.printStackTrace();
		}

		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent ev) {
				//frame.dispose();
				System.out.println("+++++++++++");
			}
		});

	}


}
class JPanelWithBackground extends JPanel {

	private Image backgroundImage;

	// Some code to initialize the background image.
	// Here, we use the constructor to load the image. This
	// can vary depending on the use case of the panel.
	public JPanelWithBackground(String fileName) throws IOException {
		backgroundImage = ImageIO.read(getClass().getResource(fileName));
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Draw the background image.
		g.drawImage(backgroundImage, 0, 0, this);
	}
}



