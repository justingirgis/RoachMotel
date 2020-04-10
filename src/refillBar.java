
public class refillBar extends amenitiesDecorator {

	private double amenityCost;
	
	public refillBar() {
		amenityCost = 5.0;
	}
	
	@Override
	public String getDescription() {
		return "Auto-Refill Food Bar";
	}

	@Override
	public double getCost() {
		return amenityCost;
	}
	
	@Override
	public String toString() {
		return "auto-refill food bar";
	}

}
