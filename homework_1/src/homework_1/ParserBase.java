package homework_1;

public abstract class ParserBase implements IParser {
	public static final char EOF = (char) -1;
	protected String input;
	protected int characterIndex;
	protected int tokenCount;

	public ParserBase(String input) {
		this.input = input;
		this.characterIndex = 0;
		this.tokenCount = 1;
	}

	@Override
	public abstract boolean parse();

	@Override
	public char lookahead() {
		while (characterIndex < input.length()) {
			char character = input.charAt(characterIndex);
			if (character != ' ')
				return character;
			characterIndex++;
		}
		return EOF;
	}

	@Override
	public boolean match(char character) {
		char look = lookahead();
		if (look == character) {
			characterIndex++;
			tokenCount++;
			return true;
		}
		error("esperado '" + (character == EOF ? "EOF" : character) + "' mas encontrado '"
				+ (look == EOF ? "EOF" : look) + "'");
		return false;
	}

	@Override
	public void error(String characterAddress) {
		System.err.println("Erro no caracter " + tokenCount + ": " + characterAddress);
		System.exit(0);
	}
}
