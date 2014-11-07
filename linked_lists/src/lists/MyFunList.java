package lists;

public class MyFunList implements FunnyList {
	private Node thisList = null;
	private int counter = -1; // start at -1 so that it counts the 0 object

	public void append(Node u) {
		if (thisList == null) {
			thisList = u;
		} else if (thisList.next == null) {
			thisList.next = u;
		} else {
			Node current = thisList; // pretty much the pointer that moves to
										// count the number of nodes in the list
			while (current.next != null) {
				current = current.next; // moves the pointer while the it is not
										// null
			}
			current.next = u; // once its null, then the next becomes the
								// desired node
		}
		counter++;
	}

	public void prepend(Node u) {
		if (thisList == null) {
			thisList = u;
		} else if (u.next == null) {
			u.next = thisList;
			thisList = u;
		} else {
			Node current = u;
			while (current.next != null) {
				current = current.next;
			}
			current.next = thisList;
			thisList = u;
		}
		counter++;
	}

	public void insert(int i, Node u) {
		if (i <= 0) {
			prepend(u);
		} else {
			Node current = thisList;
			int index = 1;
			while (current.next != null && index != i) {
				current = current.next;
				index++;
			}
			if (index == i) {
				Node tail = current.next;
				current.next = u;
				while (u.next != null) {
					u = u.next;
				}
				u.next = tail;
			} else {
				append(u);
			}
		}
		counter++;
	}

	public void printList() {
		if (thisList == null) {
			System.out.println("List is empty");
		} else {
			Node current = thisList;
			while (current != null) {
				System.out.print(current.value + "  ");
				current = current.next; // move to next element if not null,
										// moves current
			}
		}
	}

	public void Splice(Node L) {
		Node currentList = thisList;
		Node currentL = L;
		MyFunList currentCombined = new MyFunList();
		while (currentList != null && currentL != null) {
			currentCombined.append(new Node(currentList.value));
			currentList = currentList.next;
			currentCombined.append(new Node(currentL.value));
			currentL = currentL.next;
		}
		while (currentList != null) {
			currentCombined.append(new Node(currentList.value));
		}
		while (currentL != null) {
			currentCombined.append(new Node(currentL.value));
		}
		this.thisList = currentCombined.thisList;
	}

	public Node split() {
		Node current = thisList;
		for (int d = 0; d < counter / 2; d++) {
			current = current.next;
		}
		Node currentToreturn = current.next;
		current.next = null;
//		System.out.println(counter); Making Sure the counter works correctly
		return currentToreturn;
	}

	public static void main(String[] args) {
		MyFunList demo = new MyFunList();
		Node a = new Node();
		Node b = new Node();
		Node c = new Node();
		Node d = new Node();
		Node e = new Node();
		Node f = new Node("test");
		Node g = new Node();
		Node h = new Node();

		System.out.println("This is with empty:");
		demo.printList();
		
		System.out.println();
		System.out.println();
		
		System.out.println("This is with append:");
		demo.append(a);
		demo.append(b);
		demo.printList();
		
		System.out.println();
		System.out.println();

		System.out.println("This is with prepend:");
		demo.prepend(c);
		demo.prepend(d);
		demo.prepend(e);
		demo.printList();

		System.out.println();
		System.out.println();

		System.out.println("This is with insertion in third place (begin word count at 0):");
		demo.insert(3, f);
		demo.printList();

		System.out.println();
		System.out.println();
		
		System.out.println("This is with split:");
		demo.split();
		demo.printList();
		
		System.out.println();
		System.out.println();
//		
//		System.out.println("This is with split:");
//		demo.Splice();
//		demo.printList();
	}

}
