package myproj;

public class Thing {

	private int someVar = 0;

	public int doStuff(){
		System.out.println("doing stuff..");
		this.someVar++;
		System.out.println("done!");
		return this.someVar;
	}

}