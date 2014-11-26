import java.io.IOException;



public class TCPClientInfo extends TCPClientBuilder implements Runnable{
	String event="client info " ;
	public void run() { 
		try { 
			setSocket(); 
			 sInfo(event,s,s.isClosed());  // affichage des info socket client 
			s.connect(isA);  
			writeToServer("Bonjour Polytech'Tours !",s); 
			s.close(); 
			
		} catch(IOException e) 
		{ 
			System.out.println("IOException TCPClientInfo"); 
		} 
	} 
}
