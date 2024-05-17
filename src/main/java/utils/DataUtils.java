package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import constants.FileConstants;

/**
 * @author Pal
 *To read the login test data file
 *@param key provide key to get the value
 */
public class DataUtils {

	public static String readLoginTestData(String key) throws IOException {
		FileInputStream file = new FileInputStream(FileConstants.LOGIN_TESTDATA_FILE_PATH);
		Properties p = new Properties();		
		p.load(file);
		return p.getProperty(key);
	}
	
}
