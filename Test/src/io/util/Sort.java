package io.util;

public class Sort {

	public static void easySort(int[] src) {
		int size = src.length;
		int small;
		for (int i = 0; i < size; i++) {
			small = src[i];
			for (int j = i + 1; j < size; j++) {
				if (src[j] < small) {
					src[i] = src[j];
					src[j] = small;
				}
			}
		}
	}

	public static void directSort(int src[]) {
		int size = src.length;
		int temp;
		for (int i = 1; i < size; i++) {
			temp = src[i];
			for (int j = i; j > 0; j--) {
				if (temp < src[j - 1]) {
					src[j] = src[j - 1];
					src[j - 1] = temp;
				} else {
					src[j] = temp;
					break;
				}
			}
		}
	}

	public static void bubbleSort(int src[]) {
		int i = src.length;
		int last = 1;
		int temp;
		while (last > 0) {
			last = 0;
			for (int j = 1; j < i; j++) {
				if (src[j - 1] > src[j]) {
					temp = src[j];
					src[j] = src[j - 1];
					src[j - 1] = temp;
					last = j;
				}

			}
			i = last;
		}
	}

//	public static void quickSort(int src[], int left, int right) {
//		int i, j,temp;
//		if (right > left) {
//			i = left;
//			j = right + 1;
//			do {
//				do
//					i++;
//				while (i < right & src[i] < src[left]);
//				do
//					j--;
//				while (src[j] < src[left] & j > left);
//				if(i<j){
//					temp = src[i];
//					src[i] = src[j];
//					src[j] = temp;
//				}
//			} while (i < j);
//		}
//	}
	
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

	public static void p(Object o) {
		System.out.println(o.toString());
	}

	public static void main(String args[]) {
		int src[] = { 2, 0, 5, 2, 4, 3 };
		// easySort(src);
		// directSort(src);
//		bubbleSort(src);
		quickSort(src, 0, src.length-1);
		p(src[0] + " " + src[1] + " " + src[2] + " " + src[3] + " " + src[4]
				+ " " + src[5]);
	}
}
