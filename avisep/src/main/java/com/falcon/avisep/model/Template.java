package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@javax.persistence.Entity 
public class Template implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2666682561383526445L;

	@javax.persistence.Column 
	protected String name;

	@javax.persistence.ManyToMany 
	protected Set<Form> form;

	 
	@javax.persistence.ManyToMany(cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Question> question;

	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long temId = 0L;

	public Template(){
		super();
	}

	public String getName() {
		return this.name;
	}

	public Set<Form> getForm() {
		if(this.form == null) {
				this.form = new HashSet<Form>();
		}
		return (Set<Form>) this.form;
	}

	public Set<Question> getQuestion() {
		if(this.question == null) {
				this.question = new HashSet<Question>();
		}
		return (Set<Question>) this.question;
	}

	public long getTemId() {
		return this.temId;
	}

	public void addAllForm(Set<Form> newForm) {
		if (this.form == null) {
			this.form = new HashSet<Form>();
		}
		for (Form tmp : newForm)
			tmp.addTemplate(this);
		
	}

	public void addAllQuestion(Set<Question> newQuestion) {
		if (this.question == null) {
			this.question = new HashSet<Question>();
		}
		for (Question tmp : newQuestion)
			tmp.addTemplate(this);
		
	}

	public void removeAllForm(Set<Form> newForm) {
		if(this.form == null) {
			return;
		}
		
		this.form.removeAll(newForm);
	}

	public void removeAllQuestion(Set<Question> newQuestion) {
		if(this.question == null) {
			return;
		}
		
		this.question.removeAll(newQuestion);
	}

	public void setName(String myName) {
		this.name = myName;
	}

	public void addForm(Form newForm) {
		if(this.form == null) {
			this.form = new HashSet<Form>();
		}
		
		if (this.form.add(newForm))
			newForm.addTemplate(this);
	}

	public void addQuestion(Question newQuestion) {
		if(this.question == null) {
			this.question = new HashSet<Question>();
		}
		
		if (this.question.add(newQuestion))
			newQuestion.addTemplate(this);
	}

	public void unsetName() {
		this.name = null;
	}

	public void removeForm(Form oldForm) {
		if(this.form == null)
			return;
		
		if (this.form.remove(oldForm))
			oldForm.removeTemplate(this);
		
	}

	public void removeQuestion(Question oldQuestion) {
		if(this.question == null)
			return;
		
		if (this.question.remove(oldQuestion))
			oldQuestion.removeTemplate(this);
		
	}

}

