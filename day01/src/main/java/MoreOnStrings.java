public class MoreOnStrings {
    public static void main(String[] args) {
        String name = "Daniel";
        String message = "%s is cool".formatted(name); //Introduced in java 17
        System.out.println(message);

        //Multi-line strings; Introduced in java 17
        String json = """
                {
                    "name": "Samuel",
                    "age" : 30
                }
                """;
        System.out.println(json);
        System.out.println(json.stripTrailing().stripLeading());

        String str = "something";

    }
}
