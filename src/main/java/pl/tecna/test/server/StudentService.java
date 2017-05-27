package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import com.google.inject.ImplementedBy;

import pl.tecna.test.domain.Group;
import pl.tecna.test.domain.Student;

@ImplementedBy(StudentServiceImpl.class)
public interface StudentService {

	Student create(String name, Group group);
	
	void remove(String name);
	
	Student get(String name);
	
	List<Student> getByGroup(String groupID);
	
	List<Student> getList();
	
	List<Student> getByLesson(String lessonName);
	
	List<Student> getByDate(Date date);
	
}