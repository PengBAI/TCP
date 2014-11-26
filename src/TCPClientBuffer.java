import java.io.IOException;
import java.net.SocketException;

public class TCPClientBuffer extends TCPClientBuilder implements Runnable {
	int tampon_taille;
	String event = "client info ";

	public TCPClientBuffer(int taille) {
		tampon_taille = taille;
	}

	public void run() {
		try {

			setSocket();
			s.setSendBufferSize(tampon_taille);
			s.connect(isA); // test Timeout ici

			sInfo(event, s, s.isClosed()); // affichage des info socket client
			writeToServer("Bonjour Polytech ", s);
			// System.out.println("Hello, client connected");
			s.close();

		} catch (SocketException se) {
			System.out.println("SocketException TCPClientBuffer");
		} catch (IOException e) {
			System.out.println("IOException TCPClientBuffer");
		}

	}
}
