// CS1020 (AY2016/7 Semester 4) - Lab 1 Part 1
//
// Name:Archana Pradeep 
// Matric. No.: A0162694W
// Lab group: 1
// Collaborators:NIL
//
//read in integer values for 4 points: the first 2 points are the opposite vertices of one rectangle, and the next 2 points are the opposite vertices of a second rectangle. 
// and then calculate polygon area if a polygon is formed
//
//
//

import java.util.*;
import java.awt.*;

public class OverlapRectangles {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter 2 opposite vertices of 1st rectangle: ");
		Point rect1Vertex1 = new Point(sc.nextInt(), sc.nextInt());//scanning for 4 vertices
		Point rect1Vertex2 = new Point(sc.nextInt(), sc.nextInt());

		System.out.print("Enter 2 opposite vertices of 2nd rectangle: ");
		Point rect2Vertex1 = new Point(sc.nextInt(), sc.nextInt());
		Point rect2Vertex2 = new Point(sc.nextInt(), sc.nextInt());

		arrangeVertices(rect1Vertex1,rect1Vertex2);
		arrangeVertices(rect2Vertex1,rect2Vertex2);

		int area= polygonArea(rect1Vertex1, rect1Vertex2, rect2Vertex1, rect2Vertex2);
		System.out.println("Polygon area = "+area);
	}
	// computes the area of polygon if it is formed
	public static int polygonArea(Point v1,Point v2, Point v3, Point v4){
		int area_union, r1Area,r2Area;//computing area of both rectangles and area of intersection 
		area_union= unionArea(v1,v2,v3,v4);
		if (area_union==0){
			return 0;
		}
		r1Area=Math.abs((v3.x-v4.x)*(v3.y-v4.y));
		r2Area=Math.abs((v2.x-v1.x)*(v2.y-v1.y));
		return (r1Area+r2Area)-area_union;
	}
	//arranges vertices by bottom right and top left
	public static void arrangeVertices(Point v1, Point v2){
		int temp;
		if (v1.x>v2.x){//swapping to get bottom left and top right
			temp=v1.x;
			v1.x=v2.x;
			v2.x=temp;
		}
		if (((v1.x<v2.x)&&(v2.y<v1.y))||((v1.x>v2.x)&&(v2.y>v1.y))){
			temp=v1.y;
			v1.y=v2.y;
			v2.y=temp;
		}

	}
	// computes area of intersection of the two rectangles
	public static int unionArea(Point v1, Point v2, Point v3, Point v4){
		int width=0, height=0;
		if ((v2.x<=v3.x)||(v4.x<=v1.x)||(v2.y<=v3.y)||(v4.y<=v1.y)){
			return 0;
		}
		else{
			//computing width based on x-axis perspective
			if ((v2.x>=v4.x)&&(v1.x<=v3.x)){
				width= v4.x-v3.x;
			}
			else if ((v4.x>=v2.x)&&(v3.x<=v1.x)){
				width=v2.x-v1.x;
			}
			else if (v2.x>=v4.x){
				width= v4.x-v1.x;
			}
			else{
				width= v2.x-v3.x;
			}
			//computing height based on y-axis perspective
			if ((v2.y>=v4.y)&&(v1.y<=v3.y)){
				height= v4.y-v3.y;
			}
			else if ((v4.y>=v2.y)&&(v3.y<=v1.y)){
				height =v2.y-v1.y;
			}
			else if (v2.y>=v4.y){
				height= v4.y-v1.y;
			}
			else{
				height =v2.y-v3.y;
			}
		}
		int union= width*height;
		return union;
	}

}


