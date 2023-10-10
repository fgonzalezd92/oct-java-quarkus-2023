public class Arrays {
    public static void main(String[] args) {
//        int[] numbers = {10, 20, 30};
//        String[] cities = new String[10];
//        int[] evenNumbers = null;

        int oddNumbers[] = {};
        oddNumbers[0] = 11; //ERROR
        int numbers[] = {10, 20, 30};
        String cities[] = new String[10];
        int evenNumbers[] = null;

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        int[][] matrix = new int[12][12];
        int[] matrixII[] = new int[12][]; //Syntactic sugar; Like sugar it's harmful
        int matrixIII[][] = new int[5][];

    }
}
