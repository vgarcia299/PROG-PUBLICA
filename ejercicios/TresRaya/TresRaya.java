package TresRaya;

import java.util.ArrayList;
import java.util.Scanner;
import misTools.ForceChoice;	// https://vgarcia299.github.io/PROG-PUBLICA/documentation/ForceChoice.html
								
public class TresRaya {

	private static char ficha= ' ';
	private static boolean turno= true;
	private static TresRaya_tablero board= new TresRaya_tablero();
	private static Scanner escaner= new Scanner(System.in);


//	fin si false
	private static boolean continuar() {
        if (checkHorizontal()||checkVertical()||checkDiagonal()||checkSinEspacio())
        	return false;
        else
        	return true;
    }
	
	private static void setTurn() {
		if (turno)
			ficha= 'o';
		else
			ficha= 'x';	
		
		turno= !turno;
	}
			
	private static void printUI() {
		System.out.print(board+"\n\nturno jugador "+ficha+"\nintroduce columna (1-3)\t>> ");
	}
	
	private static void printWinner() {
		System.out.print(board+"\n\n\tFIN\n\n\tHa ganado el jugador con pieza "+ficha+"!!!");
	}
	

	public static void jugar() {
		while(continuar()) {
			try {							
				setTurn();
				printUI();
				board.placePiece(ficha, ForceChoice.Integer(escaner,1,2,3)-1);	
			
			} catch (RuntimeException f) {						// thrown en tablero
				turno=!turno; 									// permite repetir turno
				System.err.println("esta columna esta llena");		
		
		}} escaner.close();		  					

		if (!checkSinEspacio())
			printWinner();		
	}

	
//	fin si no quedan espacios vacios
	private static boolean checkSinEspacio() {
		for (int i=0; i<3; i++)
		for (int j=0; j<3; j++)
			if (!board.hasPiece(i, j))
				return false;	// early r= aun quedan casillas

		return true;	
	}
	
	
//	 fin si tres consecutivas
	private static boolean checkHorizontal() {
        for (ArrayList<Character> row : board.getTablero())
        	if (row.get(0)!='·' && row.get(0) == row.get(1) && row.get(1) == row.get(2))
        		return true; // early r = fin

        return false;
	}
	
	
//	fin si tres consecutivas
	private static boolean checkVertical() {
        for (int i=0; i<3; i++)            	
            if (board.hasPiece(0,i) &&
        		board.getTablero().get(0).get(i) == board.getTablero().get(1).get(i) &&         	
        		board.getTablero().get(1).get(i) == board.getTablero().get(2).get(i))
        		return true;  // early r = fin   
        
        return false;
	}
	
	
//	fin juego si true
	private static boolean checkDiagonal() {
		if (diagonal_aux(0,2,2,0)||diagonal_aux(0,0,2,2))
			return true;
		else
			return false;
	}
	
	
	private static boolean diagonal_aux(int x0, int y0,int x2, int y2) {
        if (board.hasPiece(0,y0) &&
            board.getTablero().get(x0).get(y0) == board.getTablero().get(1).get(1) && 
        	board.getTablero().get(x2).get(y2) == board.getTablero().get(1).get(1))
                return true;                      
    		else
    			return false;
	}
	
}
