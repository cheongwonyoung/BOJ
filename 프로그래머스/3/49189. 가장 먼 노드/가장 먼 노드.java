import java.util.*;
class Solution {
    static int maxCnt = 0;
    static int maxDis = 0;
    static int num;
    static int[][] arr;
    static boolean[] check;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        num = n;
        int len = edge.length;
//         arr = new int[n+1][n+1];
        
//         for(int i=0; i<len; i++){
//             arr[edge[i][0]][edge[i][1]] = 1;
//             arr[edge[i][1]][edge[i][0]] = 1;
//         }
        
        //인접 리스트로 변환
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i=1; i<=n; i++){
            graph.put(i,new ArrayList<Integer>());
        }
        for(int i=0;i<edge.length; i++){
            int x = edge[i][0];
            int y = edge[i][1];
            
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
       
        check = new boolean[n+1];
        bfs(graph, 1);
        
        
        System.out.print(maxCnt);
        answer = maxCnt;
        return answer;
    }
    
    void bfs( Map<Integer, List<Integer>> graph ,int node){
        ArrayDeque<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(node,0));
        check[node] = true;
        
        while(!queue.isEmpty()){
            
            Position position = queue.poll();
            node = position.node;
            int dis = position.cnt;
            
            if(maxDis==dis){
                maxCnt++;
            }
            
            if(maxDis < dis) {
                maxDis = dis;
                maxCnt = 1;
            }
            
            // for(int next=1; next<=num; next++){
            //     if(check[next]) continue;
            //     if(arr[node][next]==1) {
            //         queue.offer(new Position(next, dis+1));
            //         check[next] = true;
            //     }
            // }
            for(int nextVertex: graph.get(node)){
                if(!check[nextVertex]){
                    queue.offer(new Position(nextVertex,dis+1));
                    check[nextVertex] = true;
                }
            }
            
        }
        
    }
    class Position{
        int node;
        int cnt;
        public Position(int node, int cnt){
            this.node = node;
            this.cnt = cnt;
        }
    }
}



