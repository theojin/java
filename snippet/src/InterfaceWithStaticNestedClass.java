public interface InterfaceWithStaticNestedClass {
    StaticNestedClass getStaticNestedClass();
    void setStaticNestedClass(StaticNestedClass obj);

    public static class StaticNestedClass {
        int id;
        String name;

        StaticNestedClass(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}
