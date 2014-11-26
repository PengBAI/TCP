import java.io.IOException;
import java.net.SocketException;


public class TCPClientRecord extends TCPClientBuilderSync{
	
	String inputString = "Bonjour Polytech'Tours !";

	public TCPClientRecord(int taille){
		super(taille);
	}

	public void run() {
		try {

			setSocket();
			
			// sInfo(event, s, s.isClosed()); // affichage des info socket client
			writeToServer(inputString, s);
			Thread.sleep(5);
			
			compteurEvenements();
			s.close();
			compteurEvenements();
			
		} catch (SocketException se) {
			System.out.println("SocketException TCPClientRecord");
		} catch (IOException e) {
			System.out.println("IOException TCPClientRecord");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
