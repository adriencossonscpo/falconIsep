package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
 
@javax.persistence.Entity 
public class Cours implements Serializable
{
	private static final long serialVersionUID = -5276290922499062222L;

	@javax.persistence.Column 
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	protected Date cDate;

	@javax.persistence.Column 
	protected String description;

	@javax.persistence.OneToMany(mappedBy = "cours") 
	protected Set<Evaluation> evaluation;

	 
	@javax.persistence.OneToMany(mappedBy = "cours") 
	protected Set<Salle> salle;

	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Module module;
	
	@javax.persistence.OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="form_id")
	protected Form form;

	@javax.persistence.Id 
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY)  
	private Long id;

	public Cours(){
		super();
	}

	public void basicSetModule(Module myModule) {
		if (this.module != myModule) {
			if (myModule != null){
				if (this.module != myModule) {
					Module oldmodule = this.module;
					this.module = myModule;
					if (oldmodule != null)
						oldmodule.removeCours(this);
				}
			}
		}
	}

	
	public void basicSetForm(Form myForm) {
		if (this.form != myForm) {
			if (myForm != null){
				if (this.form != myForm) {
					Form oldform = this.form;
					this.form = myForm;
					if (oldform != null)
						oldform.unsetCours();
				}
			}
		}
	}
	
	public Form getForm() {
		return this.form;
	}
	public void setForm(Form myForm) {
		this.basicSetForm(myForm);
		myForm.basicSetCours(this);
		
	}
	public void unsetForm() {
		if (this.form == null)
			return;
		Form oldform = this.form;
		this.form = null;
		oldform.unsetCours();
	}
	
	public Date getCDate() {
		return this.cDate;
	}
	
	public String getDescription() {
		return this.description;
	}

	public Set<Evaluation> getEvaluation() {
		if(this.evaluation == null) {
				this.evaluation = new HashSet<Evaluation>();
		}
		return (Set<Evaluation>) this.evaluation;
	}

	public Set<Salle> getSalle() {
		if(this.salle == null) {
				this.salle = new HashSet<Salle>();
		}
		return (Set<Salle>) this.salle;
	}

	public Module getModule() {
		return this.module;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void addAllEvaluation(Set<Evaluation> newEvaluation) {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		for (Evaluation tmp : newEvaluation)
			tmp.setCours(this);
		
	}
	public void addAllSalle(Set<Salle> newSalle) {
		if (this.salle == null) {
			this.salle = new HashSet<Salle>();
		}
		for (Salle tmp : newSalle)
			tmp.setCours(this);
		
	}

	public void removeAllEvaluation(Set<Evaluation> newEvaluation) {
		if(this.evaluation == null) {
			return;
		}
		
		this.evaluation.removeAll(newEvaluation);
	}
	public void removeAllSalle(Set<Salle> newSalle) {
		if(this.salle == null) {
			return;
		}
		
		this.salle.removeAll(newSalle);
	}

	public void setCDate(Date myCDate) {
		this.cDate = myCDate;
	}
	public void setDescription(String myDescription) {
		this.description = myDescription;
	}

	public void addEvaluation(Evaluation newEvaluation) {
		if(this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		
		if (this.evaluation.add(newEvaluation))
			newEvaluation.basicSetCours(this);
	}
	public void addSalle(Salle newSalle) {
		if(this.salle == null) {
			this.salle = new HashSet<Salle>();
		}
		
		if (this.salle.add(newSalle))
			newSalle.basicSetCours(this);
	}
	public void setModule(Module myModule) {
		this.basicSetModule(myModule);
		myModule.addCours(this);
	}
	public void unsetCDate() {
		this.cDate = null;
	}
	public void unsetDescription() {
		this.description = null;
	}
	public void removeEvaluation(Evaluation oldEvaluation) {
		if(this.evaluation == null)
			return;
		
		if (this.evaluation.remove(oldEvaluation))
			oldEvaluation.unsetCours();
		
	}
	public void removeSalle(Salle oldSalle) {
		if(this.salle == null)
			return;
		
		if (this.salle.remove(oldSalle))
			oldSalle.unsetCours();
		
	}
	public void unsetModule() {
		if (this.module == null)
			return;
		Module oldmodule = this.module;
		this.module = null;
		oldmodule.removeCours(this);
	}

}

