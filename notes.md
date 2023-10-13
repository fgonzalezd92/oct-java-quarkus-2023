## Java through .NET lens

* .NET SDK - **JDK**
* C#, F#, VB.NET - **Java, Groovy, Scala, Kotlin**
* CSC - **javac**
* IL - **Bytecodes**
* CLR - **JVM**
* Visual Studio - **Eclipse, IntelliJ, VS Code**

## JDK

* https://www.oracle.com/in/java/technologies/downloads/
* **java -version**
* Before version 8 (0r 1.8) and after 8(Or 1.8)

## Day 01

* Data types; Primitive and Reference types
* Primitive types are stored in the stack; Reference types are stored on the heap
* Wrapper classes used to box primitive types; Integer, Double, Byte, Long, Boolean
* Strings; Immutable; Stored in the string pool; There is an implicit object created to refer to the literal in the pool
* Everytime you change the value, a new literal thereby a new object is created
* If you want to manipulate strings, use StringBuilder 
* Two ways of creating strings; with/without using new keyword;
* Use **.equals** to compare the values of the string
* foreach, for, while, do-while
* if-else, ?:, switch-case

## Day 02

* OO concepts; 
* Java beans; POJO with no-arg constructor, private variables; public getter/setter methods
* extends, super, for inheritance;
* redefine the base class method with the same signature in the derived class is considered **overriding**
* private, static, final(sealed) methods; final(sealed) classes cannot be extended
* abstract;
* Inner classes; can access private members of outer class; you can create an instance of inner class only using outer class object;
* Compiler generates Outer$Inner.class files

## Day 03

* interfaces; **implements** keyword to inherit interfaces
* can have constants; abstract methods; default methods and also static methods
* record, enum;
* packages: physical grouping of folders and files
* by default the access specifier for an entity is package-friendly;
* java.util: List, Set, Map; java.io, java.nio,java.net, java.sql









 