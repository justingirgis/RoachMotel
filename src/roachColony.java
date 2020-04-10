// Observer class

public class roachColony implements Observer {

	// the name of the colony
	private String name;
	// the population of the colony
	private double population;
	// the growth rate of the colony
	private double growthRate;
	// the room the colony is checked in to
	private motelRooms colonyRoom;
	
	/**
	 * Default constructor of the roachColony class
	 */
	public roachColony() {}
	/**
	 * Overload constructor of the roachColony class
	 * @param name - the name of the colony
	 * @param population - the population of the colony
	 * @param growthRate - the growth rate of the colony
	 */
	public roachColony(String name, double population, double growthRate) {
		setColonyName(name);
		setPopulation(population);
		setGrowthRate(growthRate);
		
	}
	
	public String getColonyName() {
		return name;
	}
	
	public void setColonyName(String name) {
		this.name = name;
	}
	
	public double getPopulation() {
		return population;
	}
	
	public void setPopulation(double population) {
		this.population = population;
	}
	
	public double getGrowthRate() {
		return growthRate;
	}
	
	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}
	
	public motelRooms getRoom() {
		return colonyRoom;
	}
	
	public void setRoom(motelRooms room) {
		this.colonyRoom = room;
	}
	
	public void roachParty() {
		System.out.println("Roach Party! " + name + " is throwing a party");
		population += (population * growthRate);
		System.out.println("The roaches have partied! New population: " + population);
		
		// Call this method to see if the room has the spray-resistant shower
		roachMotel.hoseTheRoaches(this);
	}
	
	public void update(Object obs) {
		System.out.println(this.name + " has been notified that a room is available at the Roach Motel.");
	}
	
	public String toString() {
		return this.getColonyName() + ", " + this.getPopulation();
	}
}
