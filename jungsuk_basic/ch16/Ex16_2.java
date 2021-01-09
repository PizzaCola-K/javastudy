package ch16;

import java.net.MalformedURLException;
import java.net.URL;

class Ex16_2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://stackoverflow.com/jobs?q=java");

        System.out.println(url.getAuthority());
        System.out.println(url.getContent());
        System.out.println(url.getDefaultPort());
        System.out.println(url.getPort());
        System.out.println(url.getFile());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.getProtocol());
        System.out.println(url.getQuery());
        System.out.println(url.getRef());
        System.out.println(url.getUserInfo());
        System.out.println(url.toExternalForm());
        System.out.println(url.toURI());
    }
}
