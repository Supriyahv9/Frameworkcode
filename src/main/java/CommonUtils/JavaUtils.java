package CommonUtils;

import java.util.Random;

public class JavaUtils {

	public int getRandomnumber() {

		Random r = new Random();	
		int ran = r.nextInt(1000);
		return ran;
}
}
