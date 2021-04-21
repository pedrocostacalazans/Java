public class Is {
	/* retorna se a entrada é formada apenas de vogais
	*/
	public static boolean onlyVowels(String word) {
		boolean onlyVogais = true;
		
		for(int i=0 ; i < word.length() ; i++) {
			onlyVogais = isVogal( word.charAt(i) );
			if(! onlyVogais) i = word.length();
		}

		return onlyVogais;
	}

	/* retorna se a entrada é formada por apenas consoantes
	*/
	public static boolean onlyConsonants(String word) {
		boolean onlyCons = true;

		for(int i=0 ; i < word.length() ; i++) {
			onlyCons = word.charAt(i) >= 65 && word.charAt(i) <= 90 && !isVogal( word.charAt(i) );
			if(! onlyCons) i = word.length();
		}

		return onlyCons;
	}

	/* retorna se a letra é uma vogal
	*/
	public static boolean isVogal(char letter) {
		return letter == 'A' || letter == 'a' || letter == 'E' || letter == 'e' || letter == 'I' ||
				letter == 'i' || letter == 'O' || letter == 'o' || letter == 'U' || letter == 'u';
	}

	/* retorna se a entrada é um numero inteiro
	*/
	public static boolean isAnInteger(String word) {
		boolean integer = true;

		for(int i=0 ; i < word.length() ; i++) {
			integer = word.charAt(i) >= 48 && word.charAt(i) <= 57;
			if(! integer) i = word.length();
		}

		return integer;
	}

	/* retorna se a entrada é um numero real
	*/
	public static boolean isAnFloat(String word) {
		boolean isFloat = true;
		boolean period = true;   // checa se tem . ou , na string
		int sign = 0;    // ira contar quantos . ou , existem na string

		for(int i=0 ; i < word.length() ; i++) {
			if(word.charAt(i) == '.' || word.charAt(i) == ',') sign++;  // controla a quantidade de . e , na string
			period = (word.charAt(i) == '.' || word.charAt(i) == ',') && sign <= 1;
			isFloat = ( word.charAt(i) >= 48 && word.charAt(i) <= 57 ) || period;
			if(! isFloat) i = word.length();
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
