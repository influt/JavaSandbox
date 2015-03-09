package myproj;

import org.junit.Assert;
import org.junit.Test;
import junit.framework.TestCase;

public class ThingTest extends TestCase{

	private Thing thing;

	public void setUp(){
		this.thing = new Thing();
	}
	
	public void testDoStuff(){
		int result = thing.doStuff();
		Assert.assertEquals(1, result);
		result = thing.doStuff();
		Assert.assertEquals(2, result);
	}
	
}