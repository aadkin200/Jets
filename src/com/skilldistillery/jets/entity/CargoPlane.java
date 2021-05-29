package com.skilldistillery.jets.entity;

public class CargoPlane extends Jet implements CargoCarrier{

	public CargoPlane(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	

	@Override
	public void fly() {
		System.out.println(this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours while flying at top speed!");
		
	}


	@Override
	public void loadCargo() {
		System.out.println(this.getModel() + " is Loading Cargo!");
		
	}

	
}
