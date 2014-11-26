import java.io.*; 

public class TCPServerHello extends TCPServerBuilder implements Runnable{
	public void run(){
		try { 
			setServerSocket();
			modifierSocket();
			s.close(); 
		} 
		catch(IOException e) 
		{ System.out.println("IOException TCPServer "); }
	}
}
