package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.GenerationType;
import javax.persistence.Temporal;



@javax.persistence.Entity 
@javax.persistence.Table(name = "form")
public class Form implements Serializable
{
	private static final long serialVersionUID = -7863390379345194681L;

	 
	@javax.persistence.Column 
	protected String formTitle;
	 
	@javax.persistence.Column 
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	protected Date dateCreation;
	 
	@javax.persistence.ManyToMany(mappedBy = "form") 
	protected Set<Question> question;

	 
	@javax.persistence.ManyToOne
	protected UserAvis userAvis;
	
	@javax.persistence.Id 
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	public Form(){
		super();
	}

	public void basicSetUserAvis(UserAvis myUserAvis) {
		if (this.userAvis != myUserAvis) {
			if (myUserAvis != null){
				if (this.userAvis != myUserAvis) {
					UserAvis olduserAvis = this.userAvis;
					this.userAvis = myUserAvis;
					if (olduserAvis != null)
						olduserAvis.removeForm(this);
				}
			}
		}
	}

	public String getFormTitle() {
		return this.formTitle;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public Set<Question> getQuestion() {
		if(this.question == null) {
				this.question = new HashSet<Question>();
		}
		return (Set<Question>) this.question;
	}
	public UserAvis getUserAvis() {
		return this.userAvis;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public void addAllQuestion(Set<Question> newQuestion) {
		if (this.question == null) {
			this.question = new HashSet<Question>();
		}
		for (Question tmp : newQuestion)
			tmp.addForm(this);
		
	}
	public void removeAllQuestion(Set<Question> newQuestion) {
		if(this.question == null) {
			return;
		}
		
		this.question.removeAll(newQuestion);
	}

	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}

	public void setDateCreation(Date myDateCreation) {
		this.dateCreation = myDateCreation;
	}

	public void addQuestion(Question newQuestion) {
		if(this.question == null) {
			this.question = new HashSet<Question>();
		}
		
		if (this.question.add(newQuestion))
			newQuestion.addForm(this);
	}
	public void setUserAvis(UserAvis myUserAvis) {
		this.basicSetUserAvis(myUserAvis);
		myUserAvis.addForm(this);
	}

	public void unsetFormTitle() {
		this.formTitle = null;
	}

	public void unsetDateCreation() {
		this.dateCreation = null;
	}

	public void removeQuestion(Question oldQuestion) {
		if(this.question == null)
			return;
		
		if (this.question.remove(oldQuestion))
			oldQuestion.removeForm(this);
		
	}
	public void unsetUserAvis() {
		if (this.userAvis == null)
			return;
		UserAvis olduserAvis = this.userAvis;
		this.userAvis = null;
		olduserAvis.removeForm(this);
	}

}

