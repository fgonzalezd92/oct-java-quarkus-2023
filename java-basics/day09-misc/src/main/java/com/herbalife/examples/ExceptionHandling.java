package com.herbalife.examples;

public class ExceptionHandling {
    static boolean switchPosition = false;
    public static void main(String[] args) throws Exception {
        //try, catch, finally, throw, throws(Not present in C#)
        //java.lang.Exception is the base class for all exceptions

        //There are two types of exceptions: checked and unchecked
        //Checked exception is a type of exception that must be either caught or declared in the method in which it is thrown
        //Examples of Checked Exceptions: IOException, SQLException, ClassNotFoundException
        //Checked Exceptions are classes that extend java.lang.Exception

        //Unchecked exception is a type of exception that doesn't need to be caught or declared in the method in which it is thrown
        //Examples of Unchecked Exceptions: ArithmeticException, NullPointerException, ArrayIndexOutOfBoundsException, IllegalArgumentException
        //Unchecked Exceptions are classes that extend java.lang.RuntimeException
        turnOnSwitch();
//        try{
//            turnOffSwitch();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        turnOffSwitch();
    }
    static void turnOnSwitch() {
        if(switchPosition)
            throw new SwitchAlreadyOnException("Switch is already on");
        switchPosition = true;
    }

    static void turnOffSwitch() throws Exception {
//        try {
//            if(!switchPosition)
//                throw new Exception("Switch is already off");
//            switchPosition = false;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        if(!switchPosition)
            throw new Exception("Switch is already off");
        switchPosition = false;
    }
}
class SwitchAlreadyOnException extends RuntimeException {
    public SwitchAlreadyOnException(String message) {
        super(message);
    }
}
