package org.rainbow.finance.job;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.contracts.job.Job;
import org.rainbow.finance.email.EmailSenderWork;
import org.rainbow.finance.file.FilesUtility;
import org.rainbow.finance.model.ApplyLoanComand;
import org.rainbow.finance.properties.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class EmailJob implements Job {

	@Autowired
	private FilesUtility filesUtility;

	private Queue<Command> queue = new LinkedList<Command>();

	@Autowired
	private PropertySource emailProp;

	@Autowired
	private EmailSenderWork work;

	private Logger logger = Logger.getLogger(this.getClass().getName());

	/**
	 * This will execute every day at 3pm
	 * 
	 */
	@Scheduled(cron = "0 15 * * * ?")
	@Override
	public void execute() {
		logger.info("-----------Starting Email job----------");
		logger.info("Email back-up file name: " + emailProp.getBackupFile());
		if (filesUtility.checkFileExists(emailProp.getBackupFile())) {
			logger.info("Reading back-up file.");
			try {
				InputStream stream = filesUtility.readFile(emailProp.getBackupFile());
				BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
				String line = null;
				while ((line = reader.readLine()) != null) {
					logger.info("Email message:" + line);
					pushToQueue(line);
				}
				stream.close();
				stream = null;
				filesUtility.readFile(emailProp.getBackupFile());
				executeEmailThread();
			} catch (Exception e) {
				logger.log(Level.SEVERE, "ERROR", e);
			}
		}

		logger.info("-----------End Email job----------");
	}

	public void pushToQueue(String data) {
		Command command = new ApplyLoanComand();
		String[] content = data.split(";");
		for (String contentData : content) {
			String[] slicedData = contentData.split(":");
			if ("Name".equals(slicedData[0])) {
				command.setName(slicedData[1]);
			} else if ("Phone No".equals(slicedData[0])) {
				command.setPhoneNumber(Long.valueOf(slicedData[1]));
			} else if ("Email".equals(slicedData[0])) {
				command.setPersonEmail(slicedData[1]);
			} else if ("Comments".equals(slicedData[0])) {
				command.setPersonEmail(slicedData[1]);
			}
			queue.add(command);
		}
	}

	public void executeEmailThread() {
		Executor executor = Executors.newFixedThreadPool(2, new ThreadFactory() {
			ThreadGroup group = new ThreadGroup("Email Group");

			@Override
			public Thread newThread(Runnable r) {
				Thread thread = new Thread(group, r);
				return thread;
			}
		});
		work.setQueue(queue);
		executor.execute(work);
	}
}
