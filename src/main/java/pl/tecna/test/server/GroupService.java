package pl.tecna.test.server;

import java.util.List;

import com.google.inject.ImplementedBy;

import pl.tecna.test.domain.Group;


@ImplementedBy(GroupServiceImpl.class)
public interface GroupService {

	Group create(String groupID);
	
	void remove(String groupID);
	
	Group get(String groupID);
	
	List<Group> getList();
}