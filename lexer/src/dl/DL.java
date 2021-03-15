package dl;

import lexer.Tag;
import lexer.Token;

public class DL {
	public static void main(String[] args) {
		Token t1 = new Token(Tag.ASSIGN, "=");
		Token t2 = new Token(Tag.LE, "<=");
		System.out.println(t1);
		System.out.println(t2);
	}
}
