import java.net.*; 
import java.io.*; 


/** The TCP client */ 
public class TCPClient implements Runnable { 
	private Socket s; 
	private InetSocketAddress isA; 
	TCPClient() { 
		s = new Socket(); 
		isA = new InetSocketAddress("localhost",8080); 
	} 
	public void run( ) { 
		try { 
			s.connect(isA); 
			System.out.println("Hello World, client connected"); 
			s.close(); 
		} 
		catch(IOException e) 
		{ System.out.println("IOException TCPClient"); } 
	} 
} 
