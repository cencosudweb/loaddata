/**
 * 
 */
package cl.org.is.api.job;

import java.io.File;
import java.math.BigInteger;
import java.text.DecimalFormat;

/**
 * @author EA7129
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte[] bytes = new byte[] { (byte) 0x12, (byte) 0x0F, (byte) 0xF0 };

	    BigInteger bi = new BigInteger(bytes);

	    // Format to decimal
	    String s = bi.toString();
	    
	    System.out.println(s);
	    
	    DecimalFormat df = new DecimalFormat("#.00"); 
	    System.out.println(df.format(11111));
	
	
	    File file1                   = new File("C:/Users/ea7129/workspace/omnicanales" + "/" + "chi_paris_0_omni_mov_20170920_76.dat");
	    System.out.println(file1);
	    
	    
	    int x = 1;
	    System.out.printf("%d", x);
	    
	
	    
	    

	}

}
