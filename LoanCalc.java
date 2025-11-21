// Вычисляет периодический платеж, необходимый для погашения заданного кредита.
public class LoanCalc {
	
	static double epsilon = 0.001; 	// Точность аппроксимации
	static int iterationCounter; 	// Количество итераций 
	
	// Gets the loan data and computes the periodical payment.
	// Expects to get three command-line arguments: loan amount (double),
	// interest rate (double, as a percentage), and number of payments (int). 	
	public static void main(String[] args) { 		
		// Gets the loan data
        if (args.length < 3) {
             System.out.println("Недостаточно аргументов. Используются тестовые значения по умолчанию: Loan=100000.0, Rate=5.0, Periods=10");
             args = new String[]{"100000.0", "5.0", "10"};
        }
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) { 
		// ИСПРАВЛЕНИЕ: Используем локальную переменную 'currentBalance' и локальный счетчик 'i'.
        double currentBalance = loan;
        double interestMultiplier = 1.0 + (rate / 100.0);
        
		for (int i = 0; i < n; i++){
			currentBalance = (currentBalance - payment) * interestMultiplier;
		}
		return currentBalance;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		
        // ИСПРАВЛЕНИЕ: 'g' (платеж) должен быть инициализирован как loan/n.
		double g = loan / n;
		
		iterationCounter = 0;
        
		// ИСПРАВЛЕНИЕ: Цикл продолжается, пока остаток положителен (f(g) > 0). Шаг равен epsilon.
		while(endBalance(loan, rate, n, g) > 0){
            // Обновляем g на шаг epsilon
			g += epsilon; 
			iterationCounter++;
		}
		
		return g;
	}
	
	// Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
	public static double bisectionSolver(double loan, double rate, int n, double epsilon) { 	
		iterationCounter = 0;
        
        // L (нижняя граница) - платеж, гарантирующий f(L) > 0.
		double L = loan / n;
        
        // H (верхняя граница) - платеж, гарантирующий f(H) < 0. Используем Math.pow
		double H = loan * Math.pow(1.0 + (rate / 100.0), n); 
        
		// g будет вычисляться внутри цикла
		double g; 
        
        // ИСПРАВЛЕНИЕ: Главный цикл
		while ((H - L) > epsilon){
            iterationCounter++;
            
            // Вычисляем g (середину)
            g = (L + H) / 2.0; 

            // f(g) > 0 означает, что платеж слишком мал, и решение лежит справа.
			if(endBalance(loan, rate, n, g) > 0){
				L = g; // Сдвигаем нижнюю границу
			}
            // f(g) <= 0 означает, что платеж достаточен или слишком велик. Решение лежит слева.
            else { 
				H = g; // Сдвигаем верхнюю границу
			}
            // Убраны некорректные else if и лишние пересчеты g
		}
		
        // Возвращаем g как аппроксимацию (середина конечного интервала)
		return (L + H) / 2.0; 
	}
}