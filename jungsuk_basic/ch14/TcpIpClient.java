package ch14;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

class TcpIpClient {
    public static void main(String[] args) {
        try {
            String serverIp = "127.0.0.1";
            System.out.println("Connect to Server : "+serverIp);
            Socket socket = new Socket(serverIp,7777);
            InputStream in = socket.getInputStream();
            DataInputStream dis = new DataInputStream(in);

            System.out.println("Message : "+dis.readUTF());
            System.out.println("Connection Closing");
            dis.close();
            socket.close();
            System.out.println("Connection Closed");
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
