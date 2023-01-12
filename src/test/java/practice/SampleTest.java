package practice;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class SampleTest {
	
	@Test
	public void sampleTest()
	{
		Reporter.log("Hello",true);
	}
}
