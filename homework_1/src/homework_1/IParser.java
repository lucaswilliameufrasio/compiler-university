package homework_1;

public interface IParser {
	public static final char EOF = (char) -1;

	/*
	 * Retorna o token (caractere) da vez. Caso toda a entrada já tenha sido
	 * consumida, retorna EOF. Além disso, deve ignorar todos os espaços em branco
	 * da entrada. Funciona como um lexer simplificado.
	 */
	public char lookahead();

	/*
	 * Este método deve comparar o lookahead com um outro caractere, se eles forem
	 * iguais avança para o próximo caractere, caso contrário lança um erro de
	 * sintaxe.
	 */
	public boolean match(char character);

	/*
	 * Este método deve imprimir uma mensagem de erro indicando o endereço do
	 * caractere que causou o erro e depois finalizar o programa
	 */
	public void error(String characterAddress);

	/*
	 * Método que inicia a análise sintática chamando o método que representa o
	 * não-terminal inicial
	 */
	public boolean parse();
}