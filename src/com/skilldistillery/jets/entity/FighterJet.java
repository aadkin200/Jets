package com.skilldistillery.jets.entity;

public class FighterJet extends Jet implements CombatReady{

	public FighterJet(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	

	@Override
	public void fly() {
		System.out.println(this.getModel() + " can fly for " + (this.getRange() / this.getSpeed()) + " hours while flying at top speed!");
	}


	@Override
	public void fight() {
		System.out.println(this.getModel() + " FIRES!!! PEW-PEW-PEW");
	}
}
