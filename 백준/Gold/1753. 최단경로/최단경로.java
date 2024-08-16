import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Node22 implements Comparable<Node22>{
	int end;
	int weight;
	
	public Node22(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}
	
	@Override
	public int compareTo(Node22 o) {
		// TODO Auto-generated method stub
		return this.weight - o.weight;
	}
	

}


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		int[] dis = new int[V+1];
		Arrays.fill(dis, Integer.MAX_VALUE);
		int start = Integer.parseInt(in.readLine());
		
		
		List<List<Node22>> graph = new ArrayList<List<Node22>>();
		for(int i=0; i<=V; i++) {
			graph.add(new ArrayList<Node22>());
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(in.readLine());
			
			int u = Integer.parseInt(st.nextToken()); 
			int v = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken()); 
			
			graph.get(u).add(new Node22(v, w));
			
		}
		
		
		PriorityQueue<Node22> queue = new PriorityQueue<>();
		queue.offer(new Node22(start, 0));
		dis[start] = 0;
		
		while(!queue.isEmpty()) {
			Node22 node = queue.poll();
			int end = node.end;
			int weight = node.weight;
			
			// 업데이트 한 적이 있는 경우
			if(weight > dis[end]) continue;

			for(int i=0; i<graph.get(end).size(); i++) {
				int cost = dis[end] + graph.get(end).get(i).weight;
				
				if(cost < dis[graph.get(end).get(i).end]) {
					dis[graph.get(end).get(i).end] = cost;
					queue.offer(new Node22(graph.get(end).get(i).end, cost));
				}
			}
			
		}
		
		for(int i=1; i<=V; i++) {
			if(dis[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
			}
			else {				
				System.out.println(dis[i]);
			}
		}

	}
}