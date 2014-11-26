import java.net.*; 
import java.io.*; 


public abstract class TCPClientBuilder extends TCPRW{ 
	Socket s; 
	InetSocketAddress isA; 
	TCPClientBuilder() { 
		s = null; 
		isA = new InetSocketAddress("localhost",8080); 
	} 
	void setSocket() throws  IOException, SocketException
	{ 
		s = new Socket(); 
		s.setSoTimeout(3000);   // gestion de paramètre Timeout
		
		/* we can include more setting, later … */
	} 
} 