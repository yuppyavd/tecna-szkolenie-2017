package pl.tecna.test.server;

import org.apache.onami.persist.PersistenceFilter;
import org.apache.onami.persist.PersistenceModule;

import pl.tecna.test.client.GreetingService;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;

public class GuiceServletConfig extends GuiceServletContextListener {

	public static class MappingServletModule extends ServletModule {

		@Override
		protected void configureServlets() {
			serve("/gwt-rpc").with(GuiceRemoteServiceServlet.class);

			filter("/*").through(PersistenceFilter.class);

			bind(GreetingService.class).to(GreetingServiceImpl.class);
		}
	}

	public static class DatabaseModule extends PersistenceModule {

		@Override
		protected void configurePersistence() {
			bindApplicationManagedPersistenceUnit("manager");
		}
	}

	@Override
	protected Injector getInjector() {
		return Guice.createInjector(new MappingServletModule(),
				new DatabaseModule());
	}

}
