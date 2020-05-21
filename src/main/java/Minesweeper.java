import Game2.GameCaretaker;

public class Minesweeper
{
    public static void main(String[] args) 
    {

        GameCaretaker game = new GameCaretaker();
        SingletonMinesweeper object2 = SingletonMinesweeper.getInstance();
        object2.show();
    }
}
