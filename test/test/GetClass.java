package test;

public class GetClass extends Fu {
	
	public void ClassN(){
		super.ClassName();
		
		this.getClass().getName();
	}
	
	
	public static void main(String[] args) {
		new GetClass().ClassN();
//		Object
	}
	

}

class Fu{
	
	
	
	public Fu() {
		super();
		ClassName();
	}

	public void ClassName(){
		
		System.out.println(this.getClass().getName());
	}
	
	
}