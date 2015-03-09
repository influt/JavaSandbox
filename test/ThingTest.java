import org.junit.*;

public class ThingTest {

	private Thing thing;
	
	@Before
	public void setUp(){
		this.thing = new Thing();
	}
	
	@Test
	public void testDoStuff(){
		int result = thing.doStuff();
		Assert.assertEquals(1, result);
		result = thing.doStuff();
		Assert.assertEquals(2, result);
	}
	
}