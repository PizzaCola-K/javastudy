package ch16;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

class Ex16_1 {
    public static void main(String[] args) {
        InetAddress ip = null;
        InetAddress[] ipArr = null;

        try {
            ip = InetAddress.getByName("www.naver.com");
            System.out.println(ip.getHostName());
            System.out.println(ip.getHostAddress());
            System.out.println(ip.toString());

            byte[] ipAddr = ip.getAddress();
            System.out.println(Arrays.toString(ipAddr));

            String result = "";
            for(int i = 0;  i< ipAddr.length ; i++) {
                result += (ipAddr[i] < 0 ? ipAddr[i] +256 : ipAddr[i])+".";
            }
            System.out.println(result);
            System.out.println();
        }catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            ip = InetAddress.getLocalHost();
            System.out.println(ip.getHostName());
            System.out.println(ip.getHostAddress());
            System.out.println(ip.toString());
            System.out.println();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            ipArr = InetAddress.getAllByName("www.naver.com");

            for(int i = 0 ; i < ipArr.length;i++) {
                System.out.println(ipArr[i]);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
