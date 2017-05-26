package pl.tecna.test.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
public class AttendanceListEntity {
	@Id
	private int attendanceListId;
	@OneToOne(mappedBy = "attendanceList")
	private LessonEntity lesson;
	@ManyToMany(targetEntity=StudentEntity.class)
	private List<StudentEntity> students;
	
	public int getAttendanceListId() {
		return attendanceListId;
	}
	
	public LessonEntity getLesson() {
		return lesson;
	}
	
	public void setLesson(LessonEntity lesson) {
		this.lesson = lesson;
	}
	
	public List<StudentEntity> getStudents() {
		return students;
	}
	
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
}
