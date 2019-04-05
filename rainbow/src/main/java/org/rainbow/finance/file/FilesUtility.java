package org.rainbow.finance.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import org.springframework.stereotype.Component;

@Component
public class FilesUtility {

	public OutputStream createFile(String fileName) throws Exception {
		return new FileOutputStream(new File(fileName));
	}

	public boolean checkFileExists(String fileName) {
		File file = new File(fileName);
		return file.exists();
	}

	public void removeFile(String fileName) {
		File file = new File(fileName);
		file.delete();
	}

	public InputStream readFile(String fileName) throws Exception {
		return new FileInputStream(new File(fileName));
	}

	public OutputStream getOutputStream(String fileName) throws Exception {
		return new FileOutputStream(new File(fileName));
	}

}
