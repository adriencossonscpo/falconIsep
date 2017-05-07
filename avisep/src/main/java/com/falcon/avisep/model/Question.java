package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



 
@javax.persistence.Entity 
public class Question implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3980318607063807474L;

	@javax.persistence.Column 
	protected String inTemplate;

	@javax.persistence.Column 
	protected String asPertinance;

	@javax.persistence.Column 
	protected Boolean isPertinent;

	@javax.persistence.Column 
	protected String content;
	 
	@javax.persistence.Column 
	protected String qType;

	@javax.persistence.OneToOne 
	protected Form form;

	@javax.persistence.ManyToMany(mappedBy = "question") 
	protected Set<Template> template;

	@javax.persistence.OneToMany(mappedBy = "question", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Evaluation> evaluation;

	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long qId = 0L;

	public Question(){
		super();
	}

	public void basicSetForm(Form myForm) {
		if (this.form != myForm) {
			if (myForm != null){
				if (this.form != myForm) {
					Form oldform = this.form;
					this.form = myForm;
					if (oldform != null)
						oldform.unsetQuestion();
				}
			}
		}
	}

	public String getInTemplate() {
		return this.inTemplate;
	}

	public String getAsPertinance() {
		return this.asPertinance;
	}

	public Boolean getIsPertinent() {
		return this.isPertinent;
	}

	public String getContent() {
		return this.content;
	}
	
	public String getQType() {
		return this.qType;
	}

	public Form getForm() {
		return this.form;
	}
	public Set<Template> getTemplate() {
		if(this.template == null) {
				this.template = new HashSet<Template>();
		}
		return (Set<Template>) this.template;
	}
	public Set<Evaluation> getEvaluation() {
		if(this.evaluation == null) {
				this.evaluation = new HashSet<Evaluation>();
		}
		return (Set<Evaluation>) this.evaluation;
	}

	public long getQId() {
		return this.qId;
	}

	public void addAllTemplate(Set<Template> newTemplate) {
		if (this.template == null) {
			this.template = new HashSet<Template>();
		}
		for (Template tmp : newTemplate)
			tmp.addQuestion(this);
		
	}
	public void addAllEvaluation(Set<Evaluation> newEvaluation) {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		for (Evaluation tmp : newEvaluation)
			tmp.setQuestion(this);
		
	}

	public void removeAllTemplate(Set<Template> newTemplate) {
		if(this.template == null) {
			return;
		}
		
		this.template.removeAll(newTemplate);
	}

	public void removeAllEvaluation(Set<Evaluation> newEvaluation) {
		if(this.evaluation == null) {
			return;
		}
		
		this.evaluation.removeAll(newEvaluation);
	}

	public void setInTemplate(String myInTemplate) {
		this.inTemplate = myInTemplate;
	}
	public void setAsPertinance(String myAsPertinance) {
		this.asPertinance = myAsPertinance;
	}

	public void setIsPertinent(Boolean myIsPertinent) {
		this.isPertinent = myIsPertinent;
	}

	public void setContent(String myContent) {
		this.content = myContent;
	}

	public void setQType(String myQType) {
		this.qType = myQType;
	}

	public void setForm(Form myForm) {
		this.basicSetForm(myForm);
		myForm.basicSetQuestion(this);
		
	}

	public void addTemplate(Template newTemplate) {
		if(this.template == null) {
			this.template = new HashSet<Template>();
		}
		
		if (this.template.add(newTemplate))
			newTemplate.addQuestion(this);
	}

	public void addEvaluation(Evaluation newEvaluation) {
		if(this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		
		if (this.evaluation.add(newEvaluation))
			newEvaluation.basicSetQuestion(this);
	}

	public void unsetInTemplate() {
		this.inTemplate = null;
	}

	public void unsetAsPertinance() {
		this.asPertinance = null;
	}

	public void unsetIsPertinent() {
		this.isPertinent = null;
	}

	public void unsetContent() {
		this.content = null;
	}

	public void unsetQType() {
		this.qType = null;
	}

	public void unsetForm() {
		if (this.form == null)
			return;
		Form oldform = this.form;
		this.form = null;
		oldform.unsetQuestion();
	}

	public void removeTemplate(Template oldTemplate) {
		if(this.template == null)
			return;
		
		if (this.template.remove(oldTemplate))
			oldTemplate.removeQuestion(this);
		
	}

	public void removeEvaluation(Evaluation oldEvaluation) {
		if(this.evaluation == null)
			return;
		
		if (this.evaluation.remove(oldEvaluation))
			oldEvaluation.unsetQuestion();
		
	}

}

