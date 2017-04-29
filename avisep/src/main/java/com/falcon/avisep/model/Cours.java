package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Cours.
 */
@Entity
@Table(name = "cours")
public class Cours implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long coursId;

    @Column(name = "c_date")
    private String cDate;

    @Column(name = "number_of_courses")
    private Integer numberOfCourses;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private Set<Evaluation> evaluations = new HashSet<Evaluation>();

    @OneToMany(mappedBy = "cours")
    @JsonIgnore
    private Set<Salle> salles = new HashSet<Salle>();

    @ManyToOne
    private Module module;


    public Cours() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cours(String cDate, Integer numberOfCourses, String description, Set<Evaluation> evaluations,
			Set<Salle> salles, Module module) {
		super();
		this.cDate = cDate;
		this.numberOfCourses = numberOfCourses;
		this.description = description;
		this.evaluations = evaluations;
		this.salles = salles;
		this.module = module;
	}

	public Long getCoursId() {
		return coursId;
	}

	public void setCoursId(Long coursId) {
		this.coursId = coursId;
	}

	public String getcDate() {
        return cDate;
    }

    public Cours cDate(String cDate) {
        this.cDate = cDate;
        return this;
    }

    public void setcDate(String cDate) {
        this.cDate = cDate;
    }

    public Integer getNumberOfCourses() {
        return numberOfCourses;
    }

    public Cours numberOfCourses(Integer numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
        return this;
    }

    public void setNumberOfCourses(Integer numberOfCourses) {
        this.numberOfCourses = numberOfCourses;
    }

    public String getDescription() {
        return description;
    }

    public Cours description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public Cours evaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
        return this;
    }

    public Cours addEvaluation(Evaluation evaluation) {
        this.evaluations.add(evaluation);
        evaluation.setCours(this);
        return this;
    }

    public Cours removeEvaluation(Evaluation evaluation) {
        this.evaluations.remove(evaluation);
        evaluation.setCours(null);
        return this;
    }

    public void setEvaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Set<Salle> getSalles() {
        return salles;
    }

    public Cours salles(Set<Salle> salles) {
        this.salles = salles;
        return this;
    }

    public Cours addSalle(Salle salle) {
        this.salles.add(salle);
        salle.setCours(this);
        return this;
    }

    public Cours removeSalle(Salle salle) {
        this.salles.remove(salle);
        salle.setCours(null);
        return this;
    }

    public void setSalles(Set<Salle> salles) {
        this.salles = salles;
    }

    public Module getModule() {
        return module;
    }

    public Cours module(Module module) {
        this.module = module;
        return this;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cours cours = (Cours) o;
        if (cours.coursId == null || coursId == null) {
            return false;
        }
        return Objects.equals(coursId, cours.coursId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(coursId);
    }

    @Override
    public String toString() {
        return "Cours{" +
            "id=" + coursId +
            ", coursId='" + coursId + "'" +
            ", cDate='" + cDate + "'" +
            ", numberOfCourses='" + numberOfCourses + "'" +
            ", description='" + description + "'" +
            '}';
    }
}
