import java.util.Scanner;

import enums.OptionEnum;
import util.Util;

public class Main {
	
	private int limit;//limite que indica o valor m�ximo que o vetor pode ter
	private int[] vector;//vector para armazenar os valores
	private Scanner scanner;//objeto que ir� captar as op��o escolhida pelo usu�rio
	
	public Main(){	
		scanner = new Scanner(System.in);
		init();
	}
	
	public static void main(String[] args){
		new Main();//executa aplica��o
	}
	
	/**
	 * M�todo para criar o menu quando iniciar a aplica��o
	 */
	private void createMenu(){	
		Util.getInstance().clearConsole();
		
		//string para armazenar as op��es do menu
		final StringBuilder builder = new StringBuilder();
		
		builder.append("\n1. Para selecionar o tamanho do vetor");
		builder.append("\n2. Para preencher o vetor digitando");
		builder.append("\n3. Para preencher o vetor com n�meros crescentemente");
		builder.append("\n4. Para preencher o vetor com n�meros descrescentementer");
		builder.append("\n5. Para preencher o vetor com n�meros aleat�rios");
		builder.append("\n6. Para ordenar usando sele��o");
		builder.append("\n7. Para ordenar usando buble sort");
		builder.append("\n8. Para ordenar usando quick sort");
		builder.append("\n9. Para realizar uma busca linear");
		builder.append("\n10. Para realizar uma busca bin�ria");
		builder.append("\n11. Para mostar o vetor como esta agora");
		builder.append("\n0. Para sair");
		builder.append("\nOp��o: ");
		
		System.out.println(builder.toString());		
	}
	
	/**
	 * Inicia a aplica��o
	 */
	private void init(){
		//op��o que o usu�rio ir� escolher
		int option = -1;
					
		do{
			createMenu();
			
			//captura a op��o informada pelo usu�rio
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
	 * M�todo o tamanho do vetor
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
	 * Sai da aplica��o
	 */
	private void exit(){
		System.out.println("********Encerrado**********");
		System.exit(0);
	}
	
	/**
	 * M�todo para permitir que o usu�rio informe os valores do vetor
	 */
	private void userWrite(){
		for(int i=0;i<limit;i++){
			System.out.println("Informe o valor ["+i+"] do vetor: ");
			vector[i] = scanner.nextInt();
		}
	}
	
	/**
	 * M�todo para fazer uma pesquisa no vetor utilizando a t�cnica de pesquisa bin�ria
	 */
	private void binarySearch(){
		System.out.println("Informe um valor para pesquisar: ");
		int index = scanner.nextInt();
		int result = Util.getInstance().binarySearch(vector, index);
		System.out.println("Resultado se encontra no �ndice: " + result);
	}
	
	/**
	 * M�todo para fazer uma pesquisa no vetor utilizando a t�cnica de pesquisa bin�ria
	 */
	private void linearSearch(){
		System.out.println("Informe um valor para pesquisar: ");
		int index = scanner.nextInt();
		int result = Util.getInstance().linearSearch(vector, index);
		System.out.println("Resultado se encontra no �ndice: " + result);
	}
}