import java.util.*;
import java.io.*;
import java.nio.charset.*;

public class AlteracaoAleatoria {
	private static Random random = new Random();
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in, Charset.forName("ISO-8859-1")));

	/* faz a alteração entre as letras da frase
	*/
	public static String randomChange(String word) {
		String changed = "";

		char in = (char) ('a' + Math.abs(random.nextInt()) % 26);
		char out = (char) ('a' + Math.abs(random.nextInt()) % 26);

		for(int i=0 ; i < word.length() ; i++) {
			if(word.charAt(i) == in) changed += out;
			else changed += word.charAt(i);
		}

		return changed;
	}

	/* checa se a entreda é igual a "FIM"
	*/
	public static boolean isFIM(String word) {
		return word.length() == 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M';
    }


	public static void main(String[] args) {
		random.setSeed(4);
		
		try {
			PrintStream output = new PrintStream(System.out, true, "ISO-8859-1");

			String entrada = input.readLine();
			while(! isFIM(entrada)) {
				output.println(randomChange(entrada));
				entrada = input.readLine();
			}
		} catch (IOException e) {}
	}

}
