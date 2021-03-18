package expr;

import javax.swing.text.html.HTML.Tag;

import lexer.Token;

public class Expr {
	protected Token op;
	protected Tag type;

	public Expr(Token op, Tag type) {
		this.op = op;
		this.type = type;
	}

	public Token op() {
		return op;
	}

	public Tag type() {
		return type;
	}
	
	@Override
	public String toString() {
		return op.tag().toString();
	}
}
