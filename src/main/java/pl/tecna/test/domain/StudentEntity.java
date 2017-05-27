package pl.tecna.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class StudentEntity {
	@Id
    @Column(nullable=false)	
	private String pesel;
	
	private String name;
	
	private String surname;
	
	@ManyToOne(optional=false)
	private String group;
	
	@OneToMany(mappedBy = "id")
	private List<StudentLessonEntity> studentLessons;

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	public List<StudentLessonEntity> getStudentLessons() {
		return studentLessons;
	}

	public void setStudentLessons(List<StudentLessonEntity> studentLessons) {
		this.studentLessons = studentLessons;
	}
	
}
