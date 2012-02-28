package util;

public class Sort {

	public static void p(Object o) {
		System.out.println(o);
	}

	public static void swap(int arg1, int arg2) {
		int temp = arg1;
		arg1 = arg2;
		arg2 = temp;
	}

	public static void easySort(int arg[]) {
		int size = arg.length;
		int small;
		int temp;
		for (int i = 0; i < size - 1; i++) {
			small = i;
			for (int j = i; j < size; j++)
				if (arg[small] > arg[j])
					small = j;
			temp = arg[i];
			arg[i] = arg[small];
			arg[small] = temp;
		}
	}

	public static void insertSort(int arg[]) {
		int size = arg.length;
		int temp;
		for (int i = 1; i < size; i++) {
			temp = arg[i];
			int j = i;
			for (; j > 0 && temp < arg[j - 1]; j--) {
				arg[j] = arg[j - 1];
			}
			arg[j] = temp;
		}
	}

	public static void bubbleSort(int arg[]) {
		int hasSwap = 1;
		int size = arg.length;
		int temp;
		int i;
		while (hasSwap > 0) {
			hasSwap = 0;
			i = 0;
			for (; i < size - 1; i++) {
				if (arg[i] > arg[i + 1]) {
					temp = arg[i];
					arg[i] = arg[i + 1];
					arg[i + 1] = temp;
					hasSwap++;
				}
			}
		}
	}

	public static void quickSort(int arg[], int left, int right) {
		int temp = arg[left];
		int changeTemp;
		int i, j;
		if (left > right) {
			i = left;
			j = right + 1;
			do {
				do
					i++;
				while (arg[i] < temp);
				do
					j--;
				while (arg[j] > temp);
				if (i < j) {
					changeTemp = arg[i];
					arg[i] = arg[j];
					arg[j] = changeTemp;
				}
			} while (i < j);
			arg[left] = arg[j];
			arg[j] = temp;
			quickSort(arg, left, j - 1);
			quickSort(arg, j + 1, right);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int array[] = { 4, 2, 0, 1, 5, 3, 8 };
		// easySort(array);
		p(array[0]);
		// insertSort(array);
		// bubbleSort(array);
		quickSort(array, 0, array.length - 1);
		p(array[0]);
	}

}
