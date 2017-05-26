package pl.tecna.test.server;

import javax.inject.Inject;

import org.jukito.JukitoModule;
import org.jukito.JukitoRunner;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Injector;
import com.google.inject.Singleton;

@RunWith(JukitoRunner.class)
public class GuiceSingletonTest {
	
	public static class Module extends JukitoModule {
		
		@Override
		protected void configureTest() {
			bind(GuiceSingleton.class);
		}
	}
	@Singleton
	public static class GuiceSingleton {
		
	}
	
	@Inject
	private Injector injector;
	
	@Test
	public void testIsSingleton() {
		GuiceSingleton s1 = injector.getInstance(GuiceSingleton.class);
		GuiceSingleton s2 = injector.getInstance(GuiceSingleton.class);
		
		Assert.assertEquals(s1, s2);
	}
}
