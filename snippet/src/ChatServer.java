import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ChatServer {
    public static void main(String[] args) {
        ServerSocket serverSocket;

        try {
            serverSocket = new ServerSocket(9000);

            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new ClientReceiver(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class ClientReceiver extends Thread {
        static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<PrintWriter>());
        Socket socket;
        PrintWriter writer;

        ClientReceiver(Socket socket) {
            this.socket = socket;

            try {
                writer = new PrintWriter(socket.getOutputStream());
                list.add(writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                while (true) {
                    String str = reader.readLine();
                    if (str == null) break;

                    for (PrintWriter writer : list) {
                        writer.println(str);
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                list.remove(writer);
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
