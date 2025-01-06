import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		String str = in.readLine();
		String bombStr = in.readLine();
		
		Stack<Character> stack = new Stack<>();
		
		int strLen = str.length();
		int bombStrLen = bombStr.length();
		
		for(int i=0; i<strLen; i++) {
			stack.push(str.charAt(i));
			
			if(stack.size()>=bombStrLen) {
				boolean flag = true;
				for(int j=0; j<bombStrLen; j++) {
					if(stack.get(stack.size()-bombStrLen+j) != bombStr.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag){
					for(int j=0; j<bombStrLen; j++) {
						stack.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {			
			sb.append(stack.pop());
		}
		
		if(sb.length()==0) {
			System.out.println("FRULA");
		}
		else {
			System.out.println(sb.reverse().toString());
		}
		
	}
}