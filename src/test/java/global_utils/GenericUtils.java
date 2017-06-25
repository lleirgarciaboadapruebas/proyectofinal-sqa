package global_utils;

import selenium_tools.ADriverUtils;

import java.util.Random;

public class GenericUtils {
	
	private ADriverUtils driverUtils;
	
	public GenericUtils(ADriverUtils d){
		this.driverUtils = d;
	}
	
	public int randomNumberBetween(){
	    int res = 0;
		
		Random randomGenerator = new Random();
	    
	    for (int idx = 1; idx <= 10; ++idx){
	    	res = randomGenerator.nextInt(100);
	    }
	    return res;
	}
	
	public int randomNumberSpecificRange(int rangeStart, int rangeEnd){
	    int res = 0;
		Random random = new Random();
	    for (int idx = 1; idx <= 10; ++idx){
	      res = showRandomInteger(rangeStart, rangeEnd, random);
	    }
	    return res;
	}
	
	private int showRandomInteger(int aStart, int aEnd, Random aRandom){
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}

		long range = (long)aEnd - (long)aStart + 1;						//get the range, casting to long to avoid overflow problems
		long fraction = (long)(range * aRandom.nextDouble());			// compute a fraction of the range, 0 <= frac < range
		return (int)(fraction + aStart);    
	} 
	
}
