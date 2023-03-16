package TresRaya;

import java.util.ArrayList;

public class TresRaya_tablero {

	private ArrayList<Character> fila1, fila2, fila3;
	private ArrayList<ArrayList<Character>> board;
    
    public TresRaya_tablero() {
    	board=new ArrayList<>();
    	fila1=new ArrayList<>();
    	fila2=new ArrayList<>();
    	fila3=new ArrayList<>();
    	board.add(fila1);
    	board.add(fila2);
    	board.add(fila3);
    	addBlanks();
    }
    
    private void addBlanks() {
        for (int i=0; i<3; i++) 
        for (int j=0; j<3; j++)
        	board.get(i).add('·');
    }
    
    public boolean hasPiece(int i, int j) {
    	if (board.get(i).get(j) != '·')
    		return true;
    	else
    		return false;
    }
    
    public ArrayList <ArrayList<Character>> getTablero(){
    	return board;
    }
    
    public void placePiece(char pieza, int col) {
		board.get(lastEmpty(col,2)).set(col, pieza);
	}
    
    private int lastEmpty(int col, int index) {
    	if (index<0)
        	throw new RuntimeException();	// la columna esta llena
    	else
	    	if (board.get(index).get(col).equals('·'))
	    		return index;
	    	else
	    		return lastEmpty(col, index-1);
    }
    
    @Override
    public String toString() {
    	String foo="";
    	for (ArrayList<Character> row : board) {
    		foo+="\n\t";
    	for (char c : row)
    		foo+=c+"  "; 	
    	}return foo;
    }
        
}