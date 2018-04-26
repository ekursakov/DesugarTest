package ek.desugartest;

interface A {

    void action1();
}

interface B {

    void action2();
}

interface Action<T> {

    void run(T object);
}

class Test {

    public static <T extends A & B> void method(T object) {
        method(object, A::action1); // works
        //method(object, B::action2); // java.lang.invoke.LambdaConversionException: Invalid receiver type interface ek.desugartest.A; not a subtype of implementation type interface ek.desugartest.B
        method(object, t -> t.action2()); // works
    }

    public static <T extends B> void method(T object) {
        method(object, B::action2); // works
    }

    public static <T> void method(T object, Action<T> action) {
        action.run(object);
    }
}