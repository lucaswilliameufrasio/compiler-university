package inter.expr;

import inter.Node;
import lexer.Tag;
import lexer.Token;

public abstract class Expr extends Node {
	protected Token op;
	protected Tag type;

	public Expr(Token op, Tag type) {
		this.op = op;
		this.type = type;
	}

	public abstract Expr gen();

	public static Expr widen(Expr e, Tag type) {
		if (e.type == type || e.type().isReal())
			return e;
		else if (e.type().isInt()) {
			Temp t = new Temp(Tag.REAL);
			code.emitConvert(t, e);
			return t;
		}
		error("Tipos incompatíveis");
		return null;
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
