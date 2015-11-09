public class Main {
	
	
	public static void main(String[] args){
		createMenu();	
	}
	
	/**
	 * Método para criar o menu quando iniciar a aplicação
	 */
	private static void createMenu(){
		final StringBuilder builder = new StringBuilder();
		
		builder.append("1. Para selecionar o tamanho do vetor");
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
		
		System.out.println(builder.toString());
	}
}