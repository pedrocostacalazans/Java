public class PalindromoRecursivo {
	/* retorna se a entrada é ou não um palindromo
	*/
	public static boolean isPalindrome(String word, int i) {
		boolean palind;

		if(i == word.length() - 1) {
			if(word.charAt(i) == word.charAt(0)) {   // assumindo que i é a ultima posição da string, a comparação é feita com o elemento inicial
				palind = true;
			} else {
				palind = false;
			}
		} else {
			if(word.charAt(i) == word.charAt(word.length()-i-1)) {
				palind = isPalindrome(word, i+1);
			} else {
				palind = false;
			}
		}

		return palind;
	}

	public static boolean isPalindrome(String word) { return isPalindrome(word, 0); }

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
