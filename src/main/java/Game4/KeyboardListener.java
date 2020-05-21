package Game4;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

 public class KeyboardListener extends KeyAdapter{
 	
 		public void keyPressed(KeyEvent e){
 		    switch(e.getKeyCode()){
		    	case 39:	// -> Right 
		    				//if it's not the opposite direction
		    				if(ConcreteStateController.directionSnake!=2)
		    					ConcreteStateController.directionSnake=1;
		    			  	break;
		    	case 38:	// -> Top
							if(ConcreteStateController.directionSnake!=4)
								ConcreteStateController.directionSnake=3;
		    				break;
		    				
		    	case 37: 	// -> Left 
							if(ConcreteStateController.directionSnake!=1)
								ConcreteStateController.directionSnake=2;
		    				break;
		    				
		    	case 40:	// -> Bottom
							if(ConcreteStateController.directionSnake!=3)
								ConcreteStateController.directionSnake=4;
		    				break;
		    	
		    	default: 	break;
 		    }
 		}
 	
 }
