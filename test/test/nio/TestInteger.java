package test.nio;

public class TestInteger {
	
	public static void main(String[] args) {
		
		int i3 = 127;
		Integer i1 = new Integer(22);
		Integer i2 = 127;
		Integer i5 = 127;
		Integer i6 = Integer.valueOf("22");
		Integer i4 = new Integer(127);
		
//		System.out.println("i1:"+i1.hashCode());
//		System.out.println("i2:"+i2.hashCode());
//		System.out.println("i5:"+i5.hashCode());
//		System.out.println("i5:"+i5.hashCode());
//		System.out.println(i2 == i1);
		System.out.println(i6 == i2);
		System.out.println(i1 == i4);
		
		System.out.println(i3 == i2);
		System.out.println(i3 == i1);
		
		System.out.println(i5 == i1);
		System.out.println(":" + (i2 == i5));
		
		System.out.println(i1 == i2);
		
		System.out.println(i1 == i4);
		
	}

}
