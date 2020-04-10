public class roachPal implements paymentMethod{
	
	protected String name;
	protected String email;
	protected String paymentType;
	
	public roachPal(String name, String email) {
		this.email = email;
		this.name = name;
	}
	
	public String getColonyName() {
		return name;
	}
	
	public String getPaymentType() {
		return paymentType;
	}
	
	public void setPaymentType(paymentMethod method) {
		paymentType = "roachPal";
	}
	
	public void pay(double x) {
		System.out.println("Email: " + email + " Payment: $" + x + " completed.");
	}
}
