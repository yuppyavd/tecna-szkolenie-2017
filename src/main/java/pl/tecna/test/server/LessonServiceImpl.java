package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Lesson;

@Transactional
public class LessonServiceImpl implements LessonService {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	public Lesson create(String name, Date date) {
		Lesson entity = new Lesson();
		entity.setName(name);
		entity.setDate(date);
		em.get().persist(entity);
		return entity;
	}

	@Override
	public void remove(String name) {
		Lesson temp = get(name);
		if(temp != null) em.get().remove(temp);
	}

	@Override
	public Lesson get(String name) {
		return em.get().find(Lesson.class, name);
	}

	@Override
	public List<Lesson> getList() {
		TypedQuery<Lesson> query = em.get().createQuery("SELECT l FROM Lesson l", Lesson.class);
		return query.getResultList();
	}
	
	@Override
	public List<Lesson> getByDate(Date date) {
		TypedQuery<Lesson> query = em.get().createQuery("SELECT l FROM Lesson l where l.date=:datePar", Lesson.class).setParameter("datePar", date);
		return query.getResultList();
	}
}
