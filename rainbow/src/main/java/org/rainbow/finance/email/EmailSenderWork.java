package org.rainbow.finance.email;

import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.mail.MailFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderWork implements Runnable {

	Logger logger = Logger.getLogger(this.getClass().getName());

	private Object lock = new Object();

	@Autowired
	@Qualifier("mailFactory")
	private MailFactory factory;

	private Queue<Command> command;

	@Override
	public void run() {
		try {
			Command applyLoanCommand = null;
			synchronized (lock) {
				applyLoanCommand = command.poll();
			}
			factory.getMailSender().sendMail(applyLoanCommand);
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
		}
	}

	public Queue<Command> getQueue() {
		return command;
	}

	public void setQueue(Queue<Command> command) {
		this.command = command;
	}

}
