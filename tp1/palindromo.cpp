#include <iostream>
#include <cstring>

using namespace std;

/* retorna se a entrada é ou não um palindromo
*/
bool isPalindrome(string word) {
	bool palind = true;
	for(int i=0 ; i < word.length() ; i++) {
		palind = word[i] == word[word.length() -i -1];
		if(! palind) i = word.length();
	}

	return palind;
}

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
