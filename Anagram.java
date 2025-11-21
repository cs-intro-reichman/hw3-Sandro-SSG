/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		int a = str1.length();
		int c = str2.length();
		int aa = a;
		int cc = c;
		char q = 32;
		for (int o = 0; o < a; o++){
			if (str1.charAt(o) == q){
				aa--;
			}
		}
		for (int p = 0; p < c; p++){
			if (str2.charAt(p) == q){
				cc--;
			}
		}
		if (aa != cc){
			return false;
		}else{
			for (int i = 0; i < aa; i++ ) {
			char b = str1.charAt(i);
				for (int u = 0; u < cc; u++){
				char x = str2.charAt(u);
					if (b == x){
					break;
					}
				}
			}		
		}
		// Replace the following statement with your code
		return true;
	}
		
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {

		// Replace the following statement with your code

		// "What? "
		char a;
		String b = "";
		int c = str.length();
		for (int i = 0; i < c; i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90){
			a = (char)(str.charAt(i) + 32);
			b += a;
			}else if(str.charAt(i) >= 97 && str.charAt(i) <= 122){
			a = str.charAt(i);
			b += a;
			}
		}
		return b;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
		public static String randomAnagram(String str) {
        int length = str.length();
        int random;
        String stri = "";
        char c;
        for (int i = 0; i < length; i++) {
            random = (int) (Math.random() * str.length());
            c = str.charAt(random);
            str = str.substring(0, random) + str.substring(random + 1);
            stri += c;
        }
        return stri;
    }
		// Replace the following statement with your code
}

