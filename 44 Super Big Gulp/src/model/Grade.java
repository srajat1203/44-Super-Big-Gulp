package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GRADES database table.
 * 
 */
@Entity
@Table(name="GRADES", schema="TESTDB")
@NamedQuery(name="Grade.findAll", query="SELECT g FROM Grade g")
public class Grade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator (name = "GradeSeq", sequenceName = "GRADES_SEQ", allocationSize = 1, initialValue = 1)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "GradeSeq")
	private long gid;

	private String assignment;

	private int grade;

	public Grade() {
	}

	public long getGid() {
		return this.gid;
	}

	public void setGid(long gid) {
		this.gid = gid;
	}

	public String getAssignment() {
		return this.assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int g) {
		this.grade = g;
	}

}