package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.skilldistillery.jets.entity.AirField;
import com.skilldistillery.jets.entity.CargoPlane;
import com.skilldistillery.jets.entity.FighterJet;
import com.skilldistillery.jets.entity.FlyingSaucer;
import com.skilldistillery.jets.entity.Jet;

public class JetsApplication {
	private Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch(app);

	}

	public void launch(JetsApplication app) {
		AirField airField = app.createAirfield(app);
		app.displayUserMenu(app, airField);
	}
	
//	Menu for navigating through the program
	public void displayUserMenu(JetsApplication app, AirField airField) {
		boolean running = true;
		while (running) {
			System.out.println("----------------------------------|");
			System.out.println("Please select a choice:           |");
			System.out.println("----------------------------------|");
			System.out.println("1.  List fleet                    |");
			System.out.println("2.  Fly all jets                  |");
			System.out.println("3.  View fastest jet              |");
			System.out.println("4.  View jet with longest range   |");
			System.out.println("5.  Load all Cargo Jets           |");
			System.out.println("6.  Dogfight!                     |");
			System.out.println("7.  Add a jet to Fleet            |");
			System.out.println("8.  Remove a jet from Fleet       |");
			System.out.println("9.  Sauce the Flyers              |");
			System.out.println("10. Exit                          |");
			System.out.println("----------------------------------|");

			int choice = app.choice();
			switch (choice) {
			case 1:
				listFleet(airField);
				break;
			case 2:
				flyAllJets(airField);
				break;
			case 3:
				viewFastestJet(airField);
				break;
			case 4:
				viewJetWithLongestRange(airField);
				break;
			case 5:
				loadAllCargoJets(airField);
				break;
			case 6:
				dogFight(airField);
				break;
			case 7:
				addAJetToFleet(airField);
				break;
			case 8:
				removeAJetFromFleet(airField);
				break;
			case 9:
				flyingSaucerMove(airField);
				break;
			case 10:
				System.out.println("Thanks for playing!");
				System.exit(0);
				break;
			}
		}
	}

//	Created method to grab input from the user then clear line// used throughout program
	public int choice() {
		int choice = input.nextInt();
		input.nextLine();
		return choice;
	}

//	Lists all the current jets in the AirField class
	public void listFleet(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			System.out.println("-----------------------------------");
			System.out.println(airField.getJets().get(i).toString());
			System.out.println("-----------------------------------");
			
		}
		
	}
	
//	calls fly method for all created jet objects
	public void flyAllJets(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			airField.getJets().get(i).fly();
		}
	}

//	compares the speed of all created jet objects then displays the toString() of said object with the highest speed
	public void viewFastestJet(AirField airField) {
		double speed = 0;
		int index = 0;
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i).getSpeed() > speed) {
				speed = airField.getJets().get(i).getSpeed();
				index = i;
			}
		}
		System.out.println(airField.getJets().get(index).toString());
	}

//	compares the range of all created jet objects then displays the toString() of said object with the highest range
	public void viewJetWithLongestRange(AirField airField) {
		int range = 0;
		int index = 0;
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i).getRange() > range) {
				range = airField.getJets().get(i).getRange();
				index = i;
			}
		}
		System.out.println(airField.getJets().get(index).toString());
	}

//	finds any CargoPlane objects currently in the AirField list and invokes their loadCargo() method
	public void loadAllCargoJets(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i) instanceof CargoPlane) {
				((CargoPlane)airField.getJets().get(i)).loadCargo();
			}
		}
	}

//	finds any FighterJet objects currently in the AirField list and invokes their fight() method
	public void dogFight(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i) instanceof FighterJet) {
				((FighterJet)airField.getJets().get(i)).fight();
			}
		}
	}
	
//	finds any FlyingSaucer objects currently in the AirField list and invokes their sauce() method
	public void flyingSaucerMove(AirField airField) {
		for(int i = 0; i<airField.getJets().size(); i++) {
			if(airField.getJets().get(i) instanceof FlyingSaucer) {
				((FlyingSaucer)airField.getJets().get(i)).sauce();
			}
		}
	}

//	Takes in data from the user then uses said data to create a Jet of the users choice
	public void addAJetToFleet(AirField airField) {
		System.out.println("What kind of Jet do you want to add?");
		System.out.println("1. Fighter Jet");
		System.out.println("2. Cargo Plane");
		System.out.println("3. Flying Saucer");
		int choice = choice();
		System.out.println("Please enter the model: ");
		String model = input.nextLine();
		System.out.println("Please enter the speed: ");
		double speed = input.nextDouble();
		System.out.println("Please enter the range: ");
		int range = input.nextInt();
		System.out.println("Please enter the price: ");
		long price = input.nextLong();
		
		if(choice == 1) {
			FighterJet jet = new FighterJet(model, speed, range, price);
			airField.addJet(jet);
		} else if (choice == 2) {
			CargoPlane jet = new CargoPlane(model, speed, range, price);
			airField.addJet(jet);
		} else if (choice == 3) {
			FlyingSaucer jet = new FlyingSaucer(model, speed, range, price);
			airField.addJet(jet);
		}
		
	}
	
//	Removes object based on user choice
	public void removeAJetFromFleet(AirField airField) {
		System.out.println("Select a jet to remove: ");
		for(int i = 0; i<airField.getJets().size(); i++) {
			System.out.println("-----------------------------------");
			System.out.println((i+1) + ". ");
			System.out.println(airField.getJets().get(i).toString());
			System.out.println("-----------------------------------");
		}
		int choice = choice();
		airField.getJets().remove(choice-1);
		System.out.println();
	}
	
//	OVERVIEW: Pulls Strings from jets.txt, stores Strings in an array, parses the Strings into correct primitive data type, then creates objects.
	public AirField createAirfield(JetsApplication app) {
		AirField airField = new AirField();
		try (BufferedReader bufIn = new BufferedReader(new FileReader("jets.txt"))) {
//			Creating a String to store lines of jets.txt
			String line;
			while ((line = bufIn.readLine()) != null) {
//				Creating Array to store separated strings within jets.txt
				String[] stringArr = new String[4];
//				Separates data within jets.txt and stores them individually within stringArr
				stringArr = line.split(",");
//				Parsing Strings into correct primitive data type to be used to create Jet objects
				String model = stringArr[1];
				double speed = Double.parseDouble(stringArr[2]);
				int range = Integer.parseInt(stringArr[3]);
				long price = Long.parseLong(stringArr[4]);
//				Sorting data found within jets.txt to determine which type of Jet each line is
				if (stringArr[0].equals("FighterJet")) {
					FighterJet jet = new FighterJet(model, speed, range, price);
					airField.addJet(jet);
				} else if (stringArr[0].equals("CargoPlane")) {
					CargoPlane jet = new CargoPlane(model, speed, range, price);
					airField.addJet(jet);
				} else {
					FlyingSaucer jet = new FlyingSaucer(model, speed, range, price);
					airField.addJet(jet);
				}
			}
		} catch (IOException e) {
			System.err.println(e);
		}
		return airField;
	}

}
