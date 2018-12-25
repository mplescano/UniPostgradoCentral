package util;

/**
 *
 *
 */
public class Utilities {
	
	/**
	 * @param prefix
	 * @param suffix
	 * @param codeLength
	 * @param codePadder
	 * @param secuencialMax
	 * @return
	 */
	public static String getRandomSecuencial (String prefix, String suffix, int codeLength, char codePadder, int secuencialMax) {
	    int n;
	    double d = Math.random();       // 0.0  to  1.0
	    d = d * 100;
	    n = (int)(d % secuencialMax) + 1;           // 1 to 22  (max. 100)
		return prefix + Utilities.addPadding(n + "", codePadder, codeLength, true) + suffix;
	}
	
	/**
	 * @param str
	 * @return
	 */
	public static boolean isEmpty (String str) {
		return (str == null || str.length() <= 0);
	}
	
	/**
	 * @param origin
	 * @param padder
	 * @param spaces
	 * @param isLeft
	 * @return
	 */
	public static String addPadding (String origin, char padder, int spaces, boolean isLeft) {
		StringBuffer strbuffPadding = new StringBuffer(origin);
		if (isLeft) {
			for (int i = 0; i < spaces - origin.length(); i++) {
				strbuffPadding.insert(0, padder);
			}
		}
		else {
			for (int i = 0; i < spaces - 1 - origin.length(); i++) {
				strbuffPadding.append(padder);
			}
		}
		
		
		return strbuffPadding.toString();
	}

}
