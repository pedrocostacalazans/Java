import java.util.*;
import java.io.*;
import java.nio.charset.*;

public class Ciframento {
	private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in,Charset.forName("ISO-8859-1")));
	
	/* retorna a string com a criptografia -  faz um shift com valor ascii de 3 
	*/
    public static String exibirCriptografado(String text) {		
        String encrypted = "";

        for(int i=0; i < text.length() ; i++) {
        	encrypted += (char) ( text.charAt(i) + 3);  // adicionando à  variável criptografada a coerção
        }

        return encrypted;
    }

	/* checa se a entrada é "FIM"
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
