import java.io.IOException;
import java.net.SocketException;

public class TCPServerBufferTimingHuge extends TCPServerBuilder implements Runnable {
	String event_server = "server info ";
	String msgClient;
	int tampon_taille;

	public TCPServerBufferTimingHuge(int app_taille, int recu_taille) {
		tampon_taille = app_taille;
		this.setAppBuffer(recu_taille);
	}

	public void run() {
		try {
			setServerSocket();
			ss.setReceiveBufferSize(tampon_taille);
			modifierSocket();
			ssInfo(event_server, ss); // affichage des info de socket serveur
			msgClient = readFromClient(s);
			s.close();
			ss.close();
			System.out.println(msgClient);
		} catch (SocketException se) {
			System.out.println("SocketException TCPServerBufferTimingHuge ");
		} catch (IOException e) {
			System.out.println("IOException TCPServerBufferTimingHuge ");
		}
	}
}
