package inter.expr;

import lexer.Tag;
import lexer.Token;

public class Id extends Expr {
	
	public Id(Token op, Tag type) { 
		super(op, type);
	}
	
	@Override
	public String toString() {
		return "%" + op.lexeme();
	}

	@Override
	public Expr gen() {
		// TODO Auto-generated method stub
		return null;
	}
}