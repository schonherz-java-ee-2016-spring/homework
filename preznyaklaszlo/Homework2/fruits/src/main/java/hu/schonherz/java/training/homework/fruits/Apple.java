package hu.schonherz.java.training.homework.fruits;

public class Apple extends Fruit {

	protected int price, weight;

	protected Apple(int price, int weight, Eatable eatable) {
		super(eatable);
		this.price = price;
		this.weight = weight;
	}

	// We override the name() method, and we're calling the matching name()
	// method of the eatable interface
	@Override
	public String name() {
		return eatable.name();
	}

	@Override
	public boolean isItTasty() {
		return true;
	}

}
