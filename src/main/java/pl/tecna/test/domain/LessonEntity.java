package pl.tecna.test.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class LessonEntity {
	@Id
	private int lessonId;
	@ManyToOne()
	private SubjectEntity subject;
	@Column
	private Date date;
	@OneToOne(mappedBy="lesson")
	private AttendanceListEntity attendanceList;
	
	
	
	
	public SubjectEntity getSubject() {
		return subject;
	}
	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public AttendanceListEntity getAttendanceList() {
		return attendanceList;
	}
	public void setAttendanceList(AttendanceListEntity attendanceList) {
		this.attendanceList = attendanceList;
	}
	public int getLessonId() {
		return lessonId;
	}
	
	
}
