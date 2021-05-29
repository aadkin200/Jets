package com.skilldistillery.jets.entity;

public class FlyingSaucer extends Jet implements Hover{

	public FlyingSaucer(String model, double speed, int range, long price) {
		super(model, speed, range, price);
	}
	
	public void sauce() {
		System.out.println(this.getModel() + " Finished saucing the flyers!");
	}

	@Override
	public void fly() {
		System.out.println(this.getModel() + " does a hover BLOOP BLOOP");
	}

}
