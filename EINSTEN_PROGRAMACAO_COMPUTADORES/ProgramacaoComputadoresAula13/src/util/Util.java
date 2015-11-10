package util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Classe útilitária para reaproveitamento de métodos
 * que serão usados em várias partes da aplicação.
 * Dessa forma a maneira mais eficiente, será utilizar ela
 * como um singleton, pois poderá ser usada em vários
 * lugares sem precisar instancia-la várias vezes,
 * podendo assim fazer um reaproveitamento da memória
 */
public class Util {

	// variável que vai guardar a instancia
	private static Util singleton;

	/**
	 * Método para retornar a instancia do objeto
	 * 
	 * @return Util
	 */
	public static Util getInstance() {
		return (singleton == null) ? new Util() : singleton;
	}

	/**
	 * Método para criar um array de inteiros aleatórios
	 * 
	 * @param int
	 *            total
	 * @return int[]
	 */
	public static int[] randomArray(final int limit, final int total) {
		int[] result = new int[limit];//array para o resultado
		List<Integer> ints = new ArrayList<>();//lista de inteiros

		//cria numeros inteiros para guardar na lista de 0 a N
		for (int i = 0; i < limit; i++) {
			ints.add(i);
		}
		
		Collections.shuffle(ints);//embaralha a lista de inteiros
		
		//atribui cada valor da lista (já embaralhada) no array de resultado
		for(int i: ints){
			result[i] = ints.get(i);
		}		
		
		return result;
	}

	/**
	 * Método para ordenar de modo ascendente um array de inteiros com o indice
	 * da ordenação definido pelo usuário
	 * 
	 * @param int[]
	 *            numerics
	 * @param int
	 *            index
	 */
	public static void ascSort(final int[] numerics, final int index) {
		Arrays.sort(numerics, index, 0);
	}

	/**
	 * Método para ordenar de modo ascendente um array de inteiros com o indice
	 * da ordenação definido pelo usuário
	 * 
	 * @param int[]
	 *            numerics
	 * @param int
	 *            index
	 */
	public static void descSort(final int[] numerics, final int index) {
		Arrays.sort(numerics, 0, index);
	}

	/**
	 * Método para ordenar o array usando a técnica de Bubble Sort
	 * 
	 * @param int[]
	 *            numerics
	 */
	public static void bubbleSort(final int[] numerics) {
		boolean flag = true;// flag para indicar que encontrou
		int temp;// variável auxiliar

		while (flag) {
			flag = false;// muda a flag para indicar que nao encontrou
			for (int j = 0; j < numerics.length - 1; j++) {
				if (numerics[j] < numerics[j + 1]) {
					temp = numerics[j];// atribui na variável auxiliar
					numerics[j] = numerics[j + 1];
					numerics[j + 1] = temp;
					flag = true; // indica que encontrou
				}
			}
		}
	}

	/**
	 * Método recursivo para ordenar o array usando a técnica de Quick Sort
	 * 
	 * @param int[]
	 *            numerics
	 * @param int left (indice inicial)
	 * @param int right (total de elementos)
	 */
	public static void quickSort(int numerics[], int left, int right) {
		int auxLeft = left;//variável temp para guardar o valor que ficará na esquerda
		int auxRight = right;//variável temp para guardar o valor que ficará na direita
		int middle = numerics[(auxLeft + auxRight) / 2];//calcula para obter o meio do array
		int change;//valor de troca

		while (auxLeft <= auxRight) {//enquanto a esquerda for menor ou igual a direita faz a pesquisa
			while (numerics[auxLeft] < middle) {
				auxLeft = auxLeft + 1;
			}
			while (numerics[auxRight] > middle) {
				auxRight = auxRight - 1;
			}
			if (auxLeft <= auxRight) {
				change = numerics[auxLeft];
				numerics[auxLeft] = numerics[auxRight];
				numerics[auxRight] = change;
				auxLeft = auxLeft + 1;
				auxRight = auxRight - 1;
			}
		}
		
		if (auxRight > left) quickSort(numerics, left, auxRight);

		if (auxLeft < right) quickSort(numerics, auxLeft, right);

	}

	/**
	 * Método para ordenar o array usando a técnica de Selection Sort
	 * 
	 * @param int[] numerics
	 */
	public static void seletionSort(int[] numerics) {
		for (int i = 0; i < numerics.length - 1; i++) {
			int index = i;
			for (int j = i + 1; j < numerics.length; j++)
				if (numerics[j] < numerics[index])
					index = j;

			int smallerNumber = numerics[index];
			numerics[index] = numerics[i];
			numerics[i] = smallerNumber;
		}
	}

	/**
	 * Método para procurar no array de inteiros um valor definido pelo usuário
	 * usando a técnica de procura binária
	 * 
	 * @param int[]
	 *            numerics
	 * @param int
	 *            index
	 * @return int
	 */
	public static int binarySearch(final int[] numerics, final int index) {
		return Arrays.binarySearch(numerics, index);
	}

	/**
	 * Método para procurar no array de inteiros um valor definido pelo usuário
	 * usando a técnica de procura linear
	 * 
	 * @param int[]
	 *            numerics
	 * @param int
	 *            index
	 * @return int
	 */
	public static int linearSearch(final int[] numerics, final int index) {
		int n = numerics.length;
		for (int i = 0; i < n; i++) {
			if (numerics[i] == index)
				return i;
		}
		return -1;
	}

	/**
	 * Método para criar um array de inteiros de modo crescente
	 * 
	 * @param int
	 *            limit
	 * @return int[]
	 */
	public static int[] ascArray(final int limit) {
		int[] result = new int[limit];

		for (int i = 0; i < limit; i++) {
			result[i] = i;
		}

		return result;
	}

	/**
	 * Método para criar um array de inteiros de modo descrescente
	 * 
	 * @param int
	 *            limit
	 * @return int[]
	 */
	public static int[] descArray(final int limit) {
		int[] result = new int[limit];

		int aux = limit;
		for (int i = 0; i < limit; i++) {
			result[i] = --aux;
		}

		return result;
	}

	/**
	 * Método para apagar os valores impressos no console
	 */
	public static void clearConsole() {
		if (System.getProperty("os.name").contains("Windows")) {
			try {
				Runtime.getRuntime().exec("clear");
			} catch (IOException e) {
				e.getMessage();
			}
		} else {
			try {
				Runtime.getRuntime().exec("cls");
			} catch (IOException e) {
				e.getMessage();
			}
		}

		System.out.print("\f");
	}
}