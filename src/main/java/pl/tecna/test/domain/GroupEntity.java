package pl.tecna.test.domain;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class GroupEntity {
	@Id
	private int groupId;
	@Column
	private String name;
	@OneToMany(mappedBy="group")
	private List<StudentEntity> students;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<StudentEntity> getStudents() {
		return students;
	}
	public void setStudents(List<StudentEntity> students) {
		this.students = students;
	}
	public int getGroupId() {
		return groupId;
	}
}
