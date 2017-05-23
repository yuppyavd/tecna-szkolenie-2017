package pl.tecna.test.server;

import com.google.inject.ImplementedBy;

import pl.tecna.test.domain.User;

@ImplementedBy(UserBeanImpl.class)
public interface UserBean {

	User create(String login);
}
