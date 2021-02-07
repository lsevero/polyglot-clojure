package polyglot.java;

public class JavaExample
{
    String name = "";

    public JavaExample(String name){
        this.name = name;
    }

    public void objSayHello(){
        System.out.println("Hello from java " + this.name + "!!");
    }

    public static void staticSayHello(){
        System.out.println("Hello from java unknown person!!!");
    }
}
