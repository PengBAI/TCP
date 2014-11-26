import java.io.IOException;
import java.net.SocketException;

public class TCPServerRecord extends TCPServerBuilderSync {
	// String event_server = "server info ";
	String msgClient;
	int tampon_taille;

	public TCPServerRecord(int app_taille, int recu_taille) {
		tampon_taille = app_taille;
		this.setAppBuffer(recu_taille);
	}

	public void run() {
		try {
			setServerSocket();
			ss.setReceiveBufferSize(tampon_taille);

			modifierSocket();
			// ssInfo(event_server, ss); // affichage des info de socket serveur
			msgClient = readFromClient(s);
			Thread.sleep(20);
			compteurEvenements();
			s.close();
			compteurEvenements();

			ss.close();
			System.out.println(msgClient);
			
			affichageCompteur();
		} catch (SocketException se) {
			System.out.println("SocketException TCPServerRecord ");
		} catch (IOException e) {
			System.out.println("IOException TCPServerRecord ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
