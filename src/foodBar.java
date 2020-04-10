
public class foodBar extends amenitiesDecorator {
		
	private double amenityCost;
	// Default constructor, room won't need a refill when it
	// is initially constructed
	public foodBar() {
		amenityCost = 5.0;
	}

	public String getDescription() {
		return "Food Bar";
	}
	
	public double getCost() {
		return amenityCost;
	}
	
	public String toString() {
		return "food bar";
	}
}
