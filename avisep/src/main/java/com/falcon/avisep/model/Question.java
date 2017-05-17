package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GenerationType;



 
@javax.persistence.Entity 
public class Question implements Serializable
{
	private static final long serialVersionUID = 9073731474395915309L;

	@javax.persistence.Column 
	protected String options;
	 
	@javax.persistence.Column 
	protected Boolean isPertinent;
	 
	@javax.persistence.Column 
	protected String qTitle;
	 
	@javax.persistence.Column 
	protected String qType;
	 
	@javax.persistence.ManyToMany 
	protected Set<Form> form;

	@javax.persistence.OneToMany(mappedBy = "question", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Evaluation> evaluation;

	@javax.persistence.Id 
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	public Question(){
		super();
	}

	public Boolean getIsPertinent() {
		return this.isPertinent;
	}


	public String getqTitle() {
		return qTitle;
	}

	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}

	public String getQType() {
		return this.qType;
	}

	public String getOptions() {
		return options;
	}

	public void setOptions(String options) {
		this.options = options;
	}

	public Set<Form> getForm() {
		if(this.form == null) {
				this.form = new HashSet<Form>();
		}
		return (Set<Form>) this.form;
	}

	public Set<Evaluation> getEvaluation() {
		if(this.evaluation == null) {
				this.evaluation = new HashSet<Evaluation>();
		}
		return (Set<Evaluation>) this.evaluation;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addAllForm(Set<Form> newForm) {
		if (this.form == null) {
			this.form = new HashSet<Form>();
		}
		for (Form tmp : newForm)
			tmp.addQuestion(this);
		
	}
	public void addAllEvaluation(Set<Evaluation> newEvaluation) {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		for (Evaluation tmp : newEvaluation)
			tmp.setQuestion(this);
		
	}
	public void removeAllForm(Set<Form> newForm) {
		if(this.form == null) {
			return;
		}
		
		this.form.removeAll(newForm);
	}

	public void removeAllEvaluation(Set<Evaluation> newEvaluation) {
		if(this.evaluation == null) {
			return;
		}
		
		this.evaluation.removeAll(newEvaluation);
	}

	public void setIsPertinent(Boolean myIsPertinent) {
		this.isPertinent = myIsPertinent;
	}


	public void setQType(String myQType) {
		this.qType = myQType;
	}

	public void addForm(Form newForm) {
		if(this.form == null) {
			this.form = new HashSet<Form>();
		}
		
		if (this.form.add(newForm))
			newForm.addQuestion(this);
	}
	public void addEvaluation(Evaluation newEvaluation) {
		if(this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		
		if (this.evaluation.add(newEvaluation))
			newEvaluation.basicSetQuestion(this);
	}

	public void unsetIsPertinent() {
		this.isPertinent = null;
	}
	public void unsetQTitle() {
		this.qTitle = null;
	}

	public void unsetQType() {
		this.qType = null;
	}

	public void removeForm(Form oldForm) {
		if(this.form == null)
			return;
		
		if (this.form.remove(oldForm))
			oldForm.removeQuestion(this);
		
	}
	public void removeEvaluation(Evaluation oldEvaluation) {
		if(this.evaluation == null)
			return;
		
		if (this.evaluation.remove(oldEvaluation))
			oldEvaluation.unsetQuestion();
		
	}

}

