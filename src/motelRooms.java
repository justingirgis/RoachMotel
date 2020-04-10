import java.util.ArrayList;

/**
 * This acts as the product the factory constructs
 * Similar to the "IceCream" class from Factory Project
 * @author Parth
 *
 */
public abstract class motelRooms {
	
	protected ArrayList<amenitiesDecorator> amenities;
	private int roomNumber; 
	private boolean doNotDisturb;

    /**
     * Default constructor
     */
	public motelRooms() {
		amenities = new ArrayList<>();
		doNotDisturb = false;
	}

    /**
     * abstract method that gets the description
     * @return String
     */
	public abstract String getDescription();
	
	/**
	 * Will be overridden by each amenity class to get the cost
	 * of each individual one
	 * @return cost
	 */
	public abstract double getCost();

    /**
     * Adds an amenity to the ArrayList
     * @param amenity
     */
	public void addAmenity(amenitiesDecorator amenity) {
		amenities.add(amenity);
	}
	
	/**
	 * Gets the total cost of all the amenitites associated with the room
	 * @return
	 */
	public double getAmenitiesCost() {
		double totalAmenitiesCost = 0.0;
		for (amenitiesDecorator amenity : amenities) {
			totalAmenitiesCost += amenity.getCost();
		}
		return totalAmenitiesCost;
	}

    /**
     * returns the amenities ArrayList
     * @return ArrayList
     */
	public ArrayList<amenitiesDecorator> getAmenities() {
		return amenities;
	}

    /**
     * Overrides the toString method
     * @return String
     */
	public String toString() {
		String str = "This is a " + getDescription() + " with the following amenitites: ";
		for (amenitiesDecorator ad : amenities) {
			str += ad.getDescription() + ". ";
		}
		return str;
	}

    /**
     * Returns string of clean rooms
     * @return ""
     */
	public String cleanRoomsString() {
		return "";
	}

    /**
     * boolean function for do not disturb
     * @return doNotDisturb
     */
	public boolean getDoNotDisturb() {
		return doNotDisturb;
	}

    /**
     * void setter function for do not disturb
     */
	public void setDoNotDisturb() {
		doNotDisturb = true;
	}

    /**
     * void function to set doNotDisturb to false
     */
	public void takeOffDoNotDisturb() {
		doNotDisturb = false;
	}

    /**
     * Accept method part of the Visitor design implementation
     * @param visitor
     * @return
     */
	public double accept(motelRoomVisitor visitor) {
		return visitor.visit(this);
	}

    /**
     * returns room number
     * @return roomNumber
     */
	public int getRoomNumber() {
		return roomNumber;
	}

    /**
     * setter method for room number
     * @param roomNumber
     */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
