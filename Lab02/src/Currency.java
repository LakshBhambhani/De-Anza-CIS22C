/**
 * Represents base class for all types of currency
 * @author lakshbhambhani
 *
 */
public abstract class Currency {
	
	private int wholeValue, fractionalValue;
	
	public Currency() {
		setValue(0);
	}
	
	public Currency(double value) {
		setValue(value);
	}
	
	/**
	 * @param value value of the currency
	 * @post value of the currency will be set to the new param value
	 */
	public void setValue(double value) {
		this.wholeValue = (int) Math.floor(value);
		this.fractionalValue = (int) ((value-wholeValue)*100);
	}
	
	/**
	 * @return value of the currency
	 */
	public double getValue() {
		return (double)fractionalValue/100 + wholeValue;
	}
	
	protected void finalize()  {  
		System.out.println("Object is destroyed by the Garbage Collector");  
	}  
	
	/**
	 * @pre Type of the currency should be same or exception will be thrown
	 * @param currency currency that needs to be added to this
	 * @throws Exception
	 */
	public void add(Currency currency) throws Exception {
		if(isSameCurrency(currency)) {
			setValue(getValue() + currency.getValue());
		}
		else {
			throw new Exception("Invalid Addition");
		}
	}
	
	/**
	 * @pre Type of the currency should be same or exception will be thrown
	 * @param currency currency that needs to be subtracted from this
	 * @throws Exception
	 */
	public void subtract(Currency currency) throws Exception {
		if(isSameCurrency(currency)) {
			setValue(getValue() - currency.getValue());
		}
		else {
			throw new Exception("Invalid Subtraction");
		}
	}
	
	/**
	 * @pre Type of the currency should be same or exception will be thrown
	 * @param currency currency that needs to be compared to this
	 * @throws Exception
	 */
	public boolean isEqual(Currency currency) throws Exception {
		if(isSameCurrency(currency)){
			if(currency.getValue() == getValue()) {
				return true;
			}
			return false;
		}
		else {
			throw new Exception("Invalid Comparison");
		}
	}
	
	/**
	 * @pre Type of the currency should be same or exception will be thrown
	 * @param currency currency that needs to be compared to this
	 * @throws Exception
	 */
	public boolean isGreater(Currency currency) throws Exception{
		if(isSameCurrency(currency)){
			if(currency.getValue() < getValue()) {
				return true;
			}
			return false;
		}
		else {
			throw new Exception("Invalid Comparison");
		}
	}
	
	/**
	 * @pre classes that extend this base class can use this print function
	 */
	public void print() {
		System.out.print(getValue() + " " + getCurrencyName() + " ");
	}
	
	public abstract String getCurrencyName();
	
	public abstract boolean isSameCurrency(Currency currency);

}
