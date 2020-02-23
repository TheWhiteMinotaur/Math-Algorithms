package FleurysAlgorithm;

import java.util.ArrayList; 

public class fleury { 
	private int vertices;  
	private ArrayList<Integer>[] edge; 

	fleury(int numVertices){ 
		this.vertices = numVertices; 
		initGraph(); 
	} 
	private void initGraph() { 
		edge = new ArrayList[vertices]; 
		for (int i = 0; i < vertices; i++){ 
			edge[i] = new ArrayList<>(); 
		} 
	} 
	private void printEulerTour(){ 
		Integer u = 0; 
		for (int i = 0; i < vertices; i++){ 
			if (edge[i].size() % 2 == 1){ 
				u = i; 
				break; 
			} 
		} 
		printEuler(u); 
		System.out.println(); 
	} 
	private void printEuler(Integer u){ 
		for (int i = 0; i < edge[u].size(); i++){ 
			Integer v = edge[u].get(i); 
			if (nextEdge(u, v)){ 
				System.out.print(u + "-" + v + " "); 
				removeEdge(u, v); 
				printEuler(v); 
			} 
		} 
	} 
	private boolean nextEdge(Integer u, Integer v){ 
		if (edge[u].size() == 1){ 
			return true; 
		} 
		boolean[] visit = new boolean[this.vertices]; 
		int count1 = count(u, visit); 
		removeEdge(u, v); 
		visit = new boolean[this.vertices]; 
		int count2 = count(u, visit); 
		addEdge(u, v); 
		return (count1 > count2) ? false : true; 
	} 
	private int count(Integer v, boolean[] visit){ 
		visit[v] = true; 
		int count = 1; 
		for (int edge : edge[v]){
			if (!visit[edge]){ 
				count = count + count(edge, visit); 
			} 
		} 
		return count; 
	} 
	private void addEdge(Integer u, Integer v){ 
		edge[u].add(v); 
		edge[v].add(u); 
	} 
	private void removeEdge(Integer u, Integer v){ 
		edge[u].remove(v); 
		edge[v].remove(u); 
	} 
	public static void main(String a[]){ 
		fleury g1 = new fleury(5);
		g1.addEdge(1, 0); 
		g1.addEdge(1, 2); 
		g1.addEdge(2, 0); 
		g1.addEdge(0, 3); 
		g1.addEdge(0, 4); 
		g1.addEdge(4, 3);
		g1.addEdge(2, 3);
		g1.printEulerTour(); 

		fleury g2 = new fleury(3); 
		g2.addEdge(0, 1); 
		g2.addEdge(1, 2); 
		g2.addEdge(2, 0); 
		g2.printEulerTour(); 
		
		fleury g3 = new fleury(5);
		g3.addEdge(0, 1);
		g3.addEdge(1, 2);
		g3.addEdge(2, 3);
		g3.addEdge(3, 1);
		g3.addEdge(1, 4);
		g3.addEdge(4, 0);
		g3.printEulerTour(); 
	} 
} 