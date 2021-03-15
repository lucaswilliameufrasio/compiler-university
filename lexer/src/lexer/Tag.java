package lexer;

public enum Tag {
	// Assign
	ASSIGN("ASSIGN"),
	// Arithmetical Operators
	SUM("SUM"), MUL("MUL"),
	// Logical Operators
	OR("OR"),
	// Relational Operators
	LT("LT"), LE("LE"), GT("GT"),
	// Others
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
