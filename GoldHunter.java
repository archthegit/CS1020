// CS1020 (AY2016/7 Semester 4) - Lab 2
//
// Name:Archana Pradeep 
// Matric. No.: A0162694W
// Lab group: 1
//
// calculate amount of gold (in tons) found in a cell is directly proportional to the number of mines surrounding it. 
//That is, if a cell is neighbor to 2 mine cells, then the amount of gold in the cell is 2 tons, 
//if it is neighbor to 3 mine cells, then the amount of gold is 3 tons, etc.
//
//
//
//

import java.util.*;

class MyMap {
	private char[][] charMap; // map containing the character labels
	private int nRow; // number of rows
	private int nCol; // number of columns

	// read in a character map from input
	public MyMap(Scanner sc) {       
		nRow = sc.nextInt();
		nCol = sc.nextInt();
		charMap = new char[nRow][nCol];
		String line;
		for (int i = 0; i < nRow; i++) {
			line = sc.next();
			for (int j = 0; j < nCol; j++) {        
				setLabel(i, j, line.charAt(j));     
			}
		}

	}

	// mutator for charMap
	public void setLabel(int row, int col, char label) { 
		charMap[row][col] = label; 
	}

	// accessor for charMap
	public char getLabel(int row, int col) { 
		return charMap[row][col];
	}
	//converting the '.' to '0'
	public void modMap(char[][] map){
		int i,j;
		for (i=0;i<charMap.length;i++){
			for (j=0;j<charMap[i].length;j++){
				if (charMap[i][j]!='*'){
					charMap[i][j]='0';
				}
			}
		}
	}

	//creating a new integer array for easier computation
	public int[][] convertMap(){
		modMap(charMap);
		int i,j;
		int[][] arr= new int[charMap.length][charMap[0].length];
		for (i=0;i<charMap.length;i++){
			for (j=0;j<charMap[0].length;j++){
				arr[i][j]= Character.getNumericValue(charMap[i][j]);
			}
		}
		return arr;
	}

	//converting the array back
	public String[][] convertBack(int [][] arr){
		int i,j;
		String[][] map= new String[arr.length][arr[0].length];
		for(i=0;i<arr.length;i++){
			for (j=0;j<arr[i].length;j++){
				if (arr[i][j]!=-1){
					map[i][j]= String.valueOf(arr[i][j]);
				}
				else{
					map[i][j]="*";
				}
			}
		}
		return map;
	}
	// To print the output map
	public void display(String[][] map) {
		for (int i = 0; i < nRow; i++) {
			for (int j = 0; j < nCol; j++) {        
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}

public class GoldHunter {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyMap map = new MyMap(sc);   
		int[][] arr= map.convertMap();
		computeMap(arr);
		String[][] _map= map.convertBack(arr);
		map.display(_map);
	}
	public static void computeMap(int[][] arr){
		int i,j;
		for(i=0;i<arr.length;i++){
			for (j=0;j<arr[i].length;j++){
				if(arr[i][j]==0){
					//diagonal checks
					if (((i-1)>=0)&&((j-1)>=0)){
						if (arr[i-1][j-1]==-1){
							arr[i][j]++;
						}
					}
					if (((i-1)>=0)&&((j+1)<arr[i].length)){
						if (arr[i-1][j+1]==-1){
							arr[i][j]++;
						}
					}
					if (((i+1)<arr.length)&&((j-1)>=0)){
						if (arr[i+1][j-1]==-1){
							arr[i][j]++;
						}
					}
					if (((i+1)<arr.length)&&((j+1)<arr[i].length)){
						if (arr[i+1][j+1]==-1){
							arr[i][j]++;
						}
					}
					//vertical and horizontal checks
					if ((i-1)>=0){
						if (arr[i-1][j]==-1){
							arr[i][j]++;
						}
					}
					if ((i+1)<arr.length){
						if (arr[i+1][j]==-1){
							arr[i][j]++;
						}
					}
					if ((j-1)>=0){
						if (arr[i][j-1]==-1){
							arr[i][j]++;
						}
					}
					if ((j+1)<arr[i].length){
						if (arr[i][j+1]==-1){
							arr[i][j]++;
						}
					}
				}
			}
		}
	}
}
