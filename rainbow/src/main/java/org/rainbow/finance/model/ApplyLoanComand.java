package org.rainbow.finance.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.rainbow.finance.contracts.command.Command;

public class ApplyLoanComand implements Command {

	private String fromMailAddress;

	private String toMailAddress;

	@NotNull
	@Size(max = 10, message = "Phone Number should not be empty.")
	private Long phoneNumber;

	private Long loanAmount;

	private String comments;

	@NotNull(message = "Name should not be empty.")
	private String name;

	@NotNull(message = "Please provide a valid email.")
	@Email
	private String personEmail;

	public String getPersonEmail() {
		return personEmail;
	}

	public void setPersonEmail(String personEmail) {
		this.personEmail = personEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFromMailAddress() {
		return fromMailAddress;
	}

	public void setFromMailAddress(String fromMailAddress) {
		this.fromMailAddress = fromMailAddress;
	}

	public String[] getToMailAddress() {
		return toMailAddress.split(";");
	}

	public void setToMailAddress(String toMailAddress) {
		this.toMailAddress = toMailAddress;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Long loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
