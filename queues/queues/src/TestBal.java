package queues;

import java.util.Stack;

public class TestBal{
    public static boolean bal(String s, int pointer, Stack<Character> demo) {
        if (pointer == s.length() || s.length() < 1)
            return true;

        char c = s.charAt(pointer);
        char e = ' ';
 
        if (c == ')' || c == ']') {
            if (c == ')' || c == ']') {
            	if (demo.isEmpty()){
            		e = '\0';
            	} else {
            		e = demo.pop();
            	}
            }
            if(e != c)
                return false;
        }
        
        if(c == '[')
            demo.push(']');
        else if(c == '(')
            demo.push(')');
        
        return bal(s, pointer + 1, demo);

    }
    public static void main(String[] args){
    	int i = 0;
    	Stack demo = new Stack<Character>();
		String def = "((()))[]";
		
		if (args.length > 0) def = args[0];		
    	
    	System.out.println(bal(def, i, demo));
    }
}
