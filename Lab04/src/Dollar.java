
public class Dollar extends Currency{
	
	private final String name = "Dollar";
	
	/**
	 * Create a new Dollar currency object with the value 0
	 */
	public Dollar() {
		super();
	}
	
	/**
	 * Create a new Dollar currency object with the value param
	 * @param value
	 */
	public Dollar(double value) {
		super(value);
	}

	@Override
	public String getCurrencyName() {
		return name;
	}

	@Override
	public boolean isSameCurrency(Currency currency) {
		return currency instanceof Dollar;
	}

}
