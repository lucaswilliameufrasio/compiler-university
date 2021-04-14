package parser;

import expr.Bin;
import expr.Expr;
import expr.Id;
import expr.Literal;
import expr.Or;
import expr.Rel;
import inter.Node;
import lexer.Lexer;
import lexer.Tag;
import lexer.Token;
import stmt.Assign;
import stmt.Block;
import stmt.Decl;
import stmt.If;
import stmt.Program;
import stmt.Stmt;
import stmt.Write;

public class Parser {
	private Lexer lexer;
	private Token look;
	private Node root;

	public Parser(Lexer lex) {
		lexer = lex;
		move();
	}
	
	public String parseTree() {
		return root.strTree();
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
		root = program();
	}

	private Program program() {
		match(Tag.PROGRAM);
		Token tokenId = match(Tag.ID);
		Stmt blck = block();
		match(Tag.DOT);
		match(Tag.EOF);
		return new Program(tokenId, (Block)blck);
	}

	private Stmt block() {
		Block bclk = new Block();
		match(Tag.BEGIN);
		while (look.tag() != Tag.END) {
			bclk.addStmt(stmt());
			match(Tag.SEMI);
		}
		match(Tag.END);
		
		return bclk;
	}

	private Stmt stmt() {
		switch (look.tag()) {
		case BEGIN:
			return block();
		case INT:
		case REAL:
		case BOOL:
			return decl();
		case ID:
			return assign();
		case IF:
			return ifStmt();
		case WRITE:
			return writeStmt();
		default:
			error("Comando inválido");
		}
		
		return null;
	}

	private Stmt decl() {
		Token type = move();
		Token tokenId = match(Tag.ID);
		Id id = new Id(tokenId, type.tag());
		return new Decl(id);
	}

	private Stmt assign() {
		Token token = match(Tag.ID);
		Id id = new Id(token, null);
		match(Tag.ASSIGN);
		Expr expr = expr();
		return new Assign(id, expr);
	}

	private Expr expr() {
		Expr expr = rel();
		while (look.tag() == Tag.OR) {
			move();
			expr = new Or(expr, rel());
		}
		return expr;
	}

	private Expr rel() {
		Expr expr = arith();
		while (look.tag() == Tag.LT || look.tag() == Tag.LE || look.tag() == Tag.GT) {
			Token operation = move();
			expr = new Rel(operation, expr, arith());
		}
		return expr;
	}

	private Expr arith() {
		Expr expr = term();
		while (look.tag() == Tag.SUM || look.tag() == Tag.SUB) {
			Token operation = move();
			expr = new Bin(operation, expr, term());
		}
		return expr;
	}

	private Expr term() {
		Expr expr = factor();
		while (look.tag() == Tag.MUL) {
			Token operation = move();
			expr = new Bin(operation, expr, factor());
		}
		return expr;
	}

	private Expr factor() {
		Expr expr = null;
		switch (look.tag()) {
		case LPAREN:
			move();
			expr = expr();
			match(Tag.RPAREN);
			break;
		case LIT_INT:
			expr = new Literal(move(), Tag.INT);
			break;
		case LIT_REAL:
			expr = new Literal(move(), Tag.REAL);
			break;
		case TRUE:
		case FALSE:
			expr = new Literal(move(), Tag.BOOL);
			break;
		case ID:
			Token token = match(Tag.ID);
			expr = new Id(token, null);
			break;
		default:
			error("expressão inválida");
		}
		return expr;
	}
	
	private Stmt ifStmt() {
		match(Tag.IF);
		match(Tag.LPAREN);
		Expr expr = expr();
		match(Tag.RPAREN);
		Stmt s1 = stmt();
		return new If(expr, s1);
	}
	
	private Stmt writeStmt() {
		move();
		match(Tag.LPAREN);
		Token token = match(Tag.ID);
		Id id = new Id(token, null);
		match(Tag.RPAREN);
		return new Write(id);
	}
}
