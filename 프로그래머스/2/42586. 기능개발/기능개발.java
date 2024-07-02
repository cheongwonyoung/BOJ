import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        // 현재 위치에서 배포가 될 때 까지 시간을 흘려 보냄
        // progresses의 원소가 100보다 작은 값이 나올 때 까지 cnt셈
        
        int len = progresses.length;
        int idx = 0;
        while(idx<len){
            int cnt=0;
            while(progresses[idx]<100) {
                for(int i=idx; i<len; i++){
                    progresses[i] += speeds[i];
                }
            }
            while(idx<len&&progresses[idx]>=100){
                idx++;
                cnt++;
            }
            System.out.println(cnt);
            list.add(cnt);
        }
        
        int size = list.size();
        answer = new int[list.size()];
        for(int i=0; i<size; i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}