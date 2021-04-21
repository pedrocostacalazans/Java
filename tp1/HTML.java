import java.io.*;
import java.net.*;
import java.nio.charset.*;

public class HTML {
	/* retorna uma string com o conteudo html da pagina
	*/
	public static String parseHtml(String nome, String address) {
		String html = "";
		try {
			String parseLine;
			URL URL = new URL(address); 
			BufferedReader br = new BufferedReader(new InputStreamReader(URL.openStream(), Charset.forName("UTF-8")));

			while ((parseLine = br.readLine()) != null) {
				html += parseLine;
			}
    		br.close();
	
		} catch (MalformedURLException me) {
			System.out.println(me);

		} catch (IOException ioe) {
			System.out.println(ioe);
		}

		return html;
	}

	/* itera por cada caractere checando em qual contagem ele encaixa ; e mostra o resultado na tela
	*/
	public static void printResult(String html, String nome) {
		int
		a = 0, ah = 0, aCrase = 0, aTil = 0, aCircun = 0,
		e = 0, eh = 0, eCrase = 0,		     eCircun = 0,
		o = 0, ih = 0, iCrase = 0,		     iCircun = 0,
		i = 0, oh = 0, oCrase = 0, oTil = 0, oCircun = 0,
		u = 0, uh = 0, uCrase = 0,		     uCircun = 0,
		br = 0, table = 0, consoante = 0;
		
		for(int j=0 ; j < html.length() ; j++) {
			if(html.charAt(j) == 'a') a++;
			else if(html.charAt(j) == 'e') e++;
			else if(html.charAt(j) == 'i') i++;
			else if(html.charAt(j) == 'o') o++;
			else if(html.charAt(j) == 'u') u++;

			else if(html.charAt(j) == '\u00E1') ah++;
			else if(html.charAt(j) == '\u00E9') eh++;
			else if(html.charAt(j) == '\u00F3') oh++;
			else if(html.charAt(j) == '\u00FA') uh++;
			else if(html.charAt(j) == '\u00ED') ih++;
			
			else if(html.charAt(j) == '\u00E0') aCrase++;
			else if(html.charAt(j) == '\u00E8') eCrase++;
			else if(html.charAt(j) == '\u00EC') iCrase++;
			else if(html.charAt(j) == '\u00F2') oCrase++;
			else if(html.charAt(j) == '\u00F9') uCrase++;
			
			else if(html.charAt(j) == '\u00E2') aCircun++;
			else if(html.charAt(j) == '\u00EA') eCircun++;
			else if(html.charAt(j) == '\u00EE') iCircun++;
			else if(html.charAt(j) == '\u00F4') oCircun++;
			else if(html.charAt(j) == '\u00FB') uCircun++;

			else if(html.charAt(j) == '\u00E3') aTil++;
			else if(html.charAt(j) == '\u00F5') oTil++;

			else if( isConsoante(html.charAt(j)) ) consoante++;

			else if(html.charAt(j) == '<' && html.charAt(j+1) == 'b' && html.charAt(j+2) == 'r' && html.charAt(j+3) == '>') {
				br++;
				if(html.charAt(j) == '<') j += 3;
				else if(html.charAt(j) == 'b') j += 2;
				else if(html.charAt(j) == 'r') j ++;
			}
			else if(html.charAt(j) == '<' && html.charAt(j+1) == 't' && html.charAt(j+2) == 'a' && html.charAt(j+3) == 'b' && html.charAt(j+4) == 'l' && html.charAt(j+5) == 'e' && html.charAt(j+6) == '>') {
				table++;
				if(html.charAt(j) == '<') j += 6;
				else if(html.charAt(j) == 't') j += 5;
				else if(html.charAt(j) == 'a') j += 4;
				else if(html.charAt(j) == 'b') j += 3;
				else if(html.charAt(j) == 'l') j += 2;
				else if(html.charAt(j) == 'e') j ++;
			}
				
			
		}

		MyIO.println("a("+a+") e("+e+") i("+i+") o("+o+") u("+u+") á("+ah+") é("+eh+") í("+ih+") ó("+oh+") ú("+uh+") à("+aCrase+") è("+eCrase+") ì("+iCrase+") ò("+oCrase+") ù("+uCrase+") ã("+aTil+") õ("+oTil+") â("+aCircun+") ê("+eCircun+") î("+iCircun+") ô("+oCircun+") û("+uCircun+") consoante("+consoante+") <br>("+br+") <table>("+table+") "+nome);
	}

	/* retorna se a letra é consoante
	*/
	public static boolean isConsoante(char letter) {
		return !isVogal(letter) && (/* (letter >= 65 && letter <= 90) ||*/ (letter >= 97 && letter <= 122) );
	}

	/* retorna se a letra é uma vogal
	*/
	public static boolean isVogal(char letter) {
		return letter == 'A' || letter == 'E' || letter == 'I' || letter == 'O' || letter == 'U' ||
			   letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' || letter == 'u';
	}

	/* retorna se a entrada é igual a "FIM"
	*/
	public static boolean isFim(String word) {
		return word.length() == 3 && word.charAt(0) == 'F' && word.charAt(1) == 'I' && word.charAt(2) == 'M';
	}

	public static void main(String[] args) {
		String nome = MyIO.readLine();
		
		while(! isFim(nome)) {
			String url = MyIO.readLine();
			String html = parseHtml(nome, url);
			printResult(html, nome);
			nome = MyIO.readLine();
		}
	}
}
