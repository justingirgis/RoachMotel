// Strategy
public interface paymentMethod {

	public abstract void pay(double x);
	public abstract String getPaymentType();
	public abstract void setPaymentType(paymentMethod method);
	public abstract String getColonyName();
}

