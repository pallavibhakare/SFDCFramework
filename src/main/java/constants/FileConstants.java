package constants;

import utils.CommonUtils;

public class FileConstants {
	public static final String LOGIN_TESTDATA_FILE_PATH = 
			System.getProperty("user.dir")+"/src/main/java/testdata/loginTestData.properties";
	public static final String SCREENSHOTS_FOLDER_PATH = 
			System.getProperty("user.dir")+"/src/main/java/reports/"+CommonUtils.getTimeStamp()+".png";
	public static final String FILE_PATH = 
			System.getProperty("user.dir")+"/src/main/resources/SampleData.xlsx";
	public static final String IMAGE_PATH=
			System.getProperty("user.dir")+"/src/main/java/reports/sample.png";
	public static final String REPORT_PATH=
			System.getProperty("user.dir")+"/src/main/java/reports/"+CommonUtils.getTimeStamp()+".html";
	
}
