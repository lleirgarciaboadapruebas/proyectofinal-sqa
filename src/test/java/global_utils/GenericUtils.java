package global_utils;

import java.util.Random;

import selenium_tools.ADriverUtils;

public class GenericUtils {
	
	private ADriverUtils driverUtils;
	
	public GenericUtils(ADriverUtils d){
		this.driverUtils = d;
	}

    public static int randomNumberBetween() {
        int res = 0;
		
		Random randomGenerator = new Random();
	    
	    for (int idx = 1; idx <= 10; ++idx){
	    	res = randomGenerator.nextInt(100000);
	    }
	    return res;
	}

    public static int randomNumberSpecificRange(int rangeStart, int rangeEnd) {
        int res = 0;
		Random random = new Random();
	    for (int idx = 1; idx <= 10; ++idx){
	      res = showRandomInteger(rangeStart, rangeEnd, random);
	    }
	    return res;
	}

    private static int showRandomInteger(int aStart, int aEnd, Random aRandom) {
        if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}

		long range = (long)aEnd - (long)aStart + 1;						//get the range, casting to long to avoid overflow problems
		long fraction = (long)(range * aRandom.nextDouble());			// compute a fraction of the range, 0 <= frac < range
		return (int)(fraction + aStart);
    }

    public static String randomString(int large) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < large; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }

        return sb.toString();
    }

}
