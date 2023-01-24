package PP_4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5555);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new ServerThread(socket)).start();
        }
    }
}

