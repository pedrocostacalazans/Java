class Operandos {		// classe para carregar os valores
	public int quantidade;
	public int op1 = -1;
	public int op2 = -1;
	public int op3 = -1;
	public int op4 = -1;
	public int op5 = -1;
	public String operacao;
}

public class AlgebraBooleana {
	/*
	   * divide a frase de entrada em cada atributo da classe Operando
	*/
	public static Operandos getOperandos(String statement) {	
		Operandos op = new Operandos();
		op.quantidade = (int) statement.charAt(0) - 48;

		op.op1 = (int) statement.charAt(2) - 48;
		op.op2 = (int) statement.charAt(4) - 48;
		if(op.quantidade >= 3) op.op3 = (int) statement.charAt(6) - 48;
		if(op.quantidade >= 4) op.op4 = (int) statement.charAt(8) - 48;
		if(op.quantidade == 5) op.op5 = (int) statement.charAt(10) - 48;

		if(op.quantidade <= 2) op.operacao = removespaces( getString(statement, 6) );
		else if(op.quantidade == 3) op.operacao = removespaces( getString(statement, 8) );
		else if(op.quantidade == 4) op.operacao = removespaces( getString(statement, 10) );
		else if(op.quantidade == 5) op.operacao = removespaces( getString(statement, 12) );

		return op;
	}

	/* pega a operação -> string a desconsiderando os numeros iniciais
	*/
	public static String getString(String s, int startIndex) {		
		String newString = "";
		for(int i=startIndex ; i < s.length() ; i++) {
			newString += s.charAt(i);
		}
		return newString;
	}

	/* remove os espaços da string com as operações
	*/
	public static String removespaces(String s) {		
		String newString = "";
		for(int i=0 ; i < s.length(); i++) {
			if(s.charAt(i) != ' ') newString += s.charAt(i);
		}
		return newString;
	}

	/* retorna se as strings sao iguais
	*/
	public static boolean equals(String a, String b) {	
		boolean identical = a.length() == b.length();
		for(int i=0; i < a.length() && identical ; i++) {
			identical = a.charAt(i) == b.charAt(i);
		}
		return identical;
	}

	/* correcao para substituir as letras pelos valores
	*/
	public static void correcao(Operandos op) {
		String temp = "";
		
		for(int i=0 ; i < op.operacao.length() ; i++) {		 
			if(op.operacao.charAt(i) == 'A') temp += op.op1;
			else if(op.operacao.charAt(i) == 'B') temp += op.op2;
			else if(op.operacao.charAt(i) == 'C') temp += op.op3;
			else if(op.operacao.charAt(i) == 'D') temp += op.op4;
			else if(op.operacao.charAt(i) == 'E') temp += op.op5;
			else temp += op.operacao.charAt(i);
		}

		op.operacao = temp;
	}

	/* resolve as operações not
	*/
	public static String removeNot(String s) {
		//MyIO.println("not: " + s);
		String newString = "";

		for(int i=0 ; i < s.length() ; i++) {
			if(i < s.length()-5 && s.charAt(i) == 'n' && s.charAt(i+1) == 'o' && s.charAt(i+2) == 't' && s.charAt(i+5) == ')') {
				if(s.charAt(i+4) == '1') newString += "0";
				else newString += "1";
				i += 5;
			} else newString += s.charAt(i);
		}

		return newString;
	}

	/* resolve as operações and
	*/
	public static String removeAnd(String s) {	
		//MyIO.println("and: " + s);
		String newString = "";

		for(int i=0 ; i < s.length() ; i++) {
			if(i < s.length()-7 && s.charAt(i) == 'a' && s.charAt(i+1) == 'n' && s.charAt(i+2) == 'd' && s.charAt(i+7) == ')'/* && virgulas == 1*/) {

				if(s.charAt(i+4) == '1' && s.charAt(i+6) == '1') newString += "1";
				else if(s.charAt(i+4) == '0' && s.charAt(i+6) == '0') newString += "0";
				else if(s.charAt(i+4) == '1' && s.charAt(i+6) == '0') newString += "0";
				else if(s.charAt(i+4) == '0' && s.charAt(i+6) == '1') newString += "0";

				i += 7;
			}
			else if(i < s.length()-9 && s.charAt(i) == 'a' && s.charAt(i+1) == 'n' && s.charAt(i+2) == 'd' && s.charAt(i+9) == ')'/* && virgulas == 2*/) {
				if(s.charAt(i+4) == '0' && s.charAt(i+6) == '0' && s.charAt(i+8) == '0') newString += "0";
				else if(s.charAt(i+4) == '0' && s.charAt(i+6) == '0' && s.charAt(i+8) == '1') newString += "0";
				else if(s.charAt(i+4) == '0' && s.charAt(i+6) == '1' && s.charAt(i+8) == '0') newString += "0";
				else if(s.charAt(i+4) == '0' && s.charAt(i+6) == '1' && s.charAt(i+8) == '1') newString += "0";
				else if(s.charAt(i+4) == '1' && s.charAt(i+6) == '0' && s.charAt(i+8) == '0') newString += "0";
				else if(s.charAt(i+4) == '1' && s.charAt(i+6) == '0' && s.charAt(i+8) == '1') newString += "0";
				else if(s.charAt(i+4) == '1' && s.charAt(i+6) == '1' && s.charAt(i+8) == '0') newString += "0";
				else if(s.charAt(i+4) == '1' && s.charAt(i+6) == '1' && s.charAt(i+8) == '1') newString += "1";
				
				i += 9;
			}
			
			else newString += s.charAt(i);
		}

		return newString;
	}

	/* resolve as operações or
	*/
	public static String removeOr(String s) {		
		//MyIO.println("or: " + s);
		String newString = "";

		for(int i=0 ; i < s.length() ; i++) {
			if(i < s.length()-6 && s.charAt(i) == 'o' && s.charAt(i+1) == 'r' && s.charAt(i+6) == ')'/* && virgulas == 1*/) {
				
				if(s.charAt(i+3) == '0' && s.charAt(i+5) == '0') newString += "0";
				else if(s.charAt(i+3) == '1' || s.charAt(i+5) == '1') newString += "1";

				i += 6;
			}
			else if(i < s.length()-8 && s.charAt(i) == 'o' && s.charAt(i+1) == 'r' && s.charAt(i+8) == ')'/* && virgulas == 2*/) {
				if(s.charAt(i+3) == '0' && s.charAt(i+5) == '0' && s.charAt(i+7) == '0') newString += "0";
				else if(s.charAt(i+3) == '1' || s.charAt(i+5) == '1' || s.charAt(i+7) == '1') newString += "1";
				
				i += 8;
			}
			else if(i < s.length()-8 && s.charAt(i) == 'o' && s.charAt(i+1) == 'r' && s.charAt(i+10) == ')'/* && virgulas == 3*/) {
				if(s.charAt(i+3) == '0' && s.charAt(i+5) == '0' && s.charAt(i+7) == '0' && s.charAt(i+9) == '0') newString += "0";
				else if(s.charAt(i+3) == '1' || s.charAt(i+5) == '1' || s.charAt(i+7) == '1' || s.charAt(i+9) == '1') newString += "1";
				
				i += 10;
			}
			
			else newString += s.charAt(i);
		}

		return newString;
	}

	/* simplifica a equação booleana
	*/
	public static void simplificacao(Operandos op) {
		String temp = op.operacao;
		
		do {		// chama os métodos até que o numero seja ou 1
			temp = op.operacao;

			temp = removeNot(temp);
			temp = removeAnd(temp);
			temp = removeOr(temp);

			op.operacao = temp;
			//MyIO.println(temp);

		} while(temp.length() != 1);

		MyIO.println(temp);
	}

	/* checa se a entrada é "FIM"
	*/
	public static boolean isFim(String word) {
		return word.length() == 1 && word.charAt(0) == '0';
	}

	public static void main(String[] args) {
		String entrada = MyIO.readLine();

		while(! isFim(entrada)) {
			Operandos op = getOperandos(entrada);
			correcao(op);
			simplificacao(op);
			entrada = MyIO.readLine();
		}
		
	}
}
