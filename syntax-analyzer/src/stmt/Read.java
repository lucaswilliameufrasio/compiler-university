package stmt;

import expr.Id;
import lexer.Tag;

public class Read extends Stmt {
	private Id id;
	
	public Read(Id i) {
		id = i;
		addChild(id);
	}
	
	@Override
	public String toString() {
		return Tag.READ.toString();
	}
}
