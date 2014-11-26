import java.net.*; 
import java.io.*; 


public abstract class TCPServerBuilder extends TCPRW{
	ServerSocket ss; 
	InetSocketAddress isA; 
	Socket s; 
	TCPServerBuilder() { 
		ss = null ; 
		isA = new InetSocketAddress("localhost",8080); 
	} 
	void setServerSocket()throws IOException 
	{
		ss = new ServerSocket(); 
		ss.bind(isA); 
		ss.setSoTimeout(3000);   // gestion de paramètre Timeout
	}
	void modifierSocket()throws IOException {
		s = ss.accept(); 
	}
}
