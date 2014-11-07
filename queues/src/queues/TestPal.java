package queues;

public class TestPal {
	public static boolean pal (String s){
		if (s.length() <= 1) return true;
		else if (s.charAt(0) == s.charAt(s.length() - 1)){
			return pal(s.substring(1, s.length()-1));
		}
		return false;	
	}
	
	public static void main (String [] args){
		String def = "1221";
		if (args.length > 0) def = args[0];
		for (int i = 0; i < args.length; i++){ // the for loop allows multiple command line inputs
			def = args[i];
			System.out.println(pal(def));
		}
	}

}
