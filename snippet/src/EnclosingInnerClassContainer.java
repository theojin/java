import java.util.LinkedList;

public class EnclosingInnerClassContainer {
    LinkedList<InnerClassItem> list;
    static int lastId = 0;

    {
        list = new LinkedList<>();
    }

    void add(int id, String name, String property) {
        list.add(new InnerClassItem(name, property));
        lastId++;
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

    // EnclosingInnerClassContainer.InnerClassItem item = container.new InnerClassItem(name, property);
    public class InnerClassItem {
        int id;
        String name;
        String property;

        InnerClassItem(String name, String property) {
            this.id = lastId;
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