import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Frame {
    JFrame frame;
    Container container;

    JPanel panel;
    JTextField field;
    JButton button;

    Frame() {
        frame = new JFrame("JFrame");
        frame.setLocation(100, 100);
        frame.setPreferredSize(new Dimension(400, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        container = frame.getContentPane();
        container.setLayout(null);

        panel = new JPanel();
        panel.setLayout(new GridLayout(1,2));
        container.add(panel, BorderLayout.CENTER);

        field = new JTextField();
        panel.add(field);

        button = new JButton("Confirm");
        button.addActionListener(new ConfirmButtonActionListener(field));
        panel.add(button);

        frame.pack();
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public class ConfirmButtonActionListener implements ActionListener {
        JTextField field;

        ConfirmButtonActionListener(JTextField field) {
            this.field = field;
        }

        public void actionPerformed(ActionEvent e) {
            String name = field.getText();
            System.out.println(name);
        }
    }
}