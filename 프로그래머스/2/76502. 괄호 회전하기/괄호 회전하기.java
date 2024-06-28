import java.util.*;
class Solution {
    
    public int solution(String s) {
        int answer = 0;
        
        ArrayDeque<Character> queue = new ArrayDeque<>();
        
        int len = s.length();
        for(int i=0; i<len; i++){
            queue.offer(s.charAt(i));
        }
        
        for(int i=0; i<len; i++){
            // stack
            ArrayDeque<Character> stack = new ArrayDeque<>();
            
            // stack is correct?
            boolean check = true;
            for(int j=0; j<len; j++){
                char ch = queue.poll();
                if(ch=='[' || ch=='{' || ch=='(') stack.push(ch);
                else if(stack.isEmpty()){
                    check = false;
                    break;
                }
                else if(ch==']'){
                    char ch2 = stack.pop();
                    if(ch2!='[') {
                        check=false;
                        break;
                    }
                    
                }
                else if(ch=='}'){
                    char ch2 = stack.pop();
                    if(ch2!='{') {
                        check=false;
                        break;
                    }
                    
                }
                else if(ch==')'){
                    char ch2 = stack.pop();
                    if(ch2!='(') {
                        check=false;
                        break;
                    }
                    
                }
                
            }
            if(check && stack.isEmpty() && queue.isEmpty()) answer++;
            
            // rotate
            queue = new ArrayDeque<>();
            for(int j=i+1; j<len; j++){
                queue.offer(s.charAt(j));
            }
            for(int k=0; k<i+1; k++){
                queue.offer(s.charAt(k));   
            }
        }


        return answer;
    }
    
}





