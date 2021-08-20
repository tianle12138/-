public class Inherent {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(5);
       b.show(); a.show();
    }
}
class A{
    int a;
    void show(){
        System.out.println(a--);
    }
}
class B extends A {
    B(int a){this.a = a;}
    void show()
    {
        System.out.println(++a);
    }
}

