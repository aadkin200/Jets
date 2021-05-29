package com.skilldistillery.jets.entity;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	

	@Override
	public void fly() {
		System.out.println("Flying as a Cargo Plane!!!");
		
	}


	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + " is Loading Cargo!");
		
	}

	
}
