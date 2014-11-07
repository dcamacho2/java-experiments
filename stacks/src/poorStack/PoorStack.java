package poorStack;

public class PoorStack<T> {
	public Object[] stack;
	public int size = 0;

	public PoorStack() {
		stack = new Object[20];
	}

	public PoorStack(int size) {
		if (size > 0) {
			stack = new Object[size];
		} else {
			System.err.println("Poor Stack has underflowed");
		}
	}

	public void push(T item) {
		if (size < stack.length) {
//			System.out.println(size);
			stack[size] = item;
			size++;
			System.out.println("The size of the stack is now: " + size);
		} else {
			System.err.println("Poor Stack has overflowed");
		}
	}

	public T pop() {
		if (size > 0) {
//			System.out.println(size);
			T temp = (T) stack[size - 1]; // Originally object, casting as T
			stack[size] = null;
			size--;
			System.out.println("The size of the stack is now: " + size);
			return temp;
		} else {
			System.err.println("Poor Stack has underflowed");
			return null;
		}
	}

	public T peek() {
		T top = (T) stack[size - 1];
		return top;
	}

	public static void main(String[] args) {
		PoorStack<String> demo = new PoorStack<String>();

		demo.push(Zoombinis.randomName());
		demo.push(Zoombinis.randomName());
		System.out.println();
		System.out.println(demo.pop());
		System.out.println();
		System.out.println(demo.peek());
		demo.push(Zoombinis.randomName());
		demo.push(Zoombinis.randomName());
		demo.push(Zoombinis.randomName());
		System.out.println();
		System.out.println(demo.peek());
		System.out.println();
		System.out.println(demo.pop());
		System.out.println();
		System.out.println(demo.peek());
		
	}
}
