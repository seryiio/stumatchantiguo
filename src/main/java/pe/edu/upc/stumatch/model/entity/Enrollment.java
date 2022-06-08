package pe.edu.upc.stumatch.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name="enrollments", 
indexes = {@Index(columnList = "type", name = "enrollments_index_type")})
public class Enrollment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "enrollment_id")
	private Integer id;
	
	@Column(name = "type", length = 35, nullable = false)
	private String type;
	
	@Max(02)
	@Min(00)
	@Column(name = "number_cycle", columnDefinition = "NUMERIC(2)", nullable = false)
	private Integer numberCycle;
	
	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@Column(name = "end_date")
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	@OneToMany(mappedBy = "enrollment")
	private List<Student> students;
	
	@OneToMany(mappedBy = "enrollment")
	private List<Section> sections;
	
	public Enrollment() {
		students = new ArrayList<>();
		sections = new ArrayList<>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getNumberCycle() {
		return numberCycle;
	}

	public void setNumberCycle(int numberCycle) {
		this.numberCycle = numberCycle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Section> getSections() {
		return sections;
	}

	public void setSections(List<Section> sections) {
		this.sections = sections;
	}

}
