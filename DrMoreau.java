// CS1020 (AY2016/7 Semester 4) - Lab 4
//
// Name: Archana Pradeep
// Matric. No.: A0162694W
// Lab group: 1
// Collaborators:
// 
// Write the program description below.
// It is mandatory to write program description at the top of every program.
//
//
//
//
//

import java.util.*;
import java.awt.*;

/* class for First generation species has been written for you, but you may modify it as you see fit */
class First {
	protected String class_attr; // string containing the class attributes
	protected String species_attr; // string containing the species attributes
	protected String sound; // string containing the vocalization of the species
	protected int species_num; // the species number 
	protected int speciesClass;
	protected boolean ans=true;
	protected int flag;
	// constructor
	public First() { class_attr = new String("Swim");}

	// mutators
	public void setSpeciesNum(int i) { species_num = i; }    
	public void setSpeciesAttr(String a) { species_attr = a; }    
	public void setSound(String s) {sound = createSound(s); }
	public void setSpeciesClass(int b){ speciesClass=b;}
	public void setFlag(int r){flag=r;}

	//  you may need to make use of this in the other classes
	public String createSound(String s) {return s;}

	// accessors
	public int getSpeciesNum() { return species_num; }
	public String getClassAttr() { return class_attr; }   
	public String getSpeciesAttr() { return species_attr; }
	public String getSound() { return sound; }
	public int getSpeciesClass(){return speciesClass;}
	public int getFlag(){return flag;}
}

class Second extends First{
	protected String second_classAttr;
	public Second(){
		second_classAttr= new String("Slither");
	}
	public String getClassAttr(){
		String str= super.getClassAttr()+","+second_classAttr;
		return str;
	}

}

class Third extends Second {        
	protected String third_classAttr;
	public Third(){
		third_classAttr=new String("Walk");
	}
	public String getClassAttr(){
		String str1=super.getClassAttr()+","+third_classAttr;
		return str1;
	}

}

class Fourth extends Third {    
	protected String fourth_classAttr;

	public Fourth(){
		fourth_classAttr= new String("Climb");
	}
	public String getClassAttr(){
		String str2=super.getClassAttr()+","+fourth_classAttr;
		return str2;
	}
}

class Fifth extends Fourth {
	protected String fifth_classAttr;
	public Fifth(){
		fifth_classAttr=new String("Fly");
	}
	public String getClassAttr(){
		String str3=super.getClassAttr()+","+fifth_classAttr;
		return str3;
	}

}

/* How does chimera differ from the rest? */
class Chimera extends First{
	private int p1;
	private int p2;
	public Chimera(int a, int b){
		p1=a;
		p2=b;
	}

}

public class DrMoreau {

	public static void main(String[] args)  {
		Scanner sc = new Scanner(System.in);
		int numSpecies= sc.nextInt();
		int crossBreed= sc.nextInt();
		First[] init= new First[numSpecies+crossBreed];
		int parent1;
		int parent2;
		int speciesNum=0;
		int speciesClass=0;

		for (int i=0;i<numSpecies;i++){
			speciesNum=sc.nextInt();
			speciesClass=sc.nextInt();
			switch(speciesClass){
				case 1: 
					init[i]= new First();
					break;
				case 2:
					init[i]= new Second();
					break;
				case 3:
					init[i]= new Third();
					break;
				case 4:
					init[i]= new Fourth();
					break;
				case 5:
					init[i]= new Fifth();
					break;
			}
			init[i].setSpeciesNum(speciesNum);
			init[i].setSpeciesClass(speciesClass);
		init[i].setSpeciesAttr(sc.next());
		init[i].setSound(sc.next());
		}

		for (int i=numSpecies;i<(crossBreed+numSpecies);i++){
			speciesNum=sc.nextInt();
			parent1= sc.nextInt();
			parent2=sc.nextInt();
			int max=0;
			int min=0;
			int max_class=Math.max(init[parent1-1].getSpeciesClass(),init[parent2-1].getSpeciesClass());
			int min_class=Math.min(init[parent1-1].getSpeciesClass(),init[parent2-1].getSpeciesClass());
			if (init[parent1-1].getSpeciesClass()==max_class){
				max= parent1-1;
				min=parent2-1;
			}
			if (max_class==min_class){
				max= Math.max(parent1,parent2)-1;
				min= Math.min(parent1,parent2)-1;
			}
			else{
				max=parent2-1;
				min=parent1-1;
			}

			switch(max_class){
				case 1: 
					init[i]= new First();
					break;
				case 2:
					init[i]= new Second();
					break;
				case 3:
					init[i]= new Third();
					break;
				case 4:
					init[i]= new Fourth();
					break;
				case 5:
					init[i]= new Fifth();
					break;
			}
			init[i].setSpeciesNum(speciesNum);
			String attr= sc.next()+","+init[min].getSpeciesAttr()+","+init[max].getSpeciesAttr();
			init[i].setSpeciesAttr(attr);
			init[i].setSpeciesClass(max_class);
			init[i].setSound(sc.next());
			if (init[parent1-1].getSpeciesClass()!=init[parent2-1].getSpeciesClass()){
				init[i].setFlag(-1);
			}
			if (parent1==parent2){
				init[i].setFlag(1);
				
			}
			if ((init[parent1-1].getFlag()==-1)||(init[parent2-1].getFlag()==-1)){
				init[i].setFlag(1);
			}
		
			}
		for (int i=0; i < (numSpecies+crossBreed); i++) { 
			int count=0;
			
			if ((init[i].getFlag()==0)||(init[i].getFlag()==-1)){
				System.out.print((i+1)+": class = "+init[i].getClassAttr()+"; species = "+init[i].getSpeciesAttr()+"; sound = \"");
				speciesClass= init[i].getSpeciesClass();
				while(speciesClass>0){
					
					if (count==0){
						System.out.print(init[i].getSound());
					}
					else{
						System.out.print(" "+init[i].getSound());
					}
					speciesClass--;
					count++;
				}
				System.out.println("\"");
			}
		}
	}
}

