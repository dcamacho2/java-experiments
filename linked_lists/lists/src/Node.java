package lists;

public class Node {
	public String value;
	public Node next;

	public  Node(String s) { // is it supposed to be void??
		value = s;
		next = null;
	}

	public  Node() { // is it supposed to say void?
		value = Zoombinis.randomName();
		next = null;
	}
}
