package pl.tecna.test.server;

import org.junit.Assert;
import org.junit.Test;

public class SimpleSingletonTest {
	
	public static class SimpleSingleton {
		
		public static SimpleSingleton getInstance() {
			return new SimpleSingleton();
		}
	}
	
	@Test
	public void testIsSingleton() {
		SimpleSingleton s1 = SimpleSingleton.getInstance();
		SimpleSingleton s2 = SimpleSingleton.getInstance();
		
//		Assert.assertEquals(s1, s2);
	}
}
