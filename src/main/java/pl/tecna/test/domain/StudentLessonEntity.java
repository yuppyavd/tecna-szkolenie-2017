package pl.tecna.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class StudentLessonEntity {
	@Id
	@Column(nullable=false)	
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	
	@ManyToOne(optional=false)
	private StudentEntity studentLesson;
	
	@ManyToOne(optional=false)
	private SubjectEntity subjectList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public StudentEntity getStudentLesson() {
		return studentLesson;
	}

	public void setStudentLesson(StudentEntity studentLesson) {
		this.studentLesson = studentLesson;
	}

	public SubjectEntity getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(SubjectEntity subjectList) {
		this.subjectList = subjectList;
	}	
	
	
}
