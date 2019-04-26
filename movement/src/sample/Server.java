package sample;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(20500)) {
            while (true) {
                Socket socket = serverSocket.accept();

                //DataInputStream in = new DataInputStream(socket.getInputStream());
                // so now we have connected to the client and are accepting information from the client
                //DataOutputStream out = new DataOutputStream(socket.getOutputStream());

                Runnable r = new Main(socket);
                Thread t = new Thread(r);
                t.start();
            }
        }
    }
}