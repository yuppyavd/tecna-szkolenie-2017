package pl.tecna.test.server;

import javax.inject.Inject;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.User;

public class UserBeanImpl implements UserBean {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	@Transactional
	public User create(String login) {
		User entity = new User();
		entity.setLogin(login);
		em.get().persist(entity);
		
		return entity;
	}

}
