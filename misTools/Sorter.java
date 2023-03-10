package misTools;

/**
 * menos eficiente que el quicksort que tienen las listas,
 * pero ahí está para arrays normales
 * @author victor
 * @methods
 * {@linkplain #quicksort(int[])}
 * {@linkplain #quicksort(List)}
 */
public class Sorter {
			
	/**
	 * @param array int[] a organizar de menor a mayor
	 */
	public static void quicksort(int...nums) {
		quicksort(nums, 0, nums.length-1);
	}
	
	private static void quicksort (int[] arr, int suelo, int techo) 
	{		
		if (suelo >= techo)
			return;
						
		int punto_referencia = getPuntoReferencia (arr, suelo, techo);
		int index_izq = particion (arr, suelo, techo, punto_referencia);	
		
		swap (arr, index_izq, techo);
		quicksort (arr, suelo, index_izq-1);
		quicksort (arr, index_izq+1, techo);
	}
	
	
	
	private static int getPuntoReferencia (int[] arr, int suelo, int techo) 
	{
		int pr_aux = (int) (Math.random()*(techo-suelo)+suelo);
		int punto_referencia = arr [pr_aux];
		swap (arr, pr_aux, techo);
		return punto_referencia;
	}
	
	
	private static void swap (int[] arr, int index1, int index2) {
		int aux = arr [index1];
		arr [index1] = arr [index2];
		arr [index2] = aux;
	}
	
	
	private static int particion (int[] arr, int suelo, int techo, int punto_referencia) {
		int index_der = techo;
		int index_izq = suelo;
		
		while (index_izq < index_der) {
			
			while (arr [index_izq] <= punto_referencia && index_izq < index_der)
				index_izq++;
			
			while (arr [index_der] >= punto_referencia && index_izq < index_der)
				index_der--;
			
			swap (arr, index_izq, index_der);
			
		} return index_izq;
	}	
}