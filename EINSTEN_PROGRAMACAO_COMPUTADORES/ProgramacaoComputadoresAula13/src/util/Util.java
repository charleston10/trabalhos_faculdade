package util;

import java.util.Arrays;
import java.util.Random;

/*
 * Classe útilitária para reaproveitamento de métodos
 * que serão usados em várias partes da aplicação.
 * Dessa forma a maneira mais adequada é utilizar ela
 * como um singleton, pois poderá ser usada em vários
 * lugares sem precisar instancia-la várias vezes,
 * podendo assim fazer um reaproveitamento da memória
 */
public class Util {

	//variável que vai guardar a instancia
	private static Util singleton;
	

	/**
	 * Método para retornar a instancia do objeto
	 * 
	 * @return Util	 
	 */
	public static Util getInstance(){
		return (singleton==null) ? new Util() : singleton;
	}
	
	/**	 
	 * Método para criar um array de inteiros aleatórios
	 * 
	 * @param int total
	 * @return int[]
	 */
	public static int[] getNumericRandom(final int total){
		final int limit = 1000;//limite aleatório
		int[] result = new int[total];
		Random random = new Random();		
		
		//cria uma sequência de N números inteiros aleatórios entre 0 a limit {1000}
	    for (int i = 0; i < total; i++) {
	    	result[i] = random.nextInt(limit); 
		 }
	    
	    return result;
	}
	
	/**
	 * Método para ordenar de modo ascendente um array de inteiros com o indice
	 * da ordenação definido pelo usuário
	 * 
	 * @param int[] numerics
	 * @param int index
	 */
	public static void ascSort(final int[] numerics,final int index){
		Arrays.sort(numerics, index, 0);
	}
	
	/**
	 * Método para ordenar de modo ascendente um array de inteiros com o indice
	 * da ordenação definido pelo usuário
	 * 
	 * @param int[] numerics	
	 * @param int index
	 */
	public static void descSort(final int[] numerics,final int index){
		Arrays.sort(numerics, 0, index);		
	}
	
	/**
	 * Método para procurar no array de inteiros um valor definido pelo usuário
	 * usando a técnica de procura binária
	 * 
	 * @param int[] numerics	
	 * @param int index
	 * @return int
	 */
	public static int binarySearch(final int[] numerics,final int index){
		return Arrays.binarySearch(numerics, index);
	}
	
	/**
	 * Método para procurar no array de inteiros um valor definido pelo usuário
	 * usando a técnica de procura linear
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