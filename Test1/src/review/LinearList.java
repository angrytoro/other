package review;



public class LinearList<T> {

	private int maxLength;
	private int index = -1;
	Object array[];

	public LinearList(int size) {
		this.maxLength = size;
		this.array = new Object[size];
	}

	public int getLength() {
		return this.index + 1;
	}

	public boolean isEmpty() {
		return this.index == -1;
	}

	@SuppressWarnings("unchecked")
	public T find(int i) {
		if (i < 0 || i >= this.maxLength)
			return null;

		return (T) array[i];
	}

	public int search(T x) {
		for (int i = 0; i < this.maxLength; i++)
			if (array[i].equals(x))
				return i;
		return -1;
	}

	public boolean insert(int i, T x) {
		if (i < -1 || i > index + 1 || this.index == this.maxLength - 1)
			return false;
		for (int j = index; j > i; j--)
			array[j + 1] = array[j];
		array[i] = x;
		this.index++;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinearList<Integer> test = new LinearList<Integer>(20);
		System.out.println(test.getLength());
		test.insert(0, 3);
		System.out.println(test.find(0));
	}

}
