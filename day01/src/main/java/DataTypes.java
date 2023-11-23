public class DataTypes {
    public static void main(String[] args) {
        var name = "Sam";
        //name = 12; //Possible in JavaScript; But you cannot change the type in Java

        var age = 12; //compile-time gimmick in Java; Helps you avoid few keystrokes; the datatype is still static
        //age = "Ram"; //Cannot change the datatype


        //Two categories of Data types in Java
        //Primitive and Reference types
        int i = 10;
        boolean b = false;
        double d = 3.14d;
        float f = 12.34f;
        long l = 1212121L;
        char ch = 'A';
        byte by = 12;

        //Reference types
        Object obj = new Object();
        Integer iObj = 10;
        Boolean bObj = true;
        Double dObj = 12d;
        Character letter = 'B';
        Float flObj = 12.3f;
        Long lObj = 122332323L;
        //Integer, Boolean, Long, Double, Character, Float are known as Wrapper classes
    }
}
