import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int memberNum = id_list.length;
        int[] answer = new int[memberNum];
        // 누가 누구를 신고했는지
        Map<String, Set<String>> map = new HashMap<>();

        // 신고당한 횟수
        Map<String, Integer> count = new HashMap<>();
        
        int len = report.length;
        for(int i=0; i<len; i++){
            StringTokenizer st = new StringTokenizer(report[i]);
            String from = st.nextToken();
            String to = st.nextToken();
            
            Set<String> name = map.get(from);
            
            if(name==null || !name.contains(to)){
                // 내가 신고당한 횟수
                if(count.get(to)==null){
                    count.put(to, 1);
                }
                else{
                    count.put(to, count.get(to)+1);
                }
            }
            
            
            
            // 누가 누구 신고
            if(name==null){
                name = new HashSet<>();
            }
            name.add(to);
            map.put(from, name);

            
            
        }

        
        for(int i=0; i<memberNum; i++){
            Set<String> sendName = map.get(id_list[i]);
            if(sendName==null) continue;
            
            int cnt = sendName.size();
            
            for(String temp : sendName){
                if(count.get(temp)<k) cnt--;
            }
            
            answer[i] = cnt;
            
        }
        
        
        return answer;
    }
}