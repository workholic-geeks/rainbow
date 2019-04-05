package org.rainbow.finance.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@org.springframework.context.annotation.PropertySource("classpath:messages.properties")
public class PropertySource {

	@Value("${org.rainbow.name.required}")
	private String invalidName;

	@Value("${org.rainbow.valid.phone.number.required}")
	private String invalidPhoneNumber;

	@Value("${org.rainbow.to.mail.required}")
	private String invalidToAddress;

	@Value("${org.rainbow.amount.required}")
	private String invalidAmount;

	@Value("${mail.backup.file.name}")
	private String backupFile;

	public String getInvalidName() {
		return invalidName;
	}

	public void setInvalidName(String invalidName) {
		this.invalidName = invalidName;
	}

	public String getInvalidPhoneNumber() {
		return invalidPhoneNumber;
	}

	public void setInvalidPhoneNumber(String invalidPhoneNumber) {
		this.invalidPhoneNumber = invalidPhoneNumber;
	}

	public String getInvalidToAddress() {
		return invalidToAddress;
	}

	public void setInvalidToAddress(String invalidToAddress) {
		this.invalidToAddress = invalidToAddress;
	}

	public String getInvalidAmount() {
		return invalidAmount;
	}

	public void setInvalidAmount(String invalidAmount) {
		this.invalidAmount = invalidAmount;
	}

	public String getBackupFile() {
		return backupFile;
	}

	public void setBackupFile(String backupFile) {
		this.backupFile = backupFile;
	}

}
