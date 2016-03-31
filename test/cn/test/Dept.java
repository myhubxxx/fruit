package cn.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class Dept {

	private	Long id;
	private	String name;
	private	Set<String> employees = new HashSet<String>();
	private	Dept parent;
	private	Set<String> children = new HashSet<String>();
	
	
	@Test
	public void Test1(){
		
		List<String> list = new ArrayList<String>();
		list.add("liudehua");
	    list.add("madehua");
	    list.add("liushishi");
	    list.add("tangwei");
		for (Iterator it = list.iterator(); it.hasNext(); ) {
			String s = (String) it.next();
			if(s.equals("tangwei")) list.remove(s);
		}
		
		System.out.println(list);
		
	}
	@Test
	public void test2() {  
        int k = 0;  
        int ret = ++k + k++ + ++k + k;  
        // ret的值为多少  
        System.err.println(ret);  
    } 
	@Test
	public void test3(){
		int i1 = 10, i2 = 10;  
        System.err.println("i1 + i2 = " + i1 + i2);  
//        System.err.println("i1 - i2 = " + i1 - i2);  
        System.err.println("i1 * i2 = " + i1 * i2);  
        System.err.println("i1 / i2 = " + i1 / i2);  
	}
	
	      
	    public void myMethod(Object obj) {  
	        System.err.println("object");  
	    }  
	    public void myMethod(Dept dept) { 
	    	
	    	System.out.println("string");  
	    }  
	    @Test 
	    public  void test4() {  
	        Dept t = new Dept();  
	        t.myMethod(null);  
	    }  
	    @Test
	    public void test5(){
	    	Date date = new Date();
	    	System.out.println(date);
	        System.err.println(date.getMonth() + " " + date.getDate());  
	    }
	
}
