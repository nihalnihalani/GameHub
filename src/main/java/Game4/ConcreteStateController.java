package Game4;

import java.util.ArrayList;


//Controls all the game logic .. most important class in this project.
public class ConcreteStateController extends Thread {
	 ArrayList<ArrayList<DataOfSquare>> Squares= new ArrayList<ArrayList<DataOfSquare>>();
	 Tuple headSnakeState;
	 int sizeSnake=3;
	 long speed = 50;
	 public static int directionSnake ;

	 ArrayList<Tuple> state = new ArrayList<Tuple>();
	 Tuple foodState;
	 
	 //Constructor of ControllerThread
	 ConcreteStateController(Tuple positionDepart){
		//Get all the threads
		Squares= WindowState.Grid;
		
		headSnakeState =new Tuple(positionDepart.x,positionDepart.y);
		directionSnake = 1;

		//!!! Pointer !!!!
		Tuple headState = new Tuple(headSnakeState.getX(), headSnakeState.getY());
		state.add(headState);
		
		foodState = new Tuple(WindowState.height-1, WindowState.width-1);
		spawnFood(foodState);

	 }
	 
	 //Important part :
	 public void run() {
		 while(true){
			 moveInterne(directionSnake);
			 CollisionState();
			 moveExterne();
			 deleteTail();
			 pauser();
		 }
	 }
	 
	 //delay between each move of the snake
	 private void pauser(){
		 try {
				sleep(speed);
		 } catch (InterruptedException e) {
				e.printStackTrace();
		 }
	 }
	 
	 //Checking if the snake bites itself or is eating
	 private void CollisionState() {
		 Tuple posCritique = state.get(state.size()-1);
		 for(int i = 0; i<= state.size()-2; i++){
			 boolean biteItself = posCritique.getX()== state.get(i).getX() && posCritique.getY()== state.get(i).getY();
			 if(biteItself){
				stopState();
			 }
		 }
		 
		 boolean eatingFood = posCritique.getX()== foodState.y && posCritique.getY()== foodState.x;
		 if(eatingFood){
			 System.out.println("Yummy!");
			 sizeSnake=sizeSnake+1;
			 	foodState = getValAleaNotInSnake();

			 spawnFood(foodState);
		 }
	 }
	 
	 //Stops The Game
	 private void stopState(){
		 System.out.println("COLISION! \n");
		 while(true){
			 pauser();
		 }
	 }
	 
	 //Put food in a position and displays it
	 private void spawnFood(Tuple foodPositionIn){
		 	Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
	 }
	 
	 //return a position not occupied by the snake
	 private Tuple getValAleaNotInSnake(){
		 Tuple p ;
		 int ranX= 0 + (int)(Math.random()*19); 
		 int ranY= 0 + (int)(Math.random()*19); 
		 p=new Tuple(ranX,ranY);
		 for(int i = 0; i<= state.size()-1; i++){
			 if(p.getY()== state.get(i).getX() && p.getX()== state.get(i).getY()){
				 ranX= 0 + (int)(Math.random()*19); 
				 ranY= 0 + (int)(Math.random()*19); 
				 p=new Tuple(ranX,ranY);
				 i=0;
			 }
		 }
		 return p;
	 }
	 
	 //Moves the head of the snake and refreshes the positions in the arraylist
	 //1:right 2:left 3:top 4:bottom 0:nothing
	 private void moveInterne(int dir){
		 switch(dir){
		 	case 4:
				 headSnakeState.ChangeData(headSnakeState.x,(headSnakeState.y+1)%20);
				 state.add(new Tuple(headSnakeState.x, headSnakeState.y));
		 		break;
		 	case 3:
		 		if(headSnakeState.y-1<0){
		 			 headSnakeState.ChangeData(headSnakeState.x,19);
		 		 }
		 		else{
				 headSnakeState.ChangeData(headSnakeState.x,Math.abs(headSnakeState.y-1)%20);
		 		}
				 state.add(new Tuple(headSnakeState.x, headSnakeState.y));
		 		break;
		 	case 2:
		 		 if(headSnakeState.x-1<0){
		 			 headSnakeState.ChangeData(19, headSnakeState.y);
		 		 }
		 		 else{
		 			 headSnakeState.ChangeData(Math.abs(headSnakeState.x-1)%20, headSnakeState.y);
		 		 } 
		 		state.add(new Tuple(headSnakeState.x, headSnakeState.y));

		 		break;
		 	case 1:
				 headSnakeState.ChangeData(Math.abs(headSnakeState.x+1)%20, headSnakeState.y);
				 state.add(new Tuple(headSnakeState.x, headSnakeState.y));
		 		 break;
		 }
	 }
	 
	 //Refresh the squares that needs to be 
	 private void moveExterne(){
		 for(Tuple t : state){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).lightMeUp(0);
			 
		 }
	 }
	 
	 //Refreshes the tail of the snake, by removing the superfluous data in positions arraylist
	 //and refreshing the display of the things that is removed
	 private void deleteTail(){
		 int cmpt = sizeSnake;
		 for(int i = state.size()-1; i>=0; i--){
			 if(cmpt==0){
				 Tuple t = state.get(i);
				 Squares.get(t.y).get(t.x).lightMeUp(2);
			 }
			 else{
				 cmpt--;
			 }
		 }
		 cmpt = sizeSnake;
		 for(int i = state.size()-1; i>=0; i--){
			 if(cmpt==0){
				 state.remove(i);
			 }
			 else{
				 cmpt--;
			 }
		 }
	 }
}
