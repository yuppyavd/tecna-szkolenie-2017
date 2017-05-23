package pl.tecna.test.server;

import javax.inject.Inject;

import org.apache.onami.persist.PersistenceService;
import org.jukito.JukitoRunner;
import org.jukito.UseModules;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import pl.tecna.test.domain.User;
import pl.tecna.test.server.GuiceServletConfig.DatabaseModule;

@RunWith(JukitoRunner.class)
@UseModules(DatabaseModule.class)
public class UserBeanImplTest {
	
	@Inject
	private UserBeanImpl bean;
	
	@Inject
	private PersistenceService persistenceService;
	
	@Before
	public void setUp() {
		persistenceService.start();
	}
	
	@After
	public void tearDown() {
		persistenceService.stop();
	}

	@Test
	public void createTest() {
		// when
		User user = bean.create("test");
		
		// then
		Assert.assertNotNull(user);
		Assert.assertEquals("test", user.getLogin());
	}
}
