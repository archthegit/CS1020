// Testing the Scanner class.
// This program reads the name, age and vaccination status of
// some children and computes their average age and percentage
// of children who are vaccinated.
// Unlike the earlier version (practice exercise 4), this version
// keeps reading in data until there is no more name.

// Add import statement(s) below
import java.util.*;

public class Vaccination_V2 {

	public static void main(String[] args) {
		String name;
		int age, totalAge = 0;
		boolean vaccinated;
		double avg,percent;
		int num=0,numVaccinated = 0; 
		String extra;
		Scanner sc= new Scanner(System.in);
		
			System.out.print("Name: ");
		while(sc.hasNextLine()){
			name=sc.nextLine();
			System.out.println("Name is \""+name+"\"");

			System.out.print("Age: ");
			age= sc.nextInt();
			totalAge+=age;
			System.out.println("Age is "+age);

			System.out.print("Vaccinated for chickenpox? ");
			vaccinated= sc.nextBoolean();
			if (vaccinated){
				System.out.println("Vaccinated for chickenpox");
				numVaccinated++;
			}
			else{
				System.out.println("Not vaccinated for chickenpox");
			}
			num++;
			sc.nextLine();
			System.out.print("Name: ");
		}


		System.out.printf("Average age is %.2f\n", (totalAge*1.0/num));
		System.out.printf("Percentage of children vaccinated is %.2f%%\n",((numVaccinated*100.0)/num));

	}
}
