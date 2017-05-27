package pl.tecna.test.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

@Entity
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy="name")
	private List<Student> students;
	
	@Id
	@Column(name = "group_id")
	private String name;

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}
}