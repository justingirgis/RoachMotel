public class masterRoach implements paymentMethod {

	protected String name;
	protected String cardNumber;
	protected String cvv;
	protected String dateOfExpir;
	protected String paymentType;
	
	public masterRoach(String name, String cardNumber, String cvv, String dateOfExpir) {
		this.name = name;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.dateOfExpir = dateOfExpir;
	}
	
	public String getColonyName() {
		return name;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(paymentMethod method) {
		paymentType = "masterRoach";
	}
	
	public void pay(double x) {
		System.out.println(name + " paid: $" + x + " with a credit/debit card.");
	}
}
