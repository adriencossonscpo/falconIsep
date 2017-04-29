package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * A Student.
 */
@Entity
@Table(name = "student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long stId;

    @Column(name = "promo")
    private Integer promo;


    public Student(Integer promo) {
		super();
		this.promo = promo;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getStId() {
		return stId;
	}

	public void setStId(Long stId) {
		this.stId = stId;
	}

	public Integer getPromo() {
        return promo;
    }

    public Student promo(Integer promo) {
        this.promo = promo;
        return this;
    }

    public void setPromo(Integer promo) {
        this.promo = promo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        if (student.stId == null || stId == null) {
            return false;
        }
        return Objects.equals(stId, student.stId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stId);
    }

    @Override
    public String toString() {
        return "Student{" +
            "id=" + stId +
            ", promo='" + promo + "'" +
            ", stId='" + stId + "'" +
            '}';
    }
}
