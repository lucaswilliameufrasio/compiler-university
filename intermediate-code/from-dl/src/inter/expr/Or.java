package inter.expr;

import lexer.Tag;
import lexer.Token;

public class Or extends Expr {
	protected Expr expr1;
	protected Expr expr2;
	
	public Or(Expr e1, Expr e2) {
		super(new Token(Tag.OR, "|"), Tag.BOOL);
		if ( !e1.type().isBool() ||  
			 !e2.type().isBool() )
			error("O operador lógico | só "
					+ "pode ser aplicado entre "
					+ "tipos booleanos");
		expr1 = e1;
		expr2 = e2;
		addChild(expr1);
		addChild(expr2);
	}

	@Override
	public Expr gen() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void jumping(int t, int f) {
		int label = code.newLabel();
		expr1.jumping(t, label);
		code.emitLabel(label);
		expr2.jumping(t, f);
	}
}
