
public class EnclosingStaticNestedClassContainer {
    StaticNestedClass property;

    EnclosingStaticNestedClassContainer(int id, String name) {
        property = new StaticNestedClass(id, name);
    }

    // EnclosingStaticNestedClassContainer.StaticNestedClass property = new EnclosingStaticNestedClassContainer.StaticNestedClass(id, name);
    public static class StaticNestedClass {
        int id;
        String name;

        StaticNestedClass(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
