import java.io.*;

public class Arquivo{
	public static void main(String[] args) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("teste.txt", "rw");
		
		int n = MyIO.readInt();


		double registro, valor=0;

		// le os doubles para serem escritos no arquivo	
		for(int c=0 ; c < n ; c++) {
			registro = MyIO.readDouble();	

			raf.writeDouble(registro);
		}
		
		raf.close();


		raf = new RandomAccessFile("teste.txt", "r");

		raf.seek(0);
		raf.seek(8 * (n-1)); // poe o ponteiro do arquivo no ultimo double

		for(int vez=0 ; vez < n ; vez++) {
			valor = raf.readDouble();
			boolean temDigito = valor - ((long) valor) > 0;
			if(temDigito) System.out.println( valor);
			else System.out.println( (long) valor);

			try {
				raf.seek(8 * (n-vez) - 16);  // volta o double lido e + 1 double para ser lido
			} catch (IOException e) {}
		}


		raf.close();
		
	}
}
