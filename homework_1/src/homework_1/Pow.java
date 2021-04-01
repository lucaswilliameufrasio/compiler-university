package homework_1;

// E  → PE'
// E' → +PE' | ϵ
// P  → FP'
// P' → **FP' | ϵ 
// F  → (E) | a

public class Pow extends ParserBase {

	public static void main(String[] args) {		
		new Pow("(a+(a**(a+(a**a))))").parse();
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
		/*
		 * if (lookahead() == '(') { match('('); e(); match(')'); } else if (lookahead()
		 * == 'a') { match('a'); } else {
		 * error("f()Erro de sintaxe: Expressão inválida."); }
		 */
		
		switch(lookahead()) {
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
