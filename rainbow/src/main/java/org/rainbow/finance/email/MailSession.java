package org.rainbow.finance.email;

import javax.mail.Session;

public class MailSession {

	public Session session;

	public MailSession(Session session) {
		this.session = session;
	}

	public Session getSession() {
		return session;
	}

}
