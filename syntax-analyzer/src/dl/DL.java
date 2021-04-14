package dl;

import java.io.File;

import lexer.Lexer;
import lexer.Tag;
import lexer.Token;
import parser.Parser;

public class DL {
	public static void main(String[] args) {
		// Analysis
		Lexer l = new Lexer(new File("prog.dl"));
		Parser p = new Parser(l);
		p.parse();
		
		// Print the syntatic tree
		System.out.println(p.parseTree());
		System.out.println("finalizado");
	}
}

/*
 * public class DL { public static void main(String[] args) { Token t1 = new
 * Token(Tag.ASSIGN, "="); Token t2 = new Token(Tag.LE, "<=");
 * System.out.println(t1); System.out.println(t2); } }
 */
