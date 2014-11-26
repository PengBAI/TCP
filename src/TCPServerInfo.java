import java.io.IOException;


public class TCPServerInfo extends TCPServerBuilder implements Runnable{
	String event_server="server info ";
	String msgClient;
	public void run(){
		try { 
			setServerSocket();
			modifierSocket();
			 ssInfo(event_server,ss);  // affichage des info de socket serveur
			msgClient = readFromClient(s);
			s.close(); 
			System.out.println(msgClient);
		} 
		catch(IOException e) 
		{ System.out.println("IOException TCPServerInfo "); }
	}
}
