package ch14;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

class TcpIpServer {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(7777);
            System.out.println("Server Ready");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true) {
            try {
                System.out.println(getTime()+"Wait");
                Socket socket = serverSocket.accept();
                System.out.println(getTime()+socket.getInetAddress()+" Connected");

                OutputStream out = socket.getOutputStream();
                DataOutputStream dos = new DataOutputStream(out);

                dos.writeUTF("[Notice] Test Message1 from Server");
                System.out.println(getTime()+"Send Data");

                dos.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static String getTime() {
        SimpleDateFormat f= new SimpleDateFormat("[hh:mm:ss]");
        return f.format(new Date());
    }
}
