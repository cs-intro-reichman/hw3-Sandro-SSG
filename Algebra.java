// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		// Replace the following statement with your code
		for(int i = 0; i < x2; i++) {
			x1++;
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		// Replace the following statement with your code
		for(int i = 0; i < x2; i++) {
			x1--;
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		// Replace the following statement with your code
		int sum = 0;
			for(int i = 0; i < x2; i++) {
				for(int u = 0; u < x1; u++){
					sum++;
				}
			}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		// Replace the following statement with your code
		int result = 1;
		for ( int i = 0; i <= (n-1); i ++){
			result = times(x,result);
			}
		return result;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
		// Replace the following statement with your code
		int res = 0;
		int a = x1;
		while (a > 0){
			res++;
			for (int u = 0; u < x2; u++){
				a--;
			}
		}
		if( a < 0){
			res--;
			return res;
		}else{
			return res;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
		// Replace the following statement with your code
		int res = 0;
		int a = x1;
		while (a > 0){
			res++;
			for (int u = 0; u < x2; u++){
				a--;
			}
		}
		if( a < 0){
			int n = plus(a, x2);
			return n;
		}else{
			return 0;
		}
	}

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) {
		int L = 1, H = x;
		int g = div(plus(L, H), 2);
		int stepCounter = 0;
		while (times(g,g) != x) {
			if (times(g,g) < x){
				L = g;
				stepCounter++;
			}else{
				H = g;
				stepCounter++;
			}
			g = div(plus(L, H), 2);
			
			if(stepCounter > 1000){
				break;
			}
		// Replace the following statement with your code
		//g = minus(g, div(minus(times(g, g), x), times(2, g)));
	}	  	  
return g;
}
}