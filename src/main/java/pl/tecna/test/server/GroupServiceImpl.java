package pl.tecna.test.server;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Group;

@Transactional
public class GroupServiceImpl implements GroupService {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	public Group create(String name) {
		Group entity = new Group();
		entity.setName(name);
		em.get().persist(entity);	
		return entity;
	}

	@Override
	public void remove(String groupID) {
		Group temp = get(groupID);
		if(temp != null) em.get().remove(temp);
	}

	@Override
	public Group get(String groupID) {
		return em.get().find(Group.class, groupID);
	}

	@Override
	public List<Group> getList() {
		TypedQuery<Group> query = em.get().createQuery("SELECT g FROM Group g", Group.class);
		return query.getResultList();
	}
}
