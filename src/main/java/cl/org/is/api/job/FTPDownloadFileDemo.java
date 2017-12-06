/**
 * 
 */
package cl.org.is.api.job;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

/**
 * @author EA7129
 *
 */
public class FTPDownloadFileDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String server = "aristocrata.cl";
		int port = 21;
		String user = "aristocr";
		String pass = "nx37GwQp55";

		FTPClient ftpClient = new FTPClient();
		try {

			ftpClient.connect(server, port);
			ftpClient.login(user, pass);
			ftpClient.enterLocalPassiveMode();
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);

			// APPROACH #1: using retrieveFile(String, OutputStream)
			String remoteFile1 = "/public_html/test4.txt";
			File downloadFile1 = new File("C:/Share/Inbound/OMNICANAL/test4.txt");
			OutputStream outputStream1 = new BufferedOutputStream(new FileOutputStream(downloadFile1));
			boolean success = ftpClient.retrieveFile(remoteFile1, outputStream1);
			outputStream1.close();

			if (success) {
				System.out.println("File #1 has been downloaded successfully.");
			}
			
			// APPROACH #2: using InputStream retrieveFileStream(String)
	        String remoteFile2 = "/public_html/test2.txt";
	        File downloadFile2 = new File("C:/Share/Inbound/OMNICANAL/test2.txt");
	        OutputStream outputStream2 = new BufferedOutputStream(new FileOutputStream(downloadFile2));
	        InputStream inputStream = ftpClient.retrieveFileStream(remoteFile2);
	        byte[] bytesArray = new byte[4096];
	        int bytesRead = -1;
	        while ((bytesRead = inputStream.read(bytesArray)) != -1) {
	        	outputStream2.write(bytesArray, 0, bytesRead);
	        }

	        success = ftpClient.completePendingCommand();
			if (success) {
				System.out.println("File #2 has been downloaded successfully.");
			}
			outputStream2.close();
			inputStream.close();
			

		} catch (IOException ex) {
			System.out.println("Error: " + ex.getMessage());
			ex.printStackTrace();
		} finally {
			try {
				if (ftpClient.isConnected()) {
					ftpClient.logout();
					ftpClient.disconnect();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}

	}

}
