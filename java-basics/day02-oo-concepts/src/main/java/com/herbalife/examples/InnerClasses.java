package com.herbalife.examples;

public class InnerClasses {
    public static void main(String[] args) {
        TV sony = new TV();
        sony.increaseVolume();

        //Inner classes can be instantiated only using Outer class objects
        TV.Remote sonyRemote = sony.new Remote(); //WEIRDO
        sonyRemote.increaseVolume();
        ;
        sonyRemote.decreaseVolume();
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
    }
}

class A {
    class B {
        class C {
            class D {
                class E {
                }
            }
        }
    }
}

class Grandpa {
    class Parent {
        class Child {

        }
    }
}

class Outer {
    class Inner {

    }
}

class TV {
    private int volume;

    public void increaseVolume() {
        volume++;
    }

    public void decreaseVolume() {
        volume--;
    }

    class Remote {
        public void increaseVolume() {
            volume++;
        }

        public void decreaseVolume() {
            volume--;
        }
    }
}
