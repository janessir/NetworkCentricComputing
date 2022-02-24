import java.net.*;
import java.io.*;

public class Rfc865UdpServer {
	public static void main(String[] argv) {
		 //
		 // 1. Open UDP socket at well-known port
		 //
		 DatagramSocket socket = null;
		 
		 try {
			 socket = new DatagramSocket(17);
			 System.out.println("Server is connected..");
		 } catch (SocketException e) {}
		 
		 while (true) {
			 try {
				 //
				 // 2. Listen for UDP request from client
				 //
				 byte [] buf = new byte[562];
				 DatagramPacket request = new DatagramPacket(buf, buf.length);
				 socket.receive(request);
				 
				 //printing request message
				 String requestMsg =  new String(request.getData(), 0, request.getLength());
				 System.out.println("Receiving client request");
				 System.out.println(requestMsg);
				 
				 
				 //
				 // 3. Send UDP reply to client
				 //
				 byte [] newBuf = new byte [562];
				 InetAddress clientAddr = request.getAddress();
				 int clientPort = request.getPort();
				 DatagramPacket reply = new DatagramPacket(newBuf, newBuf.length, clientAddr, clientPort);

				 socket.send(reply);
				 } catch (IOException e) {}
			 }
		 }

}
