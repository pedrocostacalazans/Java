#include <iostream>
#include <cstring>

using namespace std;

/* retorna se a entrada é ou não um palindromo
*/
bool isPalindrome(string word, int i) {
	bool palind;

	if(i == word.length() - 1) {
		if(word[i] == word[0]) {   // assumindo que i é a ultima posição da string, a comparação é feita com o elemento inicial
			palind = true;
		} else {
			palind = false;
		}
	} else {
		if(word[i] == word[word.length()-i-1]) {
			palind = isPalindrome(word, i+1);
		} else {
			palind = false;
		}
	}

	return palind;
}

bool isPalindrome(string word) { return isPalindrome(word, 0); }

/* retorna se a entrada é igual a "FIM"
*/
bool isFIM(string word) {
	return word.length() == 3 && word[0] == 'F' && word[1] == 'I' && word[2] == 'M';
}

int main() {
	string entrada;
	
	getline(cin, entrada);
	while(! isFIM(entrada)) {
		if(isPalindrome(entrada)) cout << "SIM" << endl;
		else cout << "NAO" << endl;
		getline(cin, entrada);
	}

	return 0;
}
