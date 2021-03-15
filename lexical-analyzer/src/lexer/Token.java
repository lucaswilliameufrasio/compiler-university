package lexer;

public class Token {
	private Tag tag;
	private String lexeme;

	public Token(Tag t, String l) {
		tag = t;
		lexeme = l;
	}

	public Tag tag() {
		return tag;
	}

	public String lexeme() {
		return lexeme;
	}

	@Override
	public String toString() {
		// The token ASSIGN will be printed
		// with that format: <ASSIGN, '='>
		return "<" + tag + ", '" + lexeme + "'>";
	}

}
