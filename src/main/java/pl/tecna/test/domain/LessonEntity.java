package pl.tecna.test.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class LessonEntity {
	@Id
	@Column(nullable=false)	
	@GeneratedValue(strategy = GenerationType.AUTO) 
	private int id;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date subjectDate;
	
	@ManyToOne(optional=false)
	private SubjectEntity subject;
	
	@OneToMany(mappedBy = "pesel")
	private List<StudentEntity> activeStudent;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getSubjectDate() {
		return subjectDate;
	}

	public void setSubjectDate(Date subjectDate) {
		this.subjectDate = subjectDate;
	}

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public List<StudentEntity> getActiveStudent() {
		return activeStudent;
	}

	public void setActiveStudent(List<StudentEntity> activeStudent) {
		this.activeStudent = activeStudent;
	}
}
