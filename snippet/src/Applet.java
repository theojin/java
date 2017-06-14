import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Applet extends JApplet {
    Container container;
    Socket socket;

    public void init() {
        try {
            socket = new Socket("###.###.###.###", 9000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextArea textArea = new TextArea();

        container = this.getContentPane();
        container.add(new JScrollPane(textArea));

        Thread thread = new ReceiverThread(textArea, socket);
        thread.start();
    }

    public void start() {

    }

    public void stop() {

    }

    public void destroy() {

    }

    public static class ReceiverThread extends Thread {
        TextArea textArea;
        Socket socket;

        ReceiverThread(TextArea textArea, Socket socket) {
            this.textArea = textArea;
            this.socket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                while (true) {
                    String str = reader.readLine();
                    SwingUtilities.invokeLater(
                            new Runnable() {
                                public void run() {
                                    textArea.append(str + "\n");
                                }
                            }
                    );
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
