public class StringComparison {
    public static void main(String[] args) {
        String name = "Sam";
        String firstName = "Sam";
        if(name == firstName) {
            System.out.println("name == firstName");
        }

        String myName = new String("Sam");
        if(name == myName) {
            System.out.println("name == myName");
        } else {
            System.out.println("name != myName");
        }

        //== compares the references
        //.equals compares the value
        if(name.equals(myName)) {
            System.out.println("name.equals(myName)");
        }
        //Stick to one way of creating strings in Java. Either use with new keyword or without new keyword
    }
}
