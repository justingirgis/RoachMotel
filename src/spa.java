
public class spa extends amenitiesDecorator {
	
	private double amenityCost;

	public spa() {
		amenityCost = 20.0;
	}
	
	public String getDescription() {
		return "Spa";
	}
		
	public double getCost() {
		return amenityCost;
	}
	
	public String toString() {
		return "spa";
	}
}