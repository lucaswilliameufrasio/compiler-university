package lexer;

public enum Tag {
	// Reserved Words
	PROGRAM("PROGRAM"), BEGIN("BEGIN"), END("END"), INT("INT"), REAL("REAL"), BOOL("BOOL"), TRUE("TRUE"),
	FALSE("FALSE"), READ("READ"), WRITE("WRITE"),
	// Assign
	ASSIGN("ASSIGN"),
	// Arithmetical Operators
	SUM("SUM"), SUB("SUB"), MUL("MUL"), DIV("DIV"),
	// Logical Operators
	OR("OR"), AND("AND"), NOT("NOT"),
	// Relational Operators
	LT("LT"), LE("LE"), GT("GT"), GE("GE"), NE("NE"),
	// Symbols
	LPAREN("LPAREN"), RPAREN("RPAREN"), COMMA("COMMA"), SEMI("SEMI"),
	// Literals
	LINT_INT("LINT_INT"), LINT_REAL("LINT_REAL"),
	// Identifiers
	ID("ID"),
	// Others
	// EOF = End of File
	// UNK = Unknown Pattern
	EOF("EOF"), UNK("UNK");

	private String name;

	private Tag(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return name;
	}
}
