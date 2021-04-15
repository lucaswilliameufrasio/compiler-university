package inter.stmt;

import inter.expr.Expr;
import inter.expr.Id;
import lexer.Tag;

public class Read extends Stmt {
	private Id id;

	public Read(Id i) {
		id = i;
		addChild(id);
	}

	@Override
	public void gen() {
		Expr e = id.gen();
		code.emitRead(e);
	}

	@Override
	public String toString() {
		return Tag.READ.toString();
	}
}