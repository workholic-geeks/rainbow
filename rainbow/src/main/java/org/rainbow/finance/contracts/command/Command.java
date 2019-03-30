package org.rainbow.finance.contracts.command;

/**
 * This interface represents a command .
 * 
 * @author Anish Singh
 *
 */
public interface Command {

	/**
	 * Return the from mail address.
	 * 
	 * @return
	 */
	public String getFromMailAddress();

	/**
	 * Set the from mail address.
	 * 
	 * @param fromMailAddress
	 */
	public void setFromMailAddress(String fromMailAddress);

	/**
	 * Returns the to address.
	 * 
	 * @return
	 */
	public String getToMailAddress();

	/**
	 * set the to address.
	 * 
	 * @param toMailAddress
	 */
	public void setToMailAddress(String toMailAddress);

	/**
	 * Returns the phonenumber.
	 * 
	 * @return
	 */
	public Long getPhoneNumber();

	/**
	 * set the phone number.
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(Long phoneNumber);

	/**
	 * Return the loan amount.
	 * 
	 * @return
	 */
	public Long getLoanAmount();

	/**
	 * Set the loan amount.
	 * 
	 * @param loanAmount
	 */
	public void setLoanAmount(Long loanAmount);

	/**
	 * Returns the comments.
	 * 
	 * @return
	 */
	public String getComments();

	/**
	 * Set the comments.
	 * 
	 * @param comments
	 */
	public void setComments(String comments);

}
