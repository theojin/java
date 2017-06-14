import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("###.###.###.###", 9000);

            Thread senderThread = new SenderThread(socket);
            senderThread.start();

            Thread receiverThread = new ReceiverThread(socket);
            receiverThread.start();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class SenderThread extends Thread {
        Socket socket;

        SenderThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PrintWriter writer = new PrintWriter(socket.getOutputStream());

                while (true) {
                    String str = reader.readLine();
                    if (str == null)
                        break;
                    writer.println(str);
                    writer.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class ReceiverThread extends Thread {
        Socket socket;

        ReceiverThread(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String str = reader.readLine();
                    if (str == null) break;
                    System.out.println(str);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
