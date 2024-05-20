import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
    	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    	String[] str = in.readLine().split("");
    	String result="";
    	for(String word : str) {
    		String trans = word.toLowerCase();
    		if(trans.toLowerCase().equals(word)) {
    			result+=word.toUpperCase();
    		}
    		else {
    			result+=trans;
    		}
    	}
    	System.out.println(result);
    }
 
}