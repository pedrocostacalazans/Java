#include <stdio.h>
#include <stdlib.h>

int main() {
	FILE *p = fopen("teste.txt", "wb");
	
	int n;
	scanf("%d", &n);


	double registro, valor;

	
	for(int c=0 ; c < n ; c++) {	// le os doubles e os escreve no arquivo
		scanf("%lf", &registro);	

		fwrite(&registro, sizeof (double), 1, p);
	}
	
	fclose(p);


	p = fopen("teste.txt", "rb");


	fseek(p, -sizeof(double), SEEK_END);  // coloca o cabeçote no fim do arquivo e le 4 bits

	for(int vez=0 ; vez < n ; vez++) {
		fread(&valor, sizeof (double), 1, p);
		printf ("%g\n", valor);

		fseek(p, -2*sizeof (double), SEEK_CUR);  // volta 1 posição + a posição percorrida pelo fread -  a partir da posição corrente
	}


	fclose(p);
	
	return 0;
}
