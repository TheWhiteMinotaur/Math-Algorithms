package havel;
import java.util.*;

public class Havel {
	static LinkedList<Integer> vertices = new LinkedList<Integer>();

	public static void setList(){
		Scanner scnr = new Scanner(System.in);
		System.out.println("Please enter how many digits are in your problem");
		int times = scnr.nextInt();

		while(times >= 1){
			System.out.println("Please enter your next digit:");
			Integer response = scnr.nextInt();
			vertices.add(response);
			times --;
		}
		Collections.sort(vertices);
		Collections.reverse(vertices);
		System.out.println(vertices);
	}
	public static void subtract(){
		int first = vertices.getFirst();

		if(first > vertices.size()){
			System.out.println("Beginning number is too large");
		}
		else{
			for(int i = 0; i <= vertices.size()+2; i++){
				int fir = vertices.getFirst();
				vertices.removeFirst();
				for(int k = 0; k <= fir-1; k++){
					vertices.add(k,vertices.get(k)-1);
					vertices.remove(k+1);	
				}
				Collections.sort(vertices);
				Collections.reverse(vertices);
				System.out.println(vertices);
			}
		}	
	}
	public static void main(String[]args){
		setList(); 
		subtract();
	} 
} 