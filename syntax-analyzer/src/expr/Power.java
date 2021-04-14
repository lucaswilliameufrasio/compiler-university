package expr;

import lexer.Token;

public class Power extends Expr {
	protected Expr expr1;
	protected Expr expr2;
	
	public Power(Token op, Expr e1, Expr e2) {
		super(op, null);
		expr1 = e1;
		expr2 = e2;
		addChild(expr1);
		addChild(expr2);
	}
}
