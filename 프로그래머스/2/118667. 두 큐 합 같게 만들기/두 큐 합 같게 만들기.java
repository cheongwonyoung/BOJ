import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        
        ArrayDeque<Integer> dqueue1 = new ArrayDeque<>();
        ArrayDeque<Integer> dqueue2 = new ArrayDeque<>();
        long sumQueue1 = 0l;
        long sumQueue2 = 0l;
        
        int len = queue1.length;
        
        for(int i=0; i<len; i++){
            dqueue1.offer(queue1[i]);
            sumQueue1 += queue1[i];
            
            dqueue2.offer(queue2[i]);
            sumQueue2 += queue2[i];
        }
        if((sumQueue1+sumQueue2)%2!=0) answer=-1;
        else{
            int cnt=0;
            while(cnt<=len*3 && sumQueue1!=sumQueue2){
                if(dqueue1.isEmpty() || dqueue2.isEmpty()) break;
                if(sumQueue1<sumQueue2){
                    int num = dqueue2.poll();
                    sumQueue2-=num;
                    sumQueue1+=num;
                    dqueue1.offer(num);
                }
                else{
                    int num = dqueue1.poll();
                    sumQueue1-=num;
                    sumQueue2+=num;
                    dqueue2.offer(num);
                }         

                cnt++;
            }
            if(sumQueue1==sumQueue2) answer = cnt;
            else answer=-1;
        }
        
        return answer;
    }
}
