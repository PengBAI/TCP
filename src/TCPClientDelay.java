import java.io.IOException;
import java.net.SocketException;

public class TCPClientDelay extends TCPClientBuilderSync {

	String inputString;

	public TCPClientDelay(int taille, String str) {
		super(taille);
		inputString = str;
	}

	public void run() {
		try {

			setSocket();

			// sInfo(event, s, s.isClosed()); // affichage des info socket
			// client
			writeToServer(inputString, s);

			compteurEvenements();
			s.close();
			//compteurEvenements();

			//affichageCompteur();
		} catch (SocketException se) {
			System.out.println("SocketException TCPClientDelay");
		} catch (IOException e) {
			System.out.println("IOException TCPClientDelay");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
