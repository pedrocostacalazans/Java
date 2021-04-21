#include <iostream>
#include <cstring>

using namespace std;

/* retorna se a letra é uma vogal
*/
bool isVogal(char letter) {
	return letter == 'A' || letter == 'a' || letter == 'E' || letter == 'e' || letter == 'I' ||
	letter == 'i' || letter == 'O' || letter == 'o' || letter == 'U' || letter == 'u';
}

/* retorna se a entrada é formada apenas por vogais
*/
bool onlyVowels(string word) {
	bool onlyVogais = true;

	for(int i=0 ; i < word.length() ; i++) {
		onlyVogais = isVogal( word[i] );
		if(! onlyVogais) i = word.length();
	}

	return onlyVogais;
}

/* retorna se a entrada é formada apenas por consoantes
*/
bool onlyConsonants(string word) {
	bool onlyCons = true;

	for(int i=0 ; i < word.length() ; i++) {
		onlyCons = word[i] >= 65 && word[i] <= 90 && !isVogal( word[i] );
		if(! onlyCons) i = word.length();
	}

	return onlyCons;
}

/* retorna se a entrada é um inteiro
*/
bool isAnInteger(string word) {
	bool integer = true;

	for(int i=0 ; i < word.length() ; i++) {
		integer = word[i] >= 48 && word[i] <= 57;
		if(! integer) i = word.length();
	}

	return integer;
}

/* retorna se a entrada é um float
*/
bool isAnFloat(string word) {
	bool isFloat = true;
	bool period = true;   // checa se tem . ou , na string
	int sign = 0;    // ira contar quantos . ou , existem na string

	for(int i=0 ; i < word.length() ; i++) {
		if(word[i] == '.' || word[i] == ',') sign++;  // controla a quantidade de . e , na string
		period = (word[i] == '.' || word[i] == ',') && sign <= 1;
		isFloat = ( word[i] >= 48 && word[i] <= 57 ) || period;
		if(! isFloat) i = word.length();
	}

	return isFloat;
}

/* retorna "SIM" ou "NAO" de acordo comm o valor booleano recebido
*/
string simOuNao(bool value) {
	string resp;

	if(value) resp = "SIM";
	else resp = "NAO";

	return resp;
}

/* retorna se a entrada é igual a "FIM"
*/
bool isFIM(string line) {
	return line[0] == 'F' && line[1] == 'I' && line[2] == 'M';
}

int main() {
	string entrada;
	getline(cin, entrada);

	while(! isFIM(entrada)) {
		cout << simOuNao(onlyVowels(entrada)) << " " << simOuNao(onlyConsonants(entrada)) << " " << simOuNao(isAnInteger(entrada)) << " " << simOuNao(isAnFloat(entrada)) << endl;
		getline(cin, entrada);
	}

	return 0;
}

