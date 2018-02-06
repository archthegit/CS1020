// CS1020 (AY2016/7 Semester 4) - Lab 9
//
// Name: Archana Pradeep
// Matric. No.: A0162694W
// Lab group: 1
//
// program recursively identifies the cost for the robot to travel from start to destination
//
//
//
//
//

import java.util.*;

public class RobotMovement { 
	private static final int MAX_VALUE = 1000;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int size= sc.nextInt();
		int[][] arr= new int[size][size];
		int startI= sc.nextInt();
		int startJ=sc.nextInt();
		for (int i=0;i<size;i++){
			for (int j=0;j<size;j++){
				arr[i][j]=sc.nextInt();

			}

		} 
		System.out.println(computeCost(arr,startI,startJ));     

	}
	public static int computeCost(int[][] arr, int startI, int startJ){
		int end=(arr.length-1);
		int cost=arr[startI][startJ];
		//base cases:
		if ((startI==end-1 && startJ==end-1) ||(startI==end && startJ==end-1)){
			return (cost+arr[end][end]);
		}

		else if (startI==end &&startJ!=end){
			cost+=computeCost(arr,startI,startJ+1);
		}
		else if (startJ==end && startI!=end){
			cost+=computeCost(arr,startI+1,startJ);    
		}

		//recursive case
		else if (startI<end && startJ<end){
			//check if bottom cost is smaller than the other two
			if ((arr[startI+1][startJ]<arr[startI][startJ+1])&&(arr[startI+1][startJ]<arr[startI+1][startJ+1])){
				cost+=computeCost(arr,startI+1,startJ);

			}
			// check if cost at right is smaller than other two
			if ((arr[startI][startJ+1]<arr[startI+1][startJ])&&(arr[startI][startJ+1]<arr[startI+1][startJ+1])){	
				cost+=computeCost(arr,startI,startJ+1);

			}
			//check is diagonal cost is less than or equal to the other two moves
			else if ((arr[startI+1][startJ+1]<=arr[startI+1][startJ])&&(arr[startI+1][startJ+1]<=arr[startI][startJ+1])){
				cost+=computeCost(arr,startI+1,startJ+1);

			}
			// checks if up or right is equal to each other
			else if (arr[startI+1][startJ]==arr[startI][startJ+1]){ 
				cost+=computeCost(arr,startI+1,startJ);

			}
		}
		return cost;
	}
}
