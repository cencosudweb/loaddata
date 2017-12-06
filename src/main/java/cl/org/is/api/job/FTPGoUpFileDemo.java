/**
 * 
 */
package cl.org.is.api.job;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

/**
 * @author EA7129
 *
 */
public class FTPGoUpFileDemo {

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
			
			
			int reply = ftpClient.getReplyCode();

			System.out.println("Respuesta recibida de conexión FTP:" + reply);

			if (FTPReply.isPositiveCompletion(reply)) {
				System.out.println("Conectado Satisfactoriamente");
			} else {
				System.out.println("Imposible conectarse al servidor");
			}
			
			

			BufferedInputStream buffIn = null;
			buffIn = new BufferedInputStream(new FileInputStream("C:\\Share\\Inbound\\OMNICANAL\\test4.txt"));// Ruta
																		// del
																		// archivo
																		// para
																		// enviar
			ftpClient.enterLocalPassiveMode();
			boolean success =  ftpClient.storeFile("/public_html/test4.txt", buffIn);// Ruta completa de alojamiento en
											// el FTP
			buffIn.close();
			
			if (success) {
				System.out.println("File #1 has been u successfully.");
			}
			/*
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
			*/

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
