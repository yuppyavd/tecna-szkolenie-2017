package pl.tecna.test.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

public class SubjectEntity {
	
	@Id
	@Column(nullable=false)	
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int lessonId;
	
	private Date constantLessonDate;
	
	@OneToMany(mappedBy = "id")
	private List<StudentLessonEntity> studentLesson;

	public int getLessonId() {
		return lessonId;
	}

	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}

	public Date getConstantLessonDate() {
		return constantLessonDate;
	}

	public void setConstantLessonDate(Date constantLessonDate) {
		this.constantLessonDate = constantLessonDate;
	}

	public List<StudentLessonEntity> getStudentLesson() {
		return studentLesson;
	}

	public void setStudentLesson(List<StudentLessonEntity> studentLesson) {
		this.studentLesson = studentLesson;
	}
	
	
}
