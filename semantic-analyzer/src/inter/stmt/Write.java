package inter.stmt;

import inter.expr.Id;
import lexer.Tag;

public class Write extends Stmt {
	private Id id;

	public Write(Id i) {
		if (!i.type().isInt())
			error("O comando 'escreva' pode escrevar apenas valores inteiros.");
		id = i;
		addChild(id);
	}

	@Override
	public String toString() {
		return Tag.WRITE.toString();
	}
}
