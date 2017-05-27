package pl.tecna.test.domain;


import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
public class Student implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	private Group group;
	
	@ManyToMany
	private List<Lesson> lessons;

	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@Column(name = "student_name")
	private String name;

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setGroup(Group group)
	{
		this.group = group;
	}
	public Group getGroup()
	{
		return group;
	}
	public String toString()
	{
		return "Uczeń: " + name + ", grupa: " + group + ", identyfikator: " + id;
	}
}
