package util;

import java.util.Arrays;
import java.util.Random;

/*
 * Classe �tilit�ria para reaproveitamento de m�todos
 * que ser�o usados em v�rias partes da aplica��o.
 * Dessa forma a maneira mais adequada � utilizar ela
 * como um singleton, pois poder� ser usada em v�rios
 * lugares sem precisar instancia-la v�rias vezes,
 * podendo assim fazer um reaproveitamento da mem�ria
 */
public class Util {

	//vari�vel que vai guardar a instancia
	private static Util singleton;
	

	/**
	 * M�todo para retornar a instancia do objeto
	 * 
	 * @return Util	 
	 */
	public static Util getInstance(){
		return (singleton==null) ? new Util() : singleton;
	}
	
	/**	 
	 * M�todo para criar um array de inteiros aleat�rios
	 * 
	 * @param int total
	 * @return int[]
	 */
	public static int[] getNumericRandom(final int total){
		final int limit = 1000;//limite aleat�rio
		int[] result = new int[total];
		Random random = new Random();		
		
		//cria uma sequ�ncia de N n�meros inteiros aleat�rios entre 0 a limit {1000}
	    for (int i = 0; i < total; i++) {
	    	result[i] = random.nextInt(limit); 
		 }
	    
	    return result;
	}
	
	/**
	 * M�todo para ordenar de modo ascendente um array de inteiros com o indice
	 * da ordena��o definido pelo usu�rio
	 * 
	 * @param int[] numerics
	 * @param int index
	 */
	public static void ascSort(final int[] numerics,final int index){
		Arrays.sort(numerics, index, 0);
	}
	
	/**
	 * M�todo para ordenar de modo ascendente um array de inteiros com o indice
	 * da ordena��o definido pelo usu�rio
	 * 
	 * @param int[] numerics	
	 * @param int index
	 */
	public static void descSort(final int[] numerics,final int index){
		Arrays.sort(numerics, 0, index);		
	}
	
	/**
	 * M�todo para procurar no array de inteiros um valor definido pelo usu�rio
	 * usando a t�cnica de procura bin�ria
	 * 
	 * @param int[] numerics	
	 * @param int index
	 * @return int
	 */
	public static int binarySearch(final int[] numerics,final int index){
		return Arrays.binarySearch(numerics, index);
	}
	
	/**
	 * M�todo para procurar no array de inteiros um valor definido pelo usu�rio
	 * usando a t�cnica de procura linear
	 * 
	 * @param int[] numerics	
	 * @param int index
	 * @return int
	 */
	public static int linearSearch(final int[] numerics, final int index){
		int n = numerics.length;
	    for (int i=0; i<n; i++){
	      if (numerics[i] == index) return i;
	    }
	    return -1;
	}
}