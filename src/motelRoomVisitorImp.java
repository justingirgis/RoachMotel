public class motelRoomVisitorImp implements motelRoomVisitor {

	public double visit(motelRooms room) {
		return room.getCost();
	}
}
