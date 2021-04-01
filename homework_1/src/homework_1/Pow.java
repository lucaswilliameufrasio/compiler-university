package homework_1;

// E  → PE'
// E' → +PE' | ϵ
// P  → FP'
// P' → **FP' | ϵ 
// F  → (E) | a

public class Pow extends ParserBase {

	public static void main(String[] args) {
		String userInput = "(a+(a**(a+(a**a))))";
		new Pow(userInput).parse();
		System.out.println("Prefix: Sintaxe correta.");
	}

	public Pow(String input) {
		super(input);
	}

	@Override
	public boolean parse() {
		e();
		return match(EOF);
	}

	private void e() {
		p();
		e_();
	}

	private void e_() {
		if (lookahead() == '+') {
			match('+');
			p();
			e_();
		}
	}

	private void p() {
		f();
		p_();
	}

	private void f() {
		switch (lookahead()) {
		case '(':
			match('(');
			e();
			match(')');
			break;
		case 'a':
			match('a');
			break;
		default:
			error("Erro de sintaxe: Expressão inválida.");
		}
	}

	private void p_() {
		if (lookahead() == '*') {
			match('*');
			match('*');
			f();
			p_();
		}
	}
}