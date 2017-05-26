package pl.tecna.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class StudentEntity {
	
	@Id
	private int studentId;
	@Column
	private String name;
	@ManyToOne()
	private GroupEntity group;
	@ManyToMany(targetEntity=SubjectEntity.class)
	private List<SubjectEntity> assignedSubjects;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GroupEntity getGroup() {
		return group;
	}
	public void setGroup(GroupEntity group) {
		this.group = group;
	}
	public List<SubjectEntity> getAssignedSubjects() {
		return assignedSubjects;
	}
	public void setAssignedSubjects(List<SubjectEntity> assignedSubjects) {
		this.assignedSubjects = assignedSubjects;
	}
	public int getStudentId() {
		return studentId;
	}
	
	
}
