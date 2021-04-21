public class Palindromo {
	/* retorna se a entrada é ou não um palindromo
	*/
	public static boolean isPalindrome(String word) {
		boolean palind = true;
		for(int i=0 ; i < word.length() ; i++) {
			palind = word.charAt(i) == word.charAt(word.length() -i -1);
			if(! palind) i = word.length();
		}

		return palind;
	}

	/* retorna se a entrada é igual a "FIM"
	*/
	public static boolean isFIM(String word) {
		return word.length() == 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M';
	}

	public static void main(String[] args) {
		String entrada = MyIO.readLine();
		while(! isFIM(entrada)) {
			if(isPalindrome(entrada)) System.out.println("SIM");
			else System.out.println("NAO");
			entrada = MyIO.readLine();
		}
	}
}
