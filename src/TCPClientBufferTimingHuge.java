import java.io.IOException;
import java.net.SocketException;

public class TCPClientBufferTimingHuge extends TCPClientBuilder implements Runnable {
	int tampon_taille;
	String inputString = "Bonjour Polytech'Tours !";
	String event = "client info ";

	public TCPClientBufferTimingHuge(int taille) {
		tampon_taille = taille;
	}

	public void run() {
		try {

			setSocket();
			s.setSendBufferSize(tampon_taille);
			s.connect(isA);

			sInfo(event, s, s.isClosed()); // affichage des info socket client
			writeToServer(inputString, s);

			s.close();

		} catch (SocketException se) {
			System.out.println("SocketException TCPClientBufferTimingHuge");
		} catch (IOException e) {
			System.out.println("IOException TCPClientBufferTimingHuge");
		}

	}
}
