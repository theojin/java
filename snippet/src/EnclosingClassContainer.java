import java.util.LinkedList;

public class EnclosingClassContainer {
    LinkedList<InnerClassItem> list;

    {
        list = new LinkedList<>();
    }

    void add(int id, String name, String property) {
        list.add(new InnerClassItem(id, name, property));
    }

    void remove(int id) {
        for (InnerClassItem item : list)
            if (item.id == id) list.remove(item);
    }

    InnerClassItem get(int id) {
        for (InnerClassItem item : list)
            if (item.id == id) return item;

        return null;
    }

    public class InnerClassItem {
        int id;
        String name;
        String property;

        InnerClassItem(int id, String name, String property) {
            this.id = id;
            this.name = name;
            this.property = property;
        }

        int getId() {
            return this.id;
        }

        String getName() {
            return this.name;
        }

        String getProperty() {
            return this.property;
        }
    }
}