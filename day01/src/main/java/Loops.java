public class Loops {
    public static void main(String[] args) {

        //WE DON'T USE loops like this in modern day programming; WILL discuss later
        for(String arg : args) { //foreach
            System.out.println(arg);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }

        int count = 0;
        while (count < 5) {
            System.out.println(count);
            count++;
        }

        do {
            System.out.println(count);
            count++;
        } while (count < 10);
    }
}
