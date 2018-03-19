package com.crm.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ApplicationErrorLoging {

	private static String OS = System.getProperty("os.name").toLowerCase();

	public static void log(String context, Object error) {
		Date currentTimeStamp = new Date();
		DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String errorHeader = context + " " + dataFormat.format(currentTimeStamp);
		dataFormat = new SimpleDateFormat("yyyy-MM-dd");
		File logFile = new File(detectOS() + "webKb_" + dataFormat.format(currentTimeStamp) + ".log");
		if (!logFile.exists()) {
			try {
				logFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		// Get Stack Trace from Error
		StringWriter stringWriter = new StringWriter();
		((Throwable) error).printStackTrace(new PrintWriter(stringWriter));
		String exceptionAsString = stringWriter.toString();
		try {
			FileOutputStream oFile = new FileOutputStream(logFile, true);

			oFile.write(System.getProperty("line.separator").getBytes());
			oFile.write(errorHeader.getBytes());
			oFile.write(System.getProperty("line.separator").getBytes());
			oFile.write(((Throwable) error).getMessage().getBytes());
			oFile.write(System.getProperty("line.separator").getBytes());
			oFile.write(exceptionAsString.getBytes());
			oFile.write(System.getProperty("line.separator").getBytes());
			oFile.flush();
			oFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static String detectOS() {
		String logPath = "/tmp/";
		if (isWindows()) {
			logPath = "C:\\Log\\";
		} else if (isMac()) {
			logPath = "/tmp/";
		} else if (isUnix()) {
			logPath = "/tmp/";
		}
		return logPath;
	}

	private static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	private static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	private static boolean isUnix() {
		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
	}
}
