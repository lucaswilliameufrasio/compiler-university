package parser;

import lexer.Lexer;
import lexer.Tag;
import lexer.Token;

public class Parser {
	private Lexer lexer;
	private Token look;

	public Parser(Lexer lex) {
		lexer = lex;
		move();
	}

	private Token move() {
		Token save = look;
		look = lexer.nextToken();
		return save;
	}

	private void error(String s) {
		System.err.print("linha " + Lexer.line() + ": " + s);
		System.exit(0);
	}

	private Token match(Tag t) {
		if (look.tag() == t)
			return move();
		error("Símbolo inesperado");
		return null;
	}

	public void parse() {
		program();
	}

	private void program() {
		match(Tag.PROGRAM);
		match(Tag.ID);
		block();
		match(Tag.DOT);
		match(Tag.EOF);
	}
	
	private void block() {
		match(Tag.BEGIN);
		while(look.tag() != Tag.END) {
			stmt();
			match(Tag.SEMI);
		}
		match(Tag.END);
	}
	
	private void stmt() {
		switch(look.tag()) {
		case BEGIN: block(); break;
		case INT: case REAL: case BOOL:
			decl(); break;
		default: error("Comando inválido");
		}
	}
	
	private void decl() {
		move();
		match(Tag.ID);
	}
}
