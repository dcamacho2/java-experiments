public class TraceFibonacci {
	private static String indent = ""; // indentation for trace

	private static int fibb(int n) {
		int retValue; // return value
		System.out.println(indent + "|" + (n));
		indent = indent + "| ";

		if (n == 0 || n == 1) {
			retValue = 1;
		} else 
			retValue = (fibb(n - 1) + fibb(n - 2));

		indent = indent.substring(2);
		 System.out.println(indent + "|" + retValue);

		return (retValue);
	}

	public static void main(String[] args) {
		System.out.println("fibonacci of 9 is " + fibb(9));
	}
}
