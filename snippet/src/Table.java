import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Table {
    String[] columnNames = {"ID", "Name", "E-mail"};;
    DefaultTableModel model;
    JTable table;

    Table() {
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
    }

    public JTable getTable() {
        return table;
    }

    void add(int id, String name, String email) {
        Object[] row = new Object[3];
        row[0] = id;
        row[1] = name;
        row[2] = email;
        model.addRow(row);
    }

    void remove(int row) {
        model.removeRow(row);
    }
}
