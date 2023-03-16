package TresRaya;

import java.util.ArrayList;

public class TresRaya_tablero {

	private char blank;
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
    	blank='·';
        fila1.add(blank); fila1.add(blank); fila1.add(blank); 
        fila2.add(blank); fila2.add(blank); fila2.add(blank); 
        fila3.add(blank); fila3.add(blank); fila3.add(blank); 
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
	    	if (board.get(index).get(col).equals(blank))
	    		return index;
	    	else
	    		return lastEmpty(col, index-1);
    }
    
    @Override
    public String toString() {
    	String bar="";
    	for (ArrayList<Character> row : board) {
    		bar+="\n\t";
    	for (char c : row)
    		bar+=c+"  "; 	
    	}return bar;
    }
        
}