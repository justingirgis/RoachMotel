public class roomFactory {

	public static motelRooms createRoom(String roomType) {
		motelRooms myRoom = null;
		if (roomType.contentEquals("regular"))
			myRoom = new regularRoom();
		if (roomType.contentEquals("deluxe"))
			myRoom = new deluxeRoom();
		if (roomType.contentEquals("suite"))
			myRoom = new suiteRoom();
		return myRoom;
	}
}
