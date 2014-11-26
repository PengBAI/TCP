import java.net.*;
import java.io.*;

public abstract class TCPServerBuilderSync extends TCPRWSync {
	ServerSocket ss;
	InetSocketAddress isA;
	Socket s;
	int backlog = 3;

	TCPServerBuilderSync() {
		ss = null;
		isA = new InetSocketAddress("localhost",8080);
	}

	void setServerSocket() throws IOException {
		ss = new ServerSocket(8080,backlog);
		// ss.bind(isA);
		ss.setSoTimeout(3000); // gestion de paramètre Timeout
	}

	void modifierSocket() throws IOException, InterruptedException {
		//Thread.sleep(10);
		//compteurEvenements();
		s = ss.accept();
		//compteurEvenements();
		s.setSoLinger(true, MAX_PRIORITY);
	}
}
