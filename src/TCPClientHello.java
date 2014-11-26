import java.io.*; 


public class TCPClientHello extends TCPClientBuilder implements Runnable { 
	public void run() { 
		try { 
			setSocket(); 
			s.connect(isA); 
			System.out.println("Hello, client connected");  s.close(); 
		} 
		catch(IOException e) 
		{ System.out.println("IOException TCPClientConnect"); } 
	} 
} 
