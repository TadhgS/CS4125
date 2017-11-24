package customer;
import payment.Observer;

public interface Subject 
{
	public void register(Observer o);
	public void unregister(Observer o);
	public void notifyObs();

}
