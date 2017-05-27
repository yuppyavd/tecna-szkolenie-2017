package pl.tecna.test.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ClassEntity {
	@Id
    @Column(nullable=false)
	private String groupId;
	
	@OneToMany(mappedBy = "pesel")
	private List<StudentEntity> studentsInGroup;

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public List<StudentEntity> getStudentsInGroup() {
		return studentsInGroup;
	}

	public void setStudentsInGroup(List<StudentEntity> studentsInGroup) {
		this.studentsInGroup = studentsInGroup;
	}
}
