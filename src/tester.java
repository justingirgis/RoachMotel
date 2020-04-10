import java.util.ArrayList;

public class tester {

	public static void main(String[] args) {

		roachMotel rm = roachMotel.getInstance(); // creating a new roach motel
		rm.createRooms();
		System.out.println(rm.toString());
		
        roachColony rc1 = new roachColony("first colony",100,200); // creating a new roach colony
        
        ArrayList<amenitiesDecorator>amenities = new ArrayList<amenitiesDecorator>(); // creates an ArrayList of type amenitiesDecorator
        amenities.add(new foodBar()); // add foodbar
        amenities.add(new spa()); // add spa
        amenities.add(new refillBar()); // add refillable bar
        amenities.add(new shower()); // add shower
        
        motelRooms r1 = rm.checkIn(rc1, "suite", amenities); // create a new suite room and put rc1 in it
        System.out.println(rc1.toString());
        System.out.println(rm.toString());
        r1.setDoNotDisturb();
        
        roachColony rc2 = new roachColony("Second colony",1000,0.2); // create a 2nd roach colony
        ArrayList<amenitiesDecorator>amenities2 = new ArrayList<amenitiesDecorator>();
        amenities2.add(new foodBar());
        
        motelRooms r2 = rm.checkIn(rc2,"deluxe",amenities2); // put rc2 in a new motelroom
        System.out.println(rc2.toString());
        System.out.println(rm.toString());
        
        rc2.roachParty(); // roach party
        System.out.println(rc2.toString());
        
        roachColony rc3 = new roachColony("Third colony", 500, 0.5); //create a third colony
        ArrayList<amenitiesDecorator>amenities3 = new ArrayList<amenitiesDecorator>(); // another arraylist
        amenities3.add(new shower());
        
        motelRooms r3 = rm.checkIn(rc3, "regular", amenities3);
        Double cost = rm.checkOut(r2,3, new masterRoach(rc2.getColonyName(), "12345", "111", "08/20"));
        r3 = rm.checkIn(rc3, "regular", amenities3);
               
        System.out.println(rm.toString());
        System.out.println(rm.displayLog()); // print out the displayLog() function
        
        rm.cleanRooms(); // clean the rooms
        r1.takeOffDoNotDisturb(); // remove do not disturb
        rm.cleanRooms();
	}

}
