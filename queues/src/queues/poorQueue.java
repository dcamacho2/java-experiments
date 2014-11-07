package queues;

import java.util.Random;

public class poorQueue {
	
	static int MAX = 100;
	
	String[] q;
	int front = 0;	// Invariant:  front <= back
	int back = 0;	// Size of queue is back-front

	
	public poorQueue (int size) { //constructor 
		q= new String[size];
		MAX = size;
	}
	public poorQueue()
	{
		q= new String[MAX];
	}
	
	String dequeue()
	{
		if(front == back - 1) return null;
		return q[++front];   // remove from front of queue
	}
	
	boolean isEmpty(){
		return (front == back);
	}
	
	void enqueue(String item)
	{
		if(back > MAX - 1) return;
		q[back++] = item;
	}
	
	boolean isFull(){
		return back <= MAX - 1;
	}

//	public static void main(String[] args) {
//		
//		Random rg = new Random();
//		int n = 5;
//		if (args.length>0)  n = Integer.parseInt(args[0]);
//		
//		poorQueue mq = new poorQueue();
//		
//		for (int i = 0; i< n; i++){
//			mq.enqueue(""+ rg.nextInt(100));
//		}
//
//		while (!mq.isEmpty()) {
//			System.out.printf("%s\n",mq.dequeue());
//		}
//	}//main

}//poorQueue
