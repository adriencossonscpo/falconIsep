package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * A ETeacher.
 */
@Entity
@Table(name = "e_teacher")
public class ETeacher implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long etId;

    @OneToMany(mappedBy = "eTeacher")
    @JsonIgnore
    private Set<Form> forms = new HashSet<Form>();


    public ETeacher() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ETeacher(Set<Form> forms) {
		super();
		this.forms = forms;
	}

	public Long getEtId() {
		return etId;
	}

	public void setEtId(Long etId) {
		this.etId = etId;
	}

	public Set<Form> getForms() {
        return forms;
    }

    public ETeacher forms(Set<Form> forms) {
        this.forms = forms;
        return this;
    }

    public ETeacher addForm(Form form) {
        this.forms.add(form);
        form.setETeacher(this);
        return this;
    }

    public ETeacher removeForm(Form form) {
        this.forms.remove(form);
        form.setETeacher(null);
        return this;
    }

    public void setForms(Set<Form> forms) {
        this.forms = forms;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ETeacher eTeacher = (ETeacher) o;
        if (eTeacher.etId == null || etId == null) {
            return false;
        }
        return Objects.equals(etId, eTeacher.etId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(etId);
    }

    @Override
    public String toString() {
        return "ETeacher{" +
            "id=" + etId +
            ", etId='" + etId + "'" +
            '}';
    }
}
