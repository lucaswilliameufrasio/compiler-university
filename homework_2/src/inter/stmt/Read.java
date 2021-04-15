package inter.stmt;

import inter.expr.Expr;
import inter.expr.Id;
import inter.expr.Temp;
import lexer.Tag;

public class Read extends Stmt {
	private Id id;

	public Read(Id i) {
		id = i;
		addChild(id);
	}

	@Override
	public void gen() {
		Temp t = new Temp(id.type());
		code.emitAlloca(t);
		t.gen();
		code.emitRead(t);
		Temp out = new Temp(id.type());
		code.emitLoad(out, t);
		code.emitStore(id, out);
	}

	@Override
	public String toString() {
		return Tag.READ.toString();
	}
}