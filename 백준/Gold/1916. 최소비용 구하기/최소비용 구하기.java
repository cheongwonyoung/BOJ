import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		
//		int n = Integer.parseInt(in.readLine());
//		int m = Integer.parseInt(in.readLine());
//
////		List<List<Integer>> list = new ArrayList<List<Integer>>();
////		for(int i=0; i<=n; i++) {
////			list.add(new ArrayList<Integer>());
////		}
//		
//		int[][] arr = new int[n+1][n+1];
//		for(int i=1; i<=n; i++) {
//			for(int j=0; j<=n; j++) {
//				if(i==j) continue;
//				arr[i][j] = 10000000;
//			}
//		}
//		for(int i=0; i<m; i++){
//			StringTokenizer st = new StringTokenizer(in.readLine());
//			int from = Integer.parseInt(st.nextToken());
//			int to = Integer.parseInt(st.nextToken());
//			int cost = Integer.parseInt(st.nextToken());
//			
//			arr[from][to] = Math.min(arr[from][to],cost);
//			
////			list.get(from)
//			
//			
//		}
//		
//		StringTokenizer st = new StringTokenizer(in.readLine());
//		int start = Integer.parseInt(st.nextToken());
//		int end = Integer.parseInt(st.nextToken());
//		
//		for(int k=1; k<=n; k++) {
//			for(int i=1; i<=n; i++) {
//				for(int j=1; 
//						j<=n; j++) {
//					arr[i][j] = Math.min(arr[i][j], arr[i][k]+arr[k][j]);
//				}
//			}
//		}
//
//		System.out.println(arr[start][end]);
//		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(in.readLine());
		int m = Integer.parseInt(in.readLine());

		List<List<Node>> list = new ArrayList<List<Node>>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<m; i++){
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			list.get(from).add(new Node(to, cost));
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		int[] dis = new int[n+1];
		boolean[] check = new boolean[n+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		int result = dijk(start, end, list, dis,check);
		System.out.println(result);
		
	}

	private static int dijk(int start, int end, List<List<Node>> list, int[] dis, boolean[] check) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		dis[start] = 0;
		queue.offer(new Node(start,0));
		
		while(!queue.isEmpty()) {
			Node curNode = queue.poll();
			int cur = curNode.end;
			
			if(check[cur]) continue;
			check[cur] = true;
			for(Node node : list.get(cur)) {
				if(!check[node.end] && dis[node.end] > node.weight+dis[cur]) {
					dis[node.end] = node.weight+dis[cur];
					queue.offer(new Node(node.end, dis[node.end]));
				}
			}
			
		}
		return dis[end];
	}
	
}
class Node implements Comparable<Node>{
	int end;
	int weight;
	
	public Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node o) {
		
		return weight-o.weight;
	}
	
}