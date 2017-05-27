package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.TypedQuery;

import org.apache.onami.persist.EntityManagerProvider;
import org.apache.onami.persist.Transactional;

import pl.tecna.test.domain.Group;
import pl.tecna.test.domain.Student;

@Transactional
public class StudentServiceImpl implements StudentService {
	
	@Inject
	private EntityManagerProvider em;

	@Override
	public Student create(String name, Group group) {
		Student entity = new Student();
		entity.setName(name);
		entity.setGroup(group);
		em.get().persist(entity);
		return entity;
	}

	@Override
	public void remove(String name) {
		Student temp = get(name);
		if(temp != null) em.get().remove(temp);
	}

	@Override
	public Student get(String name) {
		return em.get().find(Student.class, name);
	}

	@Override
	public List<Student> getByGroup(String groupID) {
		TypedQuery<Student> query = em.get().createQuery("SELECT s FROM Student s where s.group=:groupID", Student.class).setParameter("groupID", groupID);
		return query.getResultList();
	}

	@Override
	public List<Student> getList() {
		TypedQuery<Student> query = em.get().createQuery("SELECT s FROM Student s", Student.class);
		return query.getResultList();
	}
	
	@Override
	public List<Student> getByLesson(String lessonName) {
		TypedQuery<Student> query = em.get().createQuery("SELECT s FROM Student s where s.lesson=:lessonPar", Student.class).setParameter("lessonPar", lessonName);
		return query.getResultList();
	}
	@Override
	public List<Student> getByDate(Date date) {
		TypedQuery<Student> query = em.get().createQuery("SELECT s FROM Student s where s.date=:datePar", Student.class).setParameter("datePar", date);
		return query.getResultList();
	}
}
