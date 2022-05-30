import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String[] args) {
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            String request = in.readLine();
            out.println(String.format("Hi, your request is '%s', your port is %d", request, clientSocket.getPort()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
