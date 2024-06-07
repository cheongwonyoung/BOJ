import java.util.*;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        int[] cntArr = new int[100001];
        for(String str : strArr){
            cntArr[str.length()]++;
        }
        Arrays.sort(cntArr);
        answer = cntArr[100000];
        return answer;
    }
}