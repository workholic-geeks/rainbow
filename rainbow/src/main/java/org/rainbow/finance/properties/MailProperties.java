package org.rainbow.finance.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@PropertySource("classpath:mail/mail.obj")
public class MailProperties {

	@Value("${mail.smtp.starttls.enable}")
	private Boolean starttlsEnabled;

	@Value("${mail.smtp.auth}")
	private Boolean smtpAuth;

	@Value("${mail.smtp.host}")
	private String smtpAddress;

	@Value("${mail.smtp.port}")
	private Long smtpPort;

	@Value("${mail.from.address}")
	private String toMail;

	@Value("${mail.to.address}")
	private String fromMail;

	@Value("${mail.subject.title}")
	private String mailSubject;

	@Value("${mail.password}")
	private String password;

	@Value("${mail.body.template.name}")
	private String mailBodyFileName;

	public Boolean getStarttlsEnabled() {
		return starttlsEnabled;
	}

	public void setStarttlsEnabled(Boolean starttlsEnabled) {
		this.starttlsEnabled = starttlsEnabled;
	}

	public Boolean getSmtpAuth() {
		return smtpAuth;
	}

	public void setSmtpAuth(Boolean smtpAuth) {
		this.smtpAuth = smtpAuth;
	}

	public String getSmtpAddress() {
		return smtpAddress;
	}

	public void setSmtpAddress(String smtpAddress) {
		this.smtpAddress = smtpAddress;
	}

	public Long getSmtpPort() {
		return smtpPort;
	}

	public void setSmtpPort(Long smtpPort) {
		this.smtpPort = smtpPort;
	}

	public String getToMail() {
		return toMail;
	}

	public void setToMail(String toMail) {
		this.toMail = toMail;
	}

	public String getFromMail() {
		return fromMail;
	}

	public void setFromMail(String fromMail) {
		this.fromMail = fromMail;
	}

	public String getMailSubject() {
		return mailSubject;
	}

	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMailBodyFileName() {
		return mailBodyFileName;
	}

	public void setMailBodyFileName(String mailBodyFileName) {
		this.mailBodyFileName = mailBodyFileName;
	}

}
