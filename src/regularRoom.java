/**
 * This creates a concrete instance of the motelRooms class
 * Similar to the "Chocolate" class from Factory Project
 * @author Parth
 */
public class regularRoom extends motelRooms {
	
	private double roomCost;
	private int roomNumber;

	public regularRoom() {
		roomCost = 50.0;
	}
	
	@Override
	public String getDescription() {
		return "regular";
	}

	@Override
	public double getCost() {
		double amenityCosts = getAmenitiesCost();
		return roomCost + amenityCosts;
	}
	
	@Override
	public String toString() {
		String str = getDescription() + ", ";
		for (amenitiesDecorator ad : amenities) {
			str += ad.getDescription() + ", ";
		}
		return str + getCost();
	}

	@Override
	public String cleanRoomsString(){
	  	return "All linens have been cleaned and all of the towels on floor will be replaced";
	}

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
}
