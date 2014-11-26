import java.io.*;
import java.net.Socket;

public class TCPRW extends TCPInfo {
	byte[] buffer;
	private byte[] lbuf;
	private long value;

	/* long to byte */
	private byte[] toBytes(long data) {
		lbuf = new byte[8];
		for (int i = 0; i < 8; i++)
			lbuf[i] = (byte) ((data >> (7 - i) * 8) & 0xff);
		return lbuf;
	}

	/* byte to long */
	private long getLong(byte[] by) {
		value = 0;
		for (int i = 0; i < 8; i++) {
			value = (value << 8) + (by[i] & 0xff);
		}
		return value;
	}

	/* serveur lit le message du client */
	String readFromClient(Socket s) throws IOException {
		int count;
		byte[] sendTime = new byte[8]; // buffer pour le temps au débet de TCP
		InputStream is = s.getInputStream();

		StringBuffer msIn = new StringBuffer();
		is.read(sendTime);

		while ((count = is.read(buffer)) != -1) { // lire le message
			msIn.append(new String(buffer, 0, count));
		}
		
		System.out.println("durée TCP: " // affichage de temps en nanoseconds
				+ (System.nanoTime() - getLong(sendTime)) + " nanoseconds");

		is.close();
		return msIn.toString();
	}

	/* client envoye le message au serveur */
	void writeToServer(String msOut, Socket s) throws IOException {
		OutputStream out = s.getOutputStream();
		
		long sendTime = System.nanoTime(); // le temps au début de TCP
		// System.out.println(sendTime);
		out.write(toBytes(sendTime));
		
		out.write(msOut.getBytes());

		out.flush();
		out.close();
	}

	/* modifier de tempon d'application */
	void setAppBuffer(int taille) {
		buffer = new byte[taille];
	}
}
