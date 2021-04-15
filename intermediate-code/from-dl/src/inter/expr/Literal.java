package inter.expr;

import lexer.Tag;
import lexer.Token;

public class Literal extends Expr {

	public Literal(Token op, Tag type) {
		super(op, type);
	}
	
	@Override
	public String toString() {
		switch (op.tag()) {
		case TRUE: 
			return "true";
		case FALSE: 
			return "false";
		default: 
			return op.lexeme();
		}
	}

	@Override
	public Expr gen() {
		// TODO Auto-generated method stub
		return null;
	}
}
