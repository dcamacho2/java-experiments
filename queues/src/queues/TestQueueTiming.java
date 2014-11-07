package queues;

import java.util.LinkedList;
import java.util.Random;

public class TestQueueTiming {

	public static void main(String[] args) {
		int n = 1000;
		int s = 111;
		final int count = 3;
		Random rg = new Random(s);
		if (args.length>0)  n = Integer.parseInt(args[0]);
		if (args.length>1) s = Integer.parseInt(args[1]);
		
		System.out.println(n + " " + s);
		
		
		
		poorQueue mq = new poorQueue();
		
	
		long startpq = System.nanoTime();
		// time it takes for poorQueue to enqueue and dequeue n elements
		for (int i = 0; i< n; i++)
		{
			mq.enqueue(""+ rg.nextInt(100));
		}

		while (mq.isEmpty()) 
		{
			System.out.printf("%s\n",mq.dequeue());
		}
		long endpq = System.nanoTime();
		
		
		
		//begin of rich queue
		
		LinkedList<String> rq = new LinkedList<String>();
		
		long startrq = System.nanoTime();
		// time it takes for richQueue to enqueue and dequeue n elements
		for (int i = 0; i< n; i++)
		{
			rq.add(""+ rg.nextInt(100));
		}
		while (!rq.isEmpty()) 
		{
			rq.remove();
		}
		long endrq = System.nanoTime();
		
		
		for (int i = 1; i <= count; i++){
			long resultPQ = (endpq - startpq);
			long resultRQ = (endrq - startrq);
			System.out.println("Test " + i + ": " + resultPQ + " nanoseconds of difference for PoorQueue");
			System.out.println("Test " + i + ": " + resultRQ + " nanoseconds of difference for RichQue");
			System.out.println();
		}
		

	}

}
