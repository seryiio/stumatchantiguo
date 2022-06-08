package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "careers")
public class Career {
	@Id
	@Column(name = "career_id", length = 8, nullable = false)
	private String id;
	
	@Column(name = "name", length = 80)
	private String name;
	
	@OneToMany(mappedBy = "career")
	private List<Student> students;
	
	@OneToMany(mappedBy = "career")
	private List<Teacher> teachers;
	
	public Career() {
		students = new ArrayList<>();
		teachers = new ArrayList<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	
	
}
