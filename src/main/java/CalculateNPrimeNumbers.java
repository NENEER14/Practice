public class CalculateNPrimeNumbers {
    private static void findPrimeNumbers(int count) {
		int calculatePrimeNumCount = 0;
		int number = 2;
		while(calculatePrimeNumCount < count) {
			if(isPrimeNumber(number)) {
				System.out.println(number);
				calculatePrimeNumCount ++;
				number++;
			} else {
				number ++;
			}
		}
	}
    private static boolean isPrimeNumber(int n) {
		for(int i = 2; i <= n / 2 ; i++) {
			if(n % i == 0) {
				return false;
			}
		}
		return true;
	}
    
    public static void main(String[] args){
        int n = 10;
		findPrimeNumbers(n);
    }
}
