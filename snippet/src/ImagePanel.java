import java.awt.*;
import javax.swing.*;

public class ImagePanel extends JPanel {
    String filename;
    Toolkit toolkit = this.getToolkit();
    Image image = toolkit.getImage(filename);

    ImagePanel(String filename) {
        this.filename = filename;
    }

    public void paint(Graphics g) {
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        if (image != null) g.drawImage(image, 0, 0, this);
    }
}