import java.util.*;
class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<>();
        if(!map.containsKey(a)){
            map.put(a, 1);
        }
        else{
            map.put(a, map.get(a)+1);
        }
        if(!map.containsKey(b)){
            map.put(b, 1);
        }
        else{
            map.put(b, map.get(b)+1);
        }if(!map.containsKey(c)){
            map.put(c, 1);
        }
        else{
            map.put(c, map.get(c)+1);
        }if(!map.containsKey(d)){
            map.put(d, 1);
        }
        else{
            map.put(d, map.get(d)+1);
        }

        
        
        // 4개 다 같은 경우 (p, p, p, p) // 1개
        // 1111 * p
        if(map.size()==1){
            for(int num : map.keySet()){
                answer=num*1111;
            }
        }
        
        // 3개만 같은 경우 (p, p, p, q) // 2개
        // (10*p+q)^2
        // 2개씩 같은 경우(p, p, q, q) // 2개
        // (p+q) * |p-q|
        if(map.size()==2){
            int p = 0;
            int q = 0;
            for(int num : map.keySet()){
                if(p==0) p=num;
                else q = num;
            }
            if(map.get(p)==2){
                answer = (p+q) * Math.abs(p-q);
            }
            else{
                if(map.get(p)==3){
                    answer = (10*p+q)*(10*p+q);
                }
                else{
                    answer = (10*q+p)*(10*q+p);
                }
                
            }
        }
        
        // 2개만 같은 경우(p, p, q, r) // 3개
        // q*r
        if(map.size()==3){
            answer = 1;
            for(int num : map.keySet()){
                if(map.get(num)==2) continue;
                answer *= num;
            }
        }
        
        // 다 다른 경우 (p,q,r,s) // 4개
        // min(p,q,r,s)
        if(map.size()==4){
            int temp = Integer.MAX_VALUE;
            for(int num : map.keySet()){
                if(temp>num) temp = num;
            }
            answer=temp;
        }
        
        return answer;
    }
}