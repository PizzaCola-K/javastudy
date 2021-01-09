package ch14;

import java.io.IOException;
import java.net.*;

class UdpClient {
    public void start() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        InetAddress serverAddress = InetAddress.getByName("127.0.0.1");

        byte[] msg = new byte[100];
        DatagramPacket outPacket = new DatagramPacket(msg,1,serverAddress,7777);
        DatagramPacket inPacket = new DatagramPacket(msg, msg.length);

        datagramSocket.send(outPacket);
        datagramSocket.receive(inPacket);

        System.out.println("Current Server Time : "+new String(inPacket.getData()));
        datagramSocket.close();
    }
    public static void main(String[] args) {
        try {
            new UdpClient().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
