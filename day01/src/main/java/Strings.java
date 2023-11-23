public class Strings {
    public static void main(String[] args) {
        //Strings are reference types
        //String is immutable
        String lang = "Java";
        String name = "Sam";
        String firstName = "Sam";
        name = "Sam Thomas";
        firstName = "Samy";

        String message = "";
        for (int i = 0; i < 5000; i++) { //5000 objects are created
            message += i; //WRONG APPROACH TO MANIPULATE STRINGS
        }
        System.out.println(message);

        //Use StringBuilder if you want to manipulate strings; Use Strings as Constants
        StringBuilder messageBuilder = new StringBuilder("");
        for (int i = 0; i < 5000; i++) {
            messageBuilder.append(i);
        }
        System.out.println(messageBuilder.toString());
    }
}
