public class IsRecursivo {
	public static boolean onlyVowels(String word) { return onlyVowels(word, 0); }
	/* retorna se a entrada é formada por apenas vogais
	*/
	public static boolean onlyVowels(String word, int i) {
		boolean onlyVogais;
	
		if (i == word.length()-1) {
			if(isVogal( word.charAt(i) )) {
				onlyVogais = true;
			} else {
				onlyVogais = false;
			}
		} else {
			if(isVogal( word.charAt(i) )) {
				onlyVogais = onlyVowels(word, i+1);
			} else {
				onlyVogais = false;
			}

		}

		return onlyVogais;
	}

	public static boolean onlyConsonants(String word) { return onlyConsonants(word, 0); }
	/* retorna se a entrada é formada por apenas consoantes 
	*/
	public static boolean onlyConsonants(String word, int i) {
		boolean onlyCons;

		if(i == word.length()-1) {
			if(word.charAt(i) >= 65 && word.charAt(i) <= 90 && !isVogal( word.charAt(i) )) {
				onlyCons = true;
			} else {
				onlyCons = false;
			}
		} else {
			if(word.charAt(i) >= 65 && word.charAt(i) <= 90 && !isVogal( word.charAt(i) )) {
				onlyCons = onlyConsonants(word, i+1);
			} else {
				onlyCons = false;
			}
		}

		return onlyCons;
	}
	
	/* retorna se a letra é uma vogal
	*/
	public static boolean isVogal(char letter) {
		return letter == 'A' || letter == 'a' || letter == 'E' || letter == 'e' || letter == 'I' ||
				letter == 'i' || letter == 'O' || letter == 'o' || letter == 'U' || letter == 'u';
	}

	public static boolean isAnInteger(String word) { return isAnInteger(word, 0); }
	/* retorna se a entrada é um numero inteiro
	*/
	public static boolean isAnInteger(String word, int i) {
		boolean integer;

		if(i == word.length()-1) {
			if(word.charAt(i) >= 48 && word.charAt(i) <= 57) {
				integer = true;
			} else {
				integer = false;
			}
		} else {
			if(word.charAt(i) >= 48 && word.charAt(i) <= 57) {
				integer = isAnInteger(word, i+1);
			} else {
				integer = false;
			}
		}

		return integer;
	}

	public static boolean isAnFloat(String word) { return isAnFloat(word, 0, 0); }
	/* retorna se a entrada é um numero real
	*/
	public static boolean isAnFloat(String word, int i, int sign) {  // sign ira contar quantos . ou , existem na string
		boolean isFloat;
		boolean period = true;   // checa se tem . ou , na string
		
		if(word.charAt(i) == '.' || word.charAt(i) == ',') sign++;  // controla a quantidade de . e , na string
		period = (word.charAt(i) == '.' || word.charAt(i) == ',') && sign <= 1;

		if(i == word.length()-1) {
			if(word.charAt(i) >= 48 && word.charAt(i) <= 57 || period) {
				isFloat = true;
			} else {
				isFloat = false;
			}
		} else {
			if(word.charAt(i) >= 48 && word.charAt(i) <= 57 || period) {
				isFloat = isAnFloat(word, i+1, sign);
			} else {
				isFloat = false;
			}
		}

		return isFloat;
	}

	/* retorna "SIM" ou "NAO" de acordo com o valor booleano recebido
	*/
	public static String simOuNao(boolean value) {
		String resp;

		if(value) resp = "SIM";
		else resp = "NAO";

		return resp;
	}

	/* retorna se a entrada é igual a "FIM"
	*/
	public static boolean isFIM(String line) {
		return line.charAt(0) == 'F' && line.charAt(1) == 'I' && line.charAt(2) == 'M';
	}

	public static void main(String[] args) {
		String entrada = MyIO.readLine();

		while(! isFIM(entrada)) {
			System.out.println(simOuNao(onlyVowels(entrada)) + " " + simOuNao(onlyConsonants(entrada)) + " " + simOuNao(isAnInteger(entrada)) + " " + simOuNao(isAnFloat(entrada)));
			entrada = MyIO.readLine();
		}
	}

}
