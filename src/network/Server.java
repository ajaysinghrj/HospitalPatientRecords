package network;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server running...");
        Socket s = ss.accept();
        DataInputStream dis = new DataInputStream(s.getInputStream());
        System.out.println("Client says: " + dis.readUTF());
        ss.close();
    }
}