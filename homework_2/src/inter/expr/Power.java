package inter.expr;

import lexer.Tag;
import lexer.Token;

public class Power extends Expr {
	protected Expr expr1;
	protected Expr expr2;

	public Power(Token op, Expr e1, Expr e2) {
		super(op, null);
		type = maxType(e1.type(), e2.type());
		if (this.type == null)
			error("tipos incompatíveis");
		expr1 = e1;
		expr2 = e2;
		addChild(expr1);
		addChild(expr2);
	}

	private static Tag maxType(Tag t1, Tag t2) {
		if (!t1.isNum() || !t2.isNum())
			return null;
		else if (t1.isReal() || t2.isReal())
			return Tag.REAL;
		else
			return Tag.INT;
	}

	private static Expr convertToReal(Expr e, Tag type) {
		if (e.type().isReal())
			return e;
		else if (e.type().isInt()) {
			Temp t = new Temp(Tag.REAL);
			code.emitConvert(t, e);
			return t;
		}
		error("Tipos incompatíveis");
		return null;
	}

	@Override
	public Expr gen() {
		Expr e1 = expr1.gen();
		Expr e2 = expr2.gen();
		Expr op1 = convertToReal(e1, e2.type());
		Expr op2 = convertToReal(e2, e1.type());
		Temp d = new Temp(Tag.REAL);
		code.emitPower(d, op1, op2);
		return d;
	}
}
