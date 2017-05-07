package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



 
@javax.persistence.Entity 
public class Form implements Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1526199174259454089L;

	@javax.persistence.ManyToMany(mappedBy = "form") 
	protected Set<Template> template;

	@javax.persistence.OneToOne(mappedBy = "form") 
	protected Question question;

	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected VTeacher vTeacher;

	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected AdminAvis admin;

	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected ETeacher eTeacher;

	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long formId = 0L;

	@javax.persistence.Column 
	protected String formType;
	
	public Form(){
		super();
	}

	public void basicSetQuestion(Question myQuestion) {
		if (this.question != myQuestion) {
			if (myQuestion != null){
				if (this.question != myQuestion) {
					Question oldquestion = this.question;
					this.question = myQuestion;
					if (oldquestion != null)
						oldquestion.unsetForm();
				}
			}
		}
	}

	public void basicSetAdmin(AdminAvis myAdmin) {
		if (this.admin != myAdmin) {
			if (myAdmin != null){
				if (this.admin != myAdmin) {
					AdminAvis oldadmin = this.admin;
					this.admin = myAdmin;
					if (oldadmin != null)
						oldadmin.removeForm(this);
				}
			}
		}
	}

	public void basicSetETeacher(ETeacher myETeacher) {
		if (this.eTeacher != myETeacher) {
			if (myETeacher != null){
				if (this.eTeacher != myETeacher) {
					ETeacher oldeTeacher = this.eTeacher;
					this.eTeacher = myETeacher;
					if (oldeTeacher != null)
						oldeTeacher.removeForm(this);
				}
			}
		}
	}
	
	public void basicSetVTeacher(VTeacher myVTeacher) {
		if (this.vTeacher != myVTeacher) {
			if (myVTeacher != null){
				if (this.vTeacher != myVTeacher) {
					VTeacher oldvTeacher = this.vTeacher;
					this.vTeacher = myVTeacher;
					if (oldvTeacher != null)
						oldvTeacher.removeForm(this);
				}
			}
		}
	}
	public Set<Template> getTemplate() {
		if(this.template == null) {
				this.template = new HashSet<Template>();
		}
		return (Set<Template>) this.template;
	}
	public String getFormType() {
		return this.formType;
	}
	public Question getQuestion() {
		return this.question;
	}

	public VTeacher getVTeacher() {
		return this.vTeacher;
	}

	public AdminAvis getAdmin() {
		return this.admin;
	}

	public ETeacher getETeacher() {
		return this.eTeacher;
	}

	public long getFormId() {
		return this.formId;
	}

	public void addAllTemplate(Set<Template> newTemplate) {
		if (this.template == null) {
			this.template = new HashSet<Template>();
		}
		for (Template tmp : newTemplate)
			tmp.addForm(this);
		
	}

	public void removeAllTemplate(Set<Template> newTemplate) {
		if(this.template == null) {
			return;
		}
		
		this.template.removeAll(newTemplate);
	}

	public void addTemplate(Template newTemplate) {
		if(this.template == null) {
			this.template = new HashSet<Template>();
		}
		
		if (this.template.add(newTemplate))
			newTemplate.addForm(this);
	}

	public void setQuestion(Question myQuestion) {
		this.basicSetQuestion(myQuestion);
		myQuestion.basicSetForm(this);
		
	}
	public void setFormType(String myformType) {
		this.formType = myformType;
	}
	public void setVTeacher(VTeacher myVTeacher) {
		this.basicSetVTeacher(myVTeacher);
		myVTeacher.addForm(this);
		
	}

	public void setAdmin(AdminAvis myAdmin) {
		this.basicSetAdmin(myAdmin);
		myAdmin.addForm(this);
	}

	public void setETeacher(ETeacher myETeacher) {
		this.basicSetETeacher(myETeacher);
		myETeacher.addForm(this);
	}
	public void removeTemplate(Template oldTemplate) {
		if(this.template == null)
			return;
		
		if (this.template.remove(oldTemplate))
			oldTemplate.removeForm(this);
		
	}

	public void unsetQuestion() {
		if (this.question == null)
			return;
		Question oldquestion = this.question;
		this.question = null;
		oldquestion.unsetForm();
	}
	public void unsetFormType() {
		this.formType = null;
	}
	public void unsetVTeacher() {
		if (this.vTeacher == null)
			return;
		VTeacher oldvTeacher = this.vTeacher;
		this.vTeacher = null;
		oldvTeacher.removeForm(this);
	}

	public void unsetAdmin() {
		if (this.admin == null)
			return;
		AdminAvis oldadmin = this.admin;
		this.admin = null;
		oldadmin.removeForm(this);
	}

	public void unsetETeacher() {
		if (this.eTeacher == null)
			return;
		ETeacher oldeTeacher = this.eTeacher;
		this.eTeacher = null;
		oldeTeacher.removeForm(this);
	}

}