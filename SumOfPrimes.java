package discussion;

import java.util.Scanner;

public class SumOfPrimes {

	static boolean isPrime(int n) {
		int factor = 0;
		for(int i=1;i<=n;i++) {
			if(n%i==0) {
				factor++;
			}
		}
		if (factor == 2) {
			return true;
		}
		else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a number: ");
		int num = scan.nextInt();
		for(int i=2; i<=num;i++) {
			if(isPrime(i) && isPrime(num-i)) {
				System.out.println(num + " = " + i + " + " + (num-i));
			}
		}
	}
}
