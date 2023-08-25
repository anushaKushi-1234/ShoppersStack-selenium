package genericLibraries;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int generateRandomNum(int limit) {
		Random random=new Random();
		return random.nextInt(limit);
		}
	public String getcurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy-hh-mm-sss");
		return sdf.format(date);
	}

}
