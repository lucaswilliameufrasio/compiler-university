package expr;

import javax.swing.text.html.HTML.Tag;

import lexer.Token;

public class Id extends Expr {
	public Id(Token op, Tag type) {
		super(op, type);
	}
	
	@Override
	public String toString() {
		return "%" + op.lexeme();
	}
}
