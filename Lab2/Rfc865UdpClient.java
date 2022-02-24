import java.net.*;
import java.io.*;


public class Rfc865UdpClient {
	
	/*
	 * Name: Lim Ziyi Janesse
	 * Group: SSP6
	 * IP Address: 172.21.147.134
	 */
	
	public static void main(String[]args) {
		
		 //
		 // 1. Open UDP socket
		 //
		System.out.println("Client Running..");
		DatagramSocket socket = null;
		
		try {
			socket = new DatagramSocket();
		}catch(SocketException e) {}
		
		try {
			 //
			 // 2. Send UDP request to server
			 //
			InetAddress serverIpAddr = InetAddress.getByName("swlab2-c.scse.ntu.edu.sg");
			int port = 17;

			String message = new String("Lim Ziyi Janesse, SSP6, 172.21.147.134");
			byte[] buf = message.getBytes();
			DatagramPacket request = new DatagramPacket(buf, buf.length, serverIpAddr, port);
			socket.send(request);
			
			 //
			 // 3. Receive UDP reply from server
			 //
			byte[] newBuf = new byte[512];
			DatagramPacket reply = new DatagramPacket(newBuf, newBuf.length);
			socket.receive(reply);
			
			String quote = new String(reply.getData(), 0, reply.getLength());
			
			System.out.println(quote);
			System.out.println("end");
			
		}catch(IOException e) {}
		
		socket.close();
	}
}


Client Running..
Not everything that can be counted counts, and not everything that counts can be counted - Albert Einstein.
end
