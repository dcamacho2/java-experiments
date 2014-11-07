package lists;

public interface FunnyList {
	// The implementing class must have a Node member called thisList 
	// This requirement could be enforced if we used an abstract class
	// instead of an interface!
	
	void append (Node u);
		// -- add u to the end of thisList
	
	void prepend (Node u);
		// -- add u to the front of thisList
	
	void insert (int i, Node u);
		// -- insert u as the i-th node in the thisList
	
	void printList();
		// -- prints the value of each node in thisList
	
	void Splice(Node L);
		// -- splices the list L with thisList
	
	Node split();
		// -- splits the list into two lists of sizes [n]
		// and [n] where n is the original size. The first list
		// (of size [n]) is retained as thisList, the second list is returned.

}
