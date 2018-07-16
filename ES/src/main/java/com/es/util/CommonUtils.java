package com.es.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;

public class CommonUtils {

	private static Logger log = Logger.getLogger(CommonUtils.class.getName());

	public static String getURL() throws IOException {
		String url = null;
		if (System.getProperty("Env").equalsIgnoreCase("qa")) {
			url = Prop.getConfigValue("applicationURL-QA").toString();
		} else if (System.getProperty("Env").equalsIgnoreCase("uat")) {
			url = Prop.getConfigValue("applicationURL-UAT").toString();
		} else {
			url = Prop.getConfigValue("applicationURL-PROD").toString();
		}
		return url;
	}

	public static String getChromeDriverPath(){
		Path chromeDriverPath;
		if(System.getProperty("os.name").startsWith("Mac")){
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver", "chromedriver");
		}else{
			chromeDriverPath = Paths.get(System.getProperty("user.dir"), "src", "main", "resources", "driver", "chromedriver.exe");
		}
		return chromeDriverPath.toString();
	}

	public static String getCurrentTimeForScreenShot() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd_MMM_yyyy_hh-mm-ss_aaa(zzz)");
		java.util.Date curDate = new java.util.Date();
		String strDate = sdf.format(curDate);
		String strActDate = strDate.toString();
		return strActDate;
	}

	public static void cleanOrCreateDirectory(String dirPath) {
		try {
			FileUtils.cleanDirectory(new File(dirPath));
			log.info("empty "+dirPath+" directory");
		} catch (java.lang.IllegalArgumentException e) {
			log.info(dirPath + "  directory is not exist, created it");
			File directory = new File(dirPath);
			if (!directory.exists()) {
				directory.mkdir();
			}
		} catch (IOException e) {
			log.info("invalid path: "+dirPath);
			e.printStackTrace();
		}
	}

	public static String getRandomYopMailId() {
		return "TestESApp."+new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date())+"@yopmail.com";
	}
	
	public static void main(String[] args) {
		System.out.println(CommonUtils.getRandomYopMailId());
	}
}
