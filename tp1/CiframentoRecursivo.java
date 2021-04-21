import java.util.*;
import java.io.*;
import java.nio.charset.*;

public class CiframentoRecursivo {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in, Charset.forName( "ISO-8859-1")));
	
	public static String exibirCriptografado(String text) { return exibirCriptografado(text, 0); }

	/* retorna uma string com o shift no valor ascii de 3 em cada caractere
	*/
    public static String exibirCriptografado(String text, int i) {
        String encrypted;

		if(i == text.length()) encrypted = "";
		else {
			encrypted = (char) ( text.charAt(i) + 3) + exibirCriptografado(text, i+1);
		}

        return encrypted;
    }

	/* checa se a entrada é igual a "FIM"
	*/
    public static boolean isFIM(String word) {
		return word.length() == 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M';
    }

    public static void main(String[] args) {
		try {
			PrintStream output = new PrintStream(System.out, true, "ISO-8859-1");

    		String entrada = input.readLine();

        	while(! isFIM(entrada)) {
				output.println(exibirCriptografado(entrada));
	    		entrada = input.readLine();
			}

		} catch (IOException e) {}


        }

}
