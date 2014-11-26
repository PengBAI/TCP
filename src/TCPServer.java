import java.net.*; 
import java.io.*; 


/** The TCP server. */ 
public class TCPServer implements Runnable { 
	private ServerSocket ss; 
	private InetSocketAddress isA; 
	private Socket s; 
	TCPServer() { 
		ss = null ; 
		isA = new InetSocketAddress("localhost",8080); 
	} 
	public void run( ) { 
		try { 
			ss = new ServerSocket(); 
			ss.bind(isA); 
			s = ss.accept(); 
			s.close(); 
		} 
		catch(IOException e) 
		{ System.out.println("IOException TCPServer "); }
	} 
 } 
