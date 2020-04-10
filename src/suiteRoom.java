/**
 * This creates a concrete instance of the motelRooms class
 * Similar to the "Chocolate" class from Factory Project
 * @author Parth
 */
public class suiteRoom extends motelRooms {
	
	private double roomCost;
	private int roomNumber;
	
	public suiteRoom() {
		roomCost = 100.0;
	}
	
	@Override
	public String getDescription() {
		return "suite";
	}

	@Override
	public double getCost() {
		double amenityCosts = getAmenitiesCost();
		return roomCost + amenityCosts;
	}
	
	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	@Override
	public String cleanRoomsString(){
	  	return "All linens will be cleaned, all towels will be changed and a hamburger will be on the bed";
	}

	@Override
	public String toString() {
		String str = getDescription() + ", ";
		for (amenitiesDecorator ad : amenities) {
			str += ad.getDescription() + ", ";
		}
		return str + getCost();
	}
}