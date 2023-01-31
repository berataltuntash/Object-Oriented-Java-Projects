package FurnitureFactorySimulator;

public abstract class Furniture {
	private float quailty;
	
	public abstract int calculateQuality();
	
	public abstract int getPrice();

	public abstract void nameAssessor(String name);
	
	public float getQuality() {
		return this.quailty;
	}
	
}
