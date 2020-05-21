import javax.swing.*;



public class TetrisMain {

    public static void main(String... args){

        SingletonTetris object = SingletonTetris.getInstance();

        object.show();
        Game1.Tetris myTetris = new Game1.Tetris();
        myTetris.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        myTetris.setLocationRelativeTo(null);
        myTetris.setVisible(true);
    }

}
