/**
 *  Description: Monster class controller
 */

/**
 * @author Horacio Valdes and Hanna Morreale
 *
 *
 */
import java.io.*;
import java.util.Scanner;
public class MonsterBattle {

	public static void main(String[] args) {
		MainMenu();
	}
	// The main menu for the user to select what battle they want to chose or to make their own monster
	// Hanna did this part
public static void MainMenu(){
	Scanner kb = new Scanner(System.in);
	System.out.println("1: Default Battle \n2: Custom Battle \n3: Monster Builder \n4: Quit");
	int input = kb.nextInt();

	switch(input) {
	case 1:
		Monster Giant = new Monster("Giant", 200, 25, 1);
		Monster Ogre = new Monster("Ogre", 100, 50, 3);
		Battle(Giant, Ogre);

		break;
	case 2: createMonsterA();
		break;
	case 3: CustomMonster();
		break;
	case 4:
		break;
	default: System.out.println("Please enter a number between 1 and 4.");


	}
}

// Creates the first monster from the custom battle choice by using a file
// Horacio did this part
	public static void createMonsterA() {
		Scanner kb = new Scanner(System.in);

		//First Monster
		System.out.println("Please enter a file name for the first monster");
//		kb.nextLine();

		String fileName = kb.nextLine();
		File file = new File(fileName);
		Monster monsterA = new Monster();
		try
		{
			kb = new Scanner(file);

		}
		catch (FileNotFoundException e)
		{
			createMonsterA();
		}
		while(kb.hasNextLine()) {

			monsterA.setName(kb.nextLine());
			monsterA.setHealth(kb.nextDouble());
			monsterA.setStrength(kb.nextDouble());
			monsterA.setSpeed(kb.nextInt());

		}
		kb.close();


		createMonsterB(monsterA);

	}

	// Creates second monster for custom battle by using a file
	// Horacio did this part
	public static void createMonsterB(Monster monsterA) {
		Scanner kb = new Scanner(System.in);

		//First Monster
		System.out.println("Please enter a file name for the second monster");
//		kb.nextLine();

		String fileName = kb.nextLine();
		File file = new File(fileName);

		Monster monsterB = new Monster();
		try
		{
			kb = new Scanner(file);

		}
		catch (FileNotFoundException e)
		{
			createMonsterB(monsterA);
		}
		while(kb.hasNextLine()) {

			monsterB.setName(kb.nextLine());
			monsterB.setHealth(kb.nextDouble());
			monsterB.setStrength(kb.nextDouble());
			monsterB.setSpeed(kb.nextInt());


		}

		kb.close();



		Battle(monsterA, monsterB);
	}
// Creates a custom monster and allows user to input the name, health, etc.
// Hanna did this part
public static void CustomMonster(){
	Scanner kb = new Scanner(System.in);
	System.out.println("Enter the monsters name: ");
	Monster customMonster = new Monster();
	customMonster.setName(kb.nextLine());
	System.out.println("Enter the monsters health: ");
	customMonster.setHealth(kb.nextDouble());
	System.out.println("Enter the monsters strength: ");
	customMonster.setStrength(kb.nextDouble());
	System.out.println("Enter the monsters speed: ");
	customMonster.setSpeed(kb.nextInt());
	try{
		FileWriter file = new FileWriter(customMonster.getName() + ".txt");
		PrintWriter out = new PrintWriter(file);
		out.println(customMonster.getName());
		out.println(customMonster.getHealth());
		out.println(customMonster.getStrength());
		out.print(customMonster.getSpeed());
		file.close();
		out.close();
	}catch(IOException e){
		e.printStackTrace();
	}
MainMenu();
}
// Battle sequence (includes default battle too)
// Horacio did this part
	public static void Battle(Monster monsterA, Monster monsterB) {
		//Run battle


		//Who attacks first

		//Monster A goes first
		while(monsterA.isAlive() && monsterB.isAlive()) {
			monsterA.getAttackPriority();

			monsterB.getAttackPriority();
			if(monsterA.getAttackPriority() > monsterB.getAttackPriority())
			{
				monsterB.takeDamage(monsterA.attack());
				System.out.printf("%s attacked %s for %.2f damage \n", monsterA.getName(), monsterB.getName(), monsterA.attack());

				if(monsterA.isAlive() && monsterB.isAlive()){
					System.out.println(monsterA.toString());
					System.out.println(monsterB.toString());
					System.out.println("\n");
				}
				else if(monsterA.isAlive() && monsterB.isAlive() == false) {
					System.out.printf("%s: %f\n", monsterA.getName() , monsterA.getHealth());
					System.out.printf("%s: %f\n",monsterB.getName() , monsterB.getHealth());
					System.out.printf("%s is declared the winner and the battle is over Monster\n", monsterA.getName());
				}


			}
			//Monster B goes first
			else if(monsterA.getAttackPriority() < monsterB.getAttackPriority())
			{
				monsterA.takeDamage(monsterB.attack());
				System.out.printf("%s attacked %s for %.2f damage\n", monsterB.getName(), monsterA.getName(), monsterB.attack());
				if(monsterB.isAlive() && monsterA.isAlive()){
					System.out.println(monsterA.toString());
					System.out.println(monsterB.toString());
					System.out.println("\n");
				}
				else if(monsterB.isAlive() && monsterA.isAlive() == false) {
					System.out.printf("%s: %f\n", monsterA.getName() , monsterA.getHealth());
					System.out.printf("%s: %f\n",monsterB.getName() , monsterB.getHealth());
					System.out.printf("%s is declared the winner and the battle is over Monster\n", monsterB.getName());
				}


			}
			//Attack priority is the same on both monsters
			else if(monsterA.getAttackPriority() == monsterB.getAttackPriority())
			{
				double randDouble = Math.random();
				int rand = 0;
				if(randDouble >= 0.5f) {
					rand = 1;
				}
				else {
					rand = 0;
				}


				switch(rand) {
				case 0: //Monster A attacks first
				monsterB.takeDamage(monsterA.attack());
				System.out.printf("%s attacked %s for %.2f damage \n", monsterA.getName(), monsterB.getName(), monsterA.attack());

				if(monsterA.isAlive() && monsterB.isAlive()){
					System.out.println(monsterA.toString());
					System.out.println(monsterB.toString());
					System.out.println("\n");
				}
				else if(monsterA.isAlive() && monsterB.isAlive() == false) {
					System.out.println(monsterA.getName() + monsterA.getHealth());
					System.out.println(monsterB.getName() + monsterB.getHealth());
					System.out.printf("%s is declared the winner and the battle is over Monster\n", monsterA.getName());
				}
					break;
				case 1: // monster B attacks first
				monsterA.takeDamage(monsterB.attack());
				System.out.printf("%s attacked %s for %.2f damage\n", monsterB.getName(), monsterA.getName(), monsterB.attack());
				if(monsterB.isAlive() && monsterA.isAlive()){
					System.out.println(monsterA.toString());
					System.out.println(monsterB.toString());
					System.out.println("\n");
				}
				else if(monsterB.isAlive() && monsterA.isAlive() == false) {
					System.out.printf("%s: %f\n", monsterA.getName() , monsterA.getHealth());
					System.out.printf("%s: %f\n",monsterB.getName() , monsterB.getHealth());
					System.out.printf("%s is declared the winner and the battle is over Monster\n", monsterB.getName());
				}

				}

			}



		}
	}
}
