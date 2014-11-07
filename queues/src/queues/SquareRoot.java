package queues;

public class SquareRoot {
	public static double sqrRootRecursive(double number, double aprox,
			double tol) {
		if (number == 0) return 0; 
		
		if (Math.abs((aprox * aprox) - number)<= tol)
			return aprox;
		else {
			double temp = (aprox + number/aprox) / (2);
			return sqrRootRecursive(number, temp, tol);
		}
	};

	public static double sqrRootNon(double number, double tol, double aprox) {
		double sqrRoot = 0;
		double temp = 0;
		
		if (number == 0) return 0;

		aprox = number / 2;
		while (number > 0) {
			sqrRoot = ((aprox + number/aprox)) / (2);
			temp = Math.abs(aprox - sqrRoot);
			if (temp < 0.001)
				return sqrRoot;
			else
				aprox = sqrRoot;
		}
		return number;
	};

	public static void main(String[] args) {

		double number = 3.14;
		double aprox = 1;
		double tol = 0.000001;
		
		if (args.length > 0) number = Double.parseDouble(args[0]);

		if (args.length > 1) tol = Double.parseDouble(args[1]);

		if (args.length > 2) aprox = Double.parseDouble(args[2]);
			
		System.out.println(sqrRootRecursive(number, aprox, tol));
		System.out.println(sqrRootNon(number, aprox, tol));
	}
}
