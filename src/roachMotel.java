import java.util.ArrayList;

/**
 * Singleton Class
 * And Subject Class
 * Check in, check out methods
 * 	Ameneities added to rooms in check in method
 * Notify roach colony if no rooms available
 */
public class roachMotel implements Subject {

   private volatile static roachMotel instance;
   // Roach motel's current room capacity
   private int capacity;
   // ArrayList of colonies on the wait list
   private ArrayList<Observer> waitList;
   // ArrayList of residents in the motel represented as a string
   private ArrayList<String> motelResidents;
   // ArrayList of rooms available in the motel
   private ArrayList<Integer> rooms;
   // ArrayList of the transaction log
   private ArrayList<String> transactionLog;
   // ArrayList of rooms that have been checked into
   private ArrayList<motelRooms> checkedInRooms;
   
   /**
    * Default constructor
    * No instance variables needed to be initialized when the motel is constructed
    */
   private roachMotel() { 
	   waitList = new ArrayList<Observer>();
	   motelResidents = new ArrayList<String>();
	   rooms = new ArrayList<Integer>();
	   transactionLog = new ArrayList<String>();
	   checkedInRooms = new ArrayList<motelRooms>();
   }
   
   // Declare the constructor as private which prevents object creation via new

    /**
     * the getInstance() method
     * @param
     * @return instance
     */
   public static roachMotel getInstance()
   {
	   if (instance == null) {
		   // To make thread safe
		   synchronized (roachMotel.class) {
			   // Check again as multiple threads
			   // Can reach above step
			   if (instance == null)
				   instance = new roachMotel();
		   }
	   }
	   return instance;
   }
   
   // Creates the rooms

    /**
     * this will create the rooms
     * @param void
     * @return none
     */
   public void createRooms() {
	   for (int i = 100; i < 102; i++) {
		   rooms.add(i);
	   }
   }
   
   // Display noVacancy

    /**
     * method to notify that there are no rooms
     * @param colony
     */
   public void noVacancy(roachColony colony) {
	   System.out.println("There are no rooms available, " + colony.getColonyName() + " will be added to the wait list.");
	   addObserver(colony);
   }

    /**
     * void function to show vacancy
     */
   public void vacancy() {
	   System.out.println("There are rooms available!");
   }

    /**
     * displays amenities included with room
     * @param amenities
     * @param room
     */
   // Display Amenities being added to a room
   public void displayRoomAmenities(ArrayList <amenitiesDecorator> amenities, motelRooms room) {
	   System.out.println("\tAdding these amenities to this room: " + amenities.toString() + "\n" + room.toString());
   }

    /**
     * method to check in someone
     * @param colony
     * @param roomType
     * @param amenities
     * @return
     */
   // Checks a colony into a room
   public motelRooms checkIn(roachColony colony, String roomType, ArrayList <amenitiesDecorator> amenities) {
	   
	   capacity = rooms.size();
	   
	   // If there are no available rooms, the colony will be added to the waitlist
	   if (capacity == 0) {
		   noVacancy(colony);
		   return null;
	   }
	   
	   // Displays there are rooms available
	   vacancy();
	   
	   // Uses the factory class to create a room based on the type provided
	   motelRooms myRoom = roomFactory.createRoom(roomType);
	   
	   // Adds the amenities wanted to the room
	   for (amenitiesDecorator ad : amenities) {
		   myRoom.addAmenity(ad);
	   }
	   // Display the amenities being added to the room
	   displayRoomAmenities(amenities, myRoom);
	   
	   // Adds the colony and their respective room to the motelResidents ArrayList
	   motelResidents.add(myRoom.toString() + " = " + colony.toString() + "  ");
	   // Add the room that was checked into to the checkedInRooms ArrayList
	   checkedInRooms.add(myRoom);
	   // Sets the room to the first open room number
	   myRoom.setRoomNumber(rooms.get(0));
	   // Removes the first room in the list of room's available
	   rooms.remove(0);
	   // Sets the room the colony is staying in
	   colony.setRoom(myRoom);
	   
	   // If the colony checking in was on the wait list, remove them from the waitlist
	   for (int i = 0; i < waitList.size(); i++){
			if (waitList.get(i).equals(colony)) {
			   removeObserver(colony);
		   }
	   }
	   return myRoom;
   }

    /**
     * method to check someone out
     * @param room
     * @param numDays
     * @param roachPayment
     * @return cost of checkout
     */
   public double checkOut(motelRooms room, int numDays, paymentMethod roachPayment) {
	   
	   motelRoomVisitor cashier = new motelRoomVisitorImp();
	   double checkOutCost = room.accept(cashier) * numDays;
	   String colonyName = "";
	   
	   // Once the colony checks out, add the room number back to the list of available rooms
	   rooms.add(rooms.size(), room.getRoomNumber());
	   // Once the colony checks out, remove that colony from the list of motel residents
	   for (int i = 0; i< motelResidents.size(); i++){
			if (motelResidents.get(i).contains(room.toString())) {
				motelResidents.remove(i);
			}
	   }
	   checkedInRooms.remove(room);
	   
	   roachPayment.pay(checkOutCost);
	   roachPayment.setPaymentType(roachPayment);
	   colonyName = roachPayment.getColonyName();
	   
	   // Notifies a colony if there is an available room
	   capacity = rooms.size();
	   if (capacity == 1) {
		   notifyObservers();
	   }
	   	
	   // Write the transaction to the transaction log
	   String transaction = createTransaction(checkOutCost, colonyName, roachPayment);
	   writeTransactionLog(transaction);
	   return checkOutCost;
   	}

    /**
     * creates a receipt
     * @param checkOutCost
     * @param name
     * @param method
     * @return String receipt
     */
   // Create a transaction for the log
   public String createTransaction(double checkOutCost, String name, paymentMethod method) {
	   return name + " paid: " + checkOutCost + " using: " + method.getPaymentType();
   }

    /**
     * Adds to the transaction log
     * @param transaction
     */
   // Add to the transaction log
   public void writeTransactionLog(String transaction) {
	   transactionLog.add(transaction);
   }

    /**
     * Add a colony to the wait list
     * @param o
     */
   @Override
   public void addObserver(Observer o) {
	   waitList.add(o);
   }

    /**
     * Remove a colony from the wait list
     * @param o
     */
   @Override
   public void removeObserver(Observer o) {
	   waitList.remove(o);
   }

    /**
     * notifies observer of any changes
     */
   @Override
   public void notifyObservers() {
	   for (int i = 0; i < waitList.size(); i++) {
		   Observer obs = waitList.get(i);
		   obs.update(obs);
	   }
   }

    /**
     * void function to clean rooms
     */
   public void cleanRooms() {
	   String str = "Time to clean the rooms today! Rooms to be cleaned: ";
	   for (int i = 0; i < checkedInRooms.size(); i++) {
		   str += checkedInRooms.get(i).getRoomNumber() + " ";
	   }
	   System.out.println(str);
	   
	   // Check to see if the rooms have the do not disturb on sign
	   for (int i = 0; i < checkedInRooms.size(); i++) {
		   if (checkedInRooms.get(i).getDoNotDisturb() == false) {
			   String string = "Room " + checkedInRooms.get(i).getRoomNumber() + ": " + checkedInRooms.get(i).cleanRoomsString();
			   System.out.println(string);
		   }
		   else {
			   System.out.println("Room " + checkedInRooms.get(i).getRoomNumber() + " does not want to be disturbed and will not be cleaned.");
		   }
	   }
   }

    /**
     * Displays transaction log
     * @return String of transactions
     */
   public String displayLog() {
	   String str = "Transaction Log\n";
	   for (int i = 0; i < transactionLog.size(); i++) {
		   str += transactionLog.get(i) + "\n";
	   }
	   return str;
   }

    /**
     * toString function
     * @return
     */
   public String toString() {
	   return "ROACH MOTEL: " + motelResidents + " Available rooms: " + rooms;
   }

    /**
     * Method for checking if the room has a shower and reducing the colony's population
     * @param roachColony
     */
   public static void hoseTheRoaches(roachColony roachColony) {

       //Get amenities of the room the colony is staying in
       ArrayList<amenitiesDecorator> amenities = roachColony.getRoom().getAmenities();

       //Loop through the amenities
       for(amenitiesDecorator ad : amenities) {
           //Checks to see if the amenities contains an instance of the shower
           if(ad instanceof shower) {
               System.out.println("Room has Spray Resistant Shower");

               //reduce population by 25%
               roachColony.setPopulation(roachColony.getPopulation() * 0.75);
               return;
           }
       }

       System.out.println("No Spray Resistant Shower");
       //reduce colony by 50%
       roachColony.setPopulation(roachColony.getPopulation() * 0.5);
   }
}
