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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A Classe.
 */
@Entity
@Table(name = "classe")
public class Classe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long classeId;

    

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "classe")
    @JsonIgnore
    private Set<Evaluation> evaluations = new HashSet<Evaluation>();

    @ManyToMany(mappedBy = "classes")
    @JsonIgnore
    private Set<UserAvis> userAvis = new HashSet<UserAvis>();

    

    public Classe(String name, Set<Evaluation> evaluations, Set<UserAvis> userAvis) {
		super();
		this.name = name;
		this.evaluations = evaluations;
		this.userAvis = userAvis;
	}

	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getClasseId() {
		return classeId;
	}

	public void setClasseId(Long classeId) {
		this.classeId = classeId;
	}

	public String getName() {
        return name;
    }

    public Classe name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Evaluation> getEvaluations() {
        return evaluations;
    }

    public Classe evaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
        return this;
    }

    public Classe addEvaluation(Evaluation evaluation) {
        this.evaluations.add(evaluation);
        evaluation.setClasse(this);
        return this;
    }

    public Classe removeEvaluation(Evaluation evaluation) {
        this.evaluations.remove(evaluation);
        evaluation.setClasse(null);
        return this;
    }

    public void setEvaluations(Set<Evaluation> evaluations) {
        this.evaluations = evaluations;
    }

    public Set<UserAvis> getUserAvis() {
        return userAvis;
    }

    public Classe userAvis(Set<UserAvis> userAvis) {
        this.userAvis = userAvis;
        return this;
    }

    public Classe addUserAvis(UserAvis userAvis) {
        this.userAvis.add(userAvis);
        userAvis.getClasses().add(this);
        return this;
    }

    public Classe removeUserAvis(UserAvis userAvis) {
        this.userAvis.remove(userAvis);
        userAvis.getClasses().remove(this);
        return this;
    }

    public void setUserAvis(Set<UserAvis> userAvis) {
        this.userAvis = userAvis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Classe classe = (Classe) o;
        if (classe.classeId == null || classeId == null) {
            return false;
        }
        return Objects.equals(classeId, classe.classeId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(classeId);
    }

    @Override
    public String toString() {
        return "Classe{" +
            "id=" + classeId +
            ", classeId='" + classeId + "'" +
            ", name='" + name + "'" +
            '}';
    }
}
