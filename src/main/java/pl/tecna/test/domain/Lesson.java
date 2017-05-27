package pl.tecna.test.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Lesson implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToMany
	private List<Student> students;
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
	
	@Column(name = "lesson_id")
	private String name;
	
	@Column(name = "lesson_date")
	private Date date;

	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
	public Date getDate()
	{
		return date;
	}
}
