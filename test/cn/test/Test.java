package cn.test;

public class Test {

	public static void main(String[] args)
    {
        Derived d = new Derived();
        System.out.println( d.whenAmISet );
//        Object
    }
}


 class Base
{
    Base() {
        preProcess();
    }
 
    void preProcess() {}
}

 class Derived extends Base
{
    public String whenAmISet = "set when declared";
 
    @Override void preProcess()
    {
        whenAmISet = "set in preProcess()";
    }
}

