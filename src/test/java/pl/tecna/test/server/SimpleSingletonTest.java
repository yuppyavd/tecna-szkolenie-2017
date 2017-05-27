package pl.tecna.test.server;

import org.junit.Assert;
import org.junit.Test;

public class SimpleSingletonTest {
	
	public static class SimpleSingleton {
		private static SimpleSingleton instance = new SimpleSingleton();
		
		public static SimpleSingleton getInstance() {
			return instance;
	}
	
	@Test
	public void testIsSingleton() {
		SimpleSingleton s1 = SimpleSingleton.getInstance();
		SimpleSingleton s2 = SimpleSingleton.getInstance();
		
		Assert.assertEquals(s1, s2);
	}
}
}
