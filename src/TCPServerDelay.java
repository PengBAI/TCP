import java.io.IOException;
import java.net.SocketException;

public class TCPServerDelay extends TCPServerBuilderSync {
	private static final int NBR_CLIENT = 3;
	// String event_server = "server info ";
	String msgClient;
	int tampon_taille;

	public TCPServerDelay(int app_taille, int recu_taille) {
		tampon_taille = app_taille;
		this.setAppBuffer(recu_taille);
	}

	public void run() {
		try {

			setServerSocket();
			ss.setReceiveBufferSize(tampon_taille);
			for (int i = 0; i < NBR_CLIENT; i++) {
				modifierSocket();
				// ssInfo(event_server, ss); // affichage des info de socket
				// serveur
				msgClient = readFromClient(s);

				//compteurEvenements();
				s.close();
				//compteurEvenements();

				System.out.println(msgClient);
				// affichageCompteur();
			}
			ss.close();
			affichageCompteur();
		} catch (SocketException se) {
			se.printStackTrace();
			System.out.println("SocketException TCPServerDelay");
		} catch (IOException e) {
			System.out.println("IOException TCPServerDelay");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
