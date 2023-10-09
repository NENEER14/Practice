import java.util.Arrays;

public class SumOfTwoNum {

	private static String findTwoNumbers(int[] array, int sumNum) {
		int i = 0;
		int j = array.length - 1;
		while (i < j) {
			if (array[i] + array[j] < sumNum) {
				i++;
			} else if (array[i] + array[j] > sumNum) {
				j--;
			} else {
				return "" + array[i] + ", " + array[j];
			}
		}
		return "No combination found";
	}

	public static void main(String[] args) {
		// int[] array = {2, 4, 7, 8, 1}; //1,2,4,7,8
		int[] array = { 2, 2, 7, 8, 1, 1 };
		int sumNum = 3;
		Arrays.sort(array);
		System.out.println(findTwoNumbers(array, sumNum));
	}
}

