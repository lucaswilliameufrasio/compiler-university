package inter;

import java.util.LinkedList;

public class Node {
	private LinkedList<Node> children = new LinkedList<Node>();
	
	protected void addChild(Node n) {
		children.add(n);
	}
	
	protected LinkedList<Node> children() {
		return children;
	}
	
	public String strTree() {
		return strStree("");
	}
	
	private String strStree(String ident) {
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(toString());
		for(Node node: children()) {
			stringBuffer.append("\n" + ident + "|--> ");
			stringBuffer.append(node.strStree(ident + "    "));
		}
		return stringBuffer.toString();
	}
}
