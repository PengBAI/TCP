public class Server_Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		new Thread(new TCPServerInfo()).start(); 
//		new  Thread(new TCPClientInfo()).start();
//		new Thread(new TCPServerBufferTiming(1024,1024)).start(); 
//		new  Thread(new TCPClientBufferTiming(1024)).start();
		
//		new Thread(new TCPServerBufferTiming(1024,1024)).start(); 
//		new  Thread(new TCPClientBufferTiming(1024)).start();
////		
//		  new Thread(new TCPServerBufferTimingHuge(1024, 1024)).start(); 
//		  new Thread(new TCPClientBufferTimingHuge(1024)).start();
		 

//		
//		 new Thread(new TCPServerRecord(1024, 1024)).start(); 
//		 new Thread(new TCPClientRecord(1024)).start();
		
		new Thread(new TCPServerDelay(1024, 1024)).start();
		new Thread(new TCPClientDelay(1024, "Bonjour Client 1 !")).start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new TCPClientDelay(1024, "Bonjour Client 2 !")).start();
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new TCPClientDelay(1024, "Bonjour Client 3 !")).start(); 
		/*
		new Thread(new TCPServerBacklog(1024, 1024)).start();
		new Thread(new TCPClientBacklog(1024, "Bonjour Client 1 !")).start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new TCPClientBacklog(1024, "Bonjour Client 2 !")).start();
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new Thread(new TCPClientBacklog(1024, "Bonjour Client 3 !")).start();*/
	}

}
