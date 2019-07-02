package org.rainbow.finance.configs;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;

import org.rainbow.finance.email.MailSenderFactory;
import org.rainbow.finance.file.FilesUtility;
import org.rainbow.finance.properties.MailProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.Scope;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * This class will initialize app necessary configuration.
 * 
 * @author Anish Singh
 *
 */
@Component
@Scope("singleton")
@Profile("!dev")
public class AppConfig implements org.rainbow.finance.contracts.app.AppConfig {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private FilesUtility filesUtility;

	@SuppressWarnings("unused")
	@Autowired
	private MailSenderFactory factory;

	@Autowired
	private MailProperties mailProperties;
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void initConfig() {
		logger.info("----------Initializing app custom configuration------------");

		if (filesUtility.checkFileExists(mailProperties.getBackupDir())) {
			logger.info("---App back-up dir " + mailProperties.getBackupDir() + " already exists----");
		} else {
			logger.info("---Creating back-up dir " + mailProperties.getBackupDir() + "----");
			filesUtility.createDir(mailProperties.getBackupDir());
			logger.info("---back-up dir " + mailProperties.getBackupDir() + " created ----");
		}

		logger.info("----------App Initialization finished---------");
	}


	@Override
	@PreDestroy
	public void destroy() {
		try {
			logger.info("-------Destroying app------------");

			if (mailSender != null) {
				mailSender=null;

			}

			logger.info("-------Email Session destroyed------------");
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
		}
		logger.info("-------App destruction finished------------");
	}

}
