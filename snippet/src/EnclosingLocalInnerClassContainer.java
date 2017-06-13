import java.util.HashMap;

public class EnclosingLocalInnerClassContainer {
    public static void main(String args[]) {
        class LocalInnerClassItem {
            int id;
            String name;

            LocalInnerClassItem(int id, String name) {
                this.id = id;
                this.name = name;
            }
        }

        HashMap<String, LocalInnerClassItem> map = new HashMap<>();
        map.put("1", new LocalInnerClassItem(1, "A"));
        map.put("2", new LocalInnerClassItem(2, "B"));
        map.put("3", new LocalInnerClassItem(3, "C"));

        LocalInnerClassItem item = (LocalInnerClassItem) map.remove("1");
        System.out.printf("%d : %s", item.id, item.name);
    }
}
