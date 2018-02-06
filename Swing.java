// CS1020 (AY2016/7 Semester 4) - Lab 8
//
// Name: Archana Pradeep
// Matric. No.: A0162694W
// Lab group: 1
//
// program that can tell them how many pair of 
// trees that they can swing from and to.
//
//
//
//
//
import java.util.*;

public class Swing {
	public static ArrayDeque<Integer> trees= null;// original queue
	public static ArrayDeque<Integer> temp= null;// temperory queue
	public static int count=0;
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int numTree= sc.nextInt();
		int swings= 0;
		trees = new ArrayDeque<Integer>(numTree);


		for (int i=0;i<numTree;i++){
			trees.offer(sc.nextInt());// initialising original queuw
		}
		for (int i=0;i<numTree;i++){
			temp = new ArrayDeque<Integer>(numTree-i);
			swings+=processTree();// calling processTree function
		}
		System.out.println(swings);
	}
	public static int processTree(){
		int swings=0;
		int flag=0;
		int prev=0;
		if (!trees.isEmpty()){
			temp.offer(trees.poll());// shift first element to temp queue
		}
		while(!trees.isEmpty()){
				if (flag==1){
					temp.offer(trees.poll()); // if prev is bigger than the first value, then do not increment
				
				}
				else if (trees.peek()<temp.peek()){
					if (prev<trees.peek()){
						swings++; // incrementing num of swings if prev is smaller than latest value
					}
					
 					prev=Math.max(trees.peek(),prev);
					temp.offer(trees.poll()); 
					
				}
				else if (trees.peek()>=temp.peek()){
					swings++;
					flag=1;// setting flag 1 if trees.peek() is bigger
					temp.offer(trees.poll());
				}
				
			}
				temp.poll();// reassigning temp back to tree
		
				trees=temp;
		return swings;
	}

}

