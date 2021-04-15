package dl;

import java.io.File;
import java.io.PrintWriter;

import lexer.Lexer;
import parser.Parser;

public class DL {
	public static void main(String[] args) {
		//Análise
		Lexer l = new Lexer(
				new File("prog.dl"));		
		Parser p = new Parser(l);
		p.parse();

		//Imprimindo a árvore sintática
		System.out.println(p.parseTree());
		
		try {
			PrintWriter pw =
					new PrintWriter("prog.ll");
			pw.write(p.code());
			pw.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("finalizado");
	}
}
