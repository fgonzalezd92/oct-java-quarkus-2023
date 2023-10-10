public class Conditionals {
    public static void main(String[] args) {
        int i = 10;
        if (i % 2 == 0) {
            System.out.println("Even");
        } else if (i % 2 != 0) {
            System.out.println("Odd");
        }

        String message = i % 2 == 0 ? "Even" : "Odd";

        //This switch-case has changed drastically with Java 17; Will discuss later
        switch (i % 2) {
            case 0:
                message = "Even";
                break;
            case 1:
                message = "Odd";
                break;
            default:
                message = "I don't know what number this is";
        }
    }
}
