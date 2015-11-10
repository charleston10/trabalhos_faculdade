package enums;

/**
 * Enum criado para armazenar os valores das opções
 * do menu principal 
 *
 */
public enum OptionEnum {
	
	NONE(-1),
	VECTOR_LENGTH(1),
	VECTOR_USER_WRITE(2),
	VECTOR_ASC(3),
	VECTOR_DESC(4),
	VECTOR_RANDOM(5),
	VECTOR_ORDER_SELECTION(6),
	VECTOR_ORDER_BUBLE_SORT(7),
	VECTOR_ORDER_QUICK_SORT(8),
	VECTOR_LINEAR_SEARCH(9),
	VECTOR_BINARY_SEARCH(10),
	VECTOR_SHOW(11),
	EXIT(0);
	
	private int value;
	
	private OptionEnum(int value){
		this.value = value;
	}
	
	private int getValue(){
		return this.value;
	}
	
	/**
	 * Método para indentificar se o valor passado está dentro das opções
	 * do menu
	 * 
	 * @param int value
	 * @return OptionEnum
	 */
	public static OptionEnum get(int value){
		OptionEnum result = OptionEnum.NONE;
		
		OptionEnum[] values = OptionEnum.values();
		for(OptionEnum type: values){
			if(type.getValue() == value){
				result = type;
				break;
			}
		}
		
		return result;
	}
}
