package lexer;

public enum Tag {
	// Assign
	ASSIGN("ASSIGN"),
	// Arithmetical Operators
	SUM("SUM"), SUB("SUB"), MUL("MUL"),
	// Logical Operators
	OR("OR"),
	// Relational Operators
	LT("LT"), LE("LE"), GT("GT"),
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
