package cn.test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
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
	    
	    @Test
	    public void test6(){
	    	  double val = 11.5;  
	          System.err.println(Math.round(val));  
	          System.err.println(Math.floor(val));  
	          System.err.println(Math.ceil(val));  
	      }  
	    @Test
	    public void test7(){
	    	new Dept().listDirectory("D:/UltraEdit","");
	    }
	    public void listDirectory(String path, String tab){
	    	File file = new File(path);
	    	File[] directory = file.listFiles();
	    	for (File file2 : directory) {
				System.out.println(tab + file2.getName());
				if(file2.isDirectory())
					listDirectory(file2.getPath(), tab + "\t");
			}
	    	
	    }
	    @Test
	    public void test8(){
	    	 Scanner in = new Scanner(System.in);  
	         // 注意这里的数组，不是int的  
	         Integer[] arr = new Integer[10];  
	         for (int i = 0; i < 10; i++) {  
	             arr[i] = in.nextInt();  
	         }  
	         Arrays.sort(arr, new Comparator<Integer>() {  
	             @Override  
	             public int compare(Integer o1, Integer o2) {  
	                 if (o1 < o2) return -1;  
	                 if (o1 > o2) return 1;  
	                 return 0;  
	             }  
	               
	         });  
	         System.err.println(Arrays.toString(arr));  
	    }
}
