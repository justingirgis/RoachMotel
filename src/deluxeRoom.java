/**
 * This creates a concrete instance of the motelRooms class
 * Similar to the "Chocolate" class from Factory Project
 * @author Parth
 */
public class deluxeRoom extends motelRooms {
	
	private double roomCost;
	private int roomNumber;

	/**
	 * Default constructor, sets room cost = 75
	 */
	public deluxeRoom() {
		roomCost = 75.0;
	}

	/**
	 * Description of room
	 * @return String "deluxe"
	 */
	@Override
	public String getDescription() {
		return "deluxe";
	}

	/**
	 * returns room cost + amenities
	 * @return cost
	 */
	@Override
	public double getCost() {
		double amenityCosts = getAmenitiesCost();
		return roomCost + amenityCosts;
	}

	/**
	 * Returns room number
	 * @return roomNumber
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * Setter method for room number
	 * @param roomNumber
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	/**
	 * function to indicate that rooms have been cleaned
	 * @return String
	 */
	@Override
	public String cleanRoomsString(){
		return "All linens have been cleaned and all of the towels will be changed";
	}

	/**
	 * Override toString method
	 * @return String
	 */
	@Override
	public String toString() {
		String str = getDescription() + ", ";
		for (amenitiesDecorator ad : amenities) {
			str += ad.getDescription() + ", ";
		}
		return str + getCost();
	}	
}
