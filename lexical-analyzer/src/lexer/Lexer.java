package lexer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Lexer {
	private static final char EOF_CHAR = (char) -1;
	private static int line = 1;
	private BufferedReader reader;
	private char peek;

	public Lexer(File file) {
		try {
			this.reader = new BufferedReader(new FileReader(file));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.peek = ' ';
	}

	public static int line() {
		return line;
	}

	private char nextChar() {
		if (peek == '\n')
			line++;
		try {
			peek = (char) reader.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return peek;
	}

	private static boolean isWhitespace(int c) {
		switch (c) {
		case ' ':
		case '\t':
		case '\n':
			return true;
		default:
			return false;
		}
	}

	public Token nextToken() {
		while (isWhitespace(peek))
			nextChar();
		switch (peek) {
		case '=':
			nextChar();
			return new Token(Tag.ASSIGN, "=");
		case '+':
			nextChar();
			return new Token(Tag.SUM, "+");
		case '-':
			nextChar();
			return new Token(Tag.SUB, "-");
		case '*':
			nextChar();
			return new Token(Tag.MUL, "*");
		case '/':
			nextChar();
			return new Token(Tag.DIV, "/");
		case '|':
			nextChar();
			return new Token(Tag.OR, "|");
		case '&':
			nextChar();
			return new Token(Tag.AND, "&");
		case '(':
			nextChar();
			return new Token(Tag.LPAREN, "(");
		case ')':
			nextChar();
			return new Token(Tag.RPAREN, ")");
		case ',':
			nextChar();
			return new Token(Tag.COMMA, ",");
		case ';':
			nextChar();
			return new Token(Tag.SEMI, ";");
		case '!':
			nextChar();
			if (peek == '=') {
				nextChar();
				return new Token(Tag.NE, "!=");
			}
			return new Token(Tag.NOT, "!");
		case '<':
			nextChar();
			if (peek == '=') {
				nextChar();
				return new Token(Tag.LE, "<=");
			}
			return new Token(Tag.LT, "<");
		case '>':
			nextChar();
			if (peek == '=') {
				nextChar();
				return new Token(Tag.GE, ">=");
			}
			return new Token(Tag.GT, ">");
		case EOF_CHAR:
			return new Token(Tag.EOF, "");
		default:
			if (Character.isDigit(peek)) {
				String num = "";
				do {
					num += peek;
					nextChar();
				} while (Character.isDigit(peek));
				return new Token(Tag.LINT_INT, num);
			}
		}
		String unk = String.valueOf(peek);
		nextChar();
		return new Token(Tag.UNK, unk);
	}
}
