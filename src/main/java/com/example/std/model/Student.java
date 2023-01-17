package com.example.std.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer stdId;
	
	private String stdName;
	private String stdCourse;
	private Double stdFee;
	
	public Integer getStdId() {
		return stdId;
	}
	public void setStdId(Integer stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdCourse() {
		return stdCourse;
	}
	public void setStdCourse(String stdCourse) {
		this.stdCourse = stdCourse;
	}
	public Double getStdFee() {
		return stdFee;
	}
	public void setStdFee(Double stdFee) {
		this.stdFee = stdFee;
	}
	@Override
	public String toString() {
		return "Student [stdId=" + stdId + ", stdName=" + stdName + ", stdCourse=" + stdCourse + ", stdFee=" + stdFee
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(stdCourse, stdFee, stdId, stdName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(stdCourse, other.stdCourse) && Objects.equals(stdFee, other.stdFee)
				&& Objects.equals(stdId, other.stdId) && Objects.equals(stdName, other.stdName);
	}
	public Student() {
		super();
	}
}
