package org.rainbow.finance.email;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.rainbow.finance.contracts.command.Command;
import org.rainbow.finance.file.FilesUtility;
import org.rainbow.finance.properties.MailProperties;
import org.rainbow.finance.properties.PropertySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailHelper {

	Logger logger = Logger.getLogger(this.getClass().getName());

	@Autowired
	private FilesUtility utility;

	@Autowired
	private PropertySource props;

	@Autowired
	private MailProperties mailProps;

	public void writeToFile(Command command) {
		BufferedWriter writer = null;
		try {

			if (!utility.checkFileExists(props.getBackupFile())) {
				writer = new BufferedWriter(
						new OutputStreamWriter(utility.createFile(mailProps.getBackupDir(), props.getBackupFile())));

			} else {
				writer = new BufferedWriter(new OutputStreamWriter(
						utility.getOutputStream(mailProps.getBackupDir(), props.getBackupFile())));
			}
			StringBuffer buffer = new StringBuffer();
			buffer.append("Name:" + command.getName());
			buffer.append(";");
			buffer.append("Phone No:" + command.getPhoneNumber());
			buffer.append(";");
			buffer.append("Email:" + command.getPersonEmail());
			buffer.append(";");
			buffer.append("Comments:" + command.getPersonEmail());
			writer.write(buffer.toString());
			writer.newLine();
			writer.close();
		} catch (Exception e) {
			logger.log(Level.SEVERE, "Error", e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					logger.log(Level.SEVERE, "Error", e);
				}
			}
		}
	}

}
