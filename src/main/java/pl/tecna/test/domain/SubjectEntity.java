package pl.tecna.test.domain;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class SubjectEntity {
	@Id
	private int lessonId;
	@Column
	private String name;
	@ManyToMany(targetEntity=StudentEntity.class)
	private List<StudentEntity> participants;
	@OneToMany(mappedBy="lesson")
	private List<AttendanceListEntity> attendanceLists;
	@OneToMany(mappedBy="subject")
	private List<LessonEntity> lessonList;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<StudentEntity> getParticipants() {
		return participants;
	}
	public void setParticipants(List<StudentEntity> participants) {
		this.participants = participants;
	}
	public List<AttendanceListEntity> getAttendanceLists() {
		return attendanceLists;
	}
	public void setAttendanceLists(List<AttendanceListEntity> attendanceLists) {
		this.attendanceLists = attendanceLists;
	}
	public List<LessonEntity> getLessonList() {
		return lessonList;
	}
	public void setLessonList(List<LessonEntity> lessonList) {
		this.lessonList = lessonList;
	}
	public int getLessonId() {
		return lessonId;
	}
	
	
}
