class Solution {
    static int cnt;
    static int len;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        len = numbers.length;
        
        dfs(0,0,numbers, target);
        System.out.println(cnt);
        answer = cnt;
        return answer;
    }
    
    void dfs(int sum, int idx, int[] numbers, int target){
        if(idx==len){
            if(target==sum){
                cnt++;
            }
            return;
        }
        
 
        dfs(sum + numbers[idx], idx+1, numbers, target);
        dfs(sum - numbers[idx], idx+1, numbers, target);
        
        
    }
}




