import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int[] nums;
    static boolean[] visited;
    static List<Integer> list;
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        nums = new int[n+1];

        for(int i=1; i<=n; i++){
            nums[i] = Integer.parseInt(in.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n+1];
        for(int i=1; i<=n; i++){
            visited[i]=true;
            dfs(i, i);
            visited[i]=false;
        }

        System.out.println(list.size());
        for (int num : list){
            System.out.println(num);
        }
    }

    public static void dfs(int before, int after){
        if(nums[before]==after) list.add(after);

        if(!visited[nums[before]]){
            visited[nums[before]]=true;
            dfs(nums[before], after);
            visited[nums[before]]=false;
        }

    }
}