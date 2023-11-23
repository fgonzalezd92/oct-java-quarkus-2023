package com.herbalife.examples;

import java.sql.Connection;

public class DisposableExample {
    public static void main(String[] args) {
        DBResource dbResource = new DBResource();
        dbResource.cleanup(); //This is not guaranteed to be called
        try(FileResource fileResource = new FileResource()) {// Similar to using(FileResource fileResource = new FileResource()) in C#
            //Use fileResource
        }
        System.out.println("End of main");

//        try(Connection connection = DBConnection.getConnection()) {
//            //Use connection
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        //ERROR: DBResource is not AutoCloseable
//        try(DBResource dbResource1 = new DBResource()) {
//            //Use dbResource1
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}

class FileResource implements AutoCloseable { //Similar to IDisposable in C#
    public FileResource() {
        System.out.println("FileResource constructor");
    }
    public void close() { //Similar to Dispose() in C#
        System.out.println("FileResource cleanup");
    }
}

class DBResource {
    public DBResource() {
        System.out.println("DBResource constructor");
    }
    public void cleanup() {
        System.out.println("DBResource cleanup");
    }
    //No destructor in Java
    //Older versions had finalize() method, but it was deprecated in Java 9
}
