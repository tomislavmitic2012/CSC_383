package antiques;

public interface InsurableItem extends Sellable, Transportable {
	/**
	 * Returns insured value in cents
	 */
	public int insuredValue();
}