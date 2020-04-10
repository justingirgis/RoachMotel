
public class shower extends amenitiesDecorator {

	private double amenityCost;
	
	public shower() {
		amenityCost = 25.0;
	}
	
	@Override
	public String getDescription() {
		return "Spray-resistant shower";
	}

	@Override
	public double getCost() {
		return amenityCost;
	}
	
	@Override
	public String toString() {
		return "spray-Resistant Shower";
	}

}
