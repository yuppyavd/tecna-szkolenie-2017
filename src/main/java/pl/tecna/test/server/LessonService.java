package pl.tecna.test.server;

import java.util.Date;
import java.util.List;

import com.google.inject.ImplementedBy;

import pl.tecna.test.domain.Lesson;


@ImplementedBy(LessonServiceImpl.class)
public interface LessonService {

	Lesson create(String name, Date date);
	
	void remove(String name);
	
	Lesson get(String name);
	
	List<Lesson> getList();
	
	List<Lesson> getByDate(Date date);
}