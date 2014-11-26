import java.net.*; 
import java.io.*; 


public abstract class TCPClientBuilderSync extends TCPRWSync{ 
	Socket s; 
	InetSocketAddress isA; 
	int tampon_taille;
	public TCPClientBuilderSync(int tempon) { 
		s = null; 
		isA = new InetSocketAddress("localhost",8080); 
		tampon_taille=tempon;
	} 
	void setSocket() throws  IOException, SocketException, InterruptedException
	{ 
		s = new Socket(); 
		s.setSendBufferSize(tampon_taille);
		s.setSoTimeout(3000);   // gestion de paramètre Timeout
		s.setSoLinger(true, MAX_PRIORITY);
		
		//Thread.sleep(5);
		compteurEvenements();
		s.connect(isA); 
		//compteurEvenements();
		/* we can include more setting, later … */
	} 
} 