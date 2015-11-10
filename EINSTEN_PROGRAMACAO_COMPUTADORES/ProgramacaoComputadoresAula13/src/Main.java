import java.util.Scanner;

import enums.OptionEnum;
import util.Util;

public class Main {
	
	private int limit;//limite que indica o valor máximo que o vetor pode ter
	private int[] vector;//vector para armazenar os valores
	private Scanner scanner;//objeto que irá captar as opção escolhida pelo usuário
	
	public Main(){	
		scanner = new Scanner(System.in);
		init();
	}
	
	public static void main(String[] args){
		new Main();//executa aplicação
	}
	
	/**
	 * Método para criar o menu quando iniciar a aplicação
	 */
	private void createMenu(){	
		Util.getInstance().clearConsole();
		
		//string para armazenar as opções do menu
		final StringBuilder builder = new StringBuilder();
		
		builder.append("\n1. Para selecionar o tamanho do vetor");
		builder.append("\n2. Para preencher o vetor digitando");
		builder.append("\n3. Para preencher o vetor com números crescentemente");
		builder.append("\n4. Para preencher o vetor com números descrescentementer");
		builder.append("\n5. Para preencher o vetor com números aleatórios");
		builder.append("\n6. Para ordenar usando seleção");
		builder.append("\n7. Para ordenar usando buble sort");
		builder.append("\n8. Para ordenar usando quick sort");
		builder.append("\n9. Para realizar uma busca linear");
		builder.append("\n10. Para realizar uma busca binária");
		builder.append("\n11. Para mostar o vetor como esta agora");
		builder.append("\n0. Para sair");
		builder.append("\nOpção: ");
		
		System.out.println(builder.toString());		
	}
	
	/**
	 * Inicia a aplicação
	 */
	private void init(){
		//opção que o usuário irá escolher
		int option = -1;
					
		do{
			createMenu();
			
			//captura a opção informada pelo usuário
			option = scanner.nextInt();
			
			switch(OptionEnum.get(option)){
				case VECTOR_LENGTH:					
					defineVectorLength();
				break;
				case VECTOR_USER_WRITE:
					userWrite();
				break;
				case VECTOR_ASC:					
					vector = Util.getInstance().ascArray(limit);
				break;
				case VECTOR_DESC:					
					vector = Util.getInstance().descArray(limit);
				break;					
				case VECTOR_RANDOM:
					vector = Util.getInstance().randomArray(limit,100);					
				break;
				case VECTOR_ORDER_SELECTION:
					Util.getInstance().seletionSort(vector);
				break;
				case VECTOR_ORDER_BUBLE_SORT:
					Util.getInstance().bubbleSort(vector);
				break;	
				case VECTOR_ORDER_QUICK_SORT:
					Util.getInstance().quickSort(vector,0,vector.length-1);
				break;
				case VECTOR_LINEAR_SEARCH:
					linearSearch();
				break;
				case VECTOR_BINARY_SEARCH:
					binarySearch();
				break;
				case VECTOR_SHOW:					
					showVector();
				break;
				case EXIT:
					exit();
				break;
			}			
		}while(option != 0);
	}
	
	/**
	 * Método o tamanho do vetor
	 */
	private void defineVectorLength(){
		System.out.println("\nInforme o tamanho do vetor: ");
		limit = scanner.nextInt();
		vector = new int[limit];
	}
	
	/**
	 * Mostra o vetor
	 */
	private void showVector(){
		for(int value: vector){
			System.out.print(value + ",");
		}
	}
	
	/**
	 * Sai da aplicação
	 */
	private void exit(){
		System.out.println("********Encerrado**********");
		System.exit(0);
	}
	
	/**
	 * Método para permitir que o usuário informe os valores do vetor
	 */
	private void userWrite(){
		for(int i=0;i<limit;i++){
			System.out.println("Informe o valor ["+i+"] do vetor: ");
			vector[i] = scanner.nextInt();
		}
	}
	
	/**
	 * Método para fazer uma pesquisa no vetor utilizando a técnica de pesquisa binária
	 */
	private void binarySearch(){
		System.out.println("Informe um valor para pesquisar: ");
		int index = scanner.nextInt();
		int result = Util.getInstance().binarySearch(vector, index);
		System.out.println("Resultado se encontra no índice: " + result);
	}
	
	/**
	 * Método para fazer uma pesquisa no vetor utilizando a técnica de pesquisa binária
	 */
	private void linearSearch(){
		System.out.println("Informe um valor para pesquisar: ");
		int index = scanner.nextInt();
		int result = Util.getInstance().linearSearch(vector, index);
		System.out.println("Resultado se encontra no índice: " + result);
	}
}