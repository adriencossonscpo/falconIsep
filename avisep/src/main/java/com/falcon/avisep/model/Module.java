package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



 
@javax.persistence.Entity 
public class Module implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6322761009649610490L;

	@javax.persistence.Column 
	protected String name;

	@javax.persistence.Column 
	protected String description;

	 
	@javax.persistence.OneToMany(mappedBy = "module", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Evaluation> evaluation;
	 
	@javax.persistence.OneToMany(mappedBy = "module", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Cours> cours;

	 
	@javax.persistence.ManyToOne 
	protected UserAvis userAvis;

	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long moduleId = 0L;

	public Module(){
		super();
	}

	public void basicSetUserAvis(UserAvis myUserAvis) {
		if (this.userAvis != myUserAvis) {
			if (myUserAvis != null){
				if (this.userAvis != myUserAvis) {
					UserAvis olduserAvis = this.userAvis;
					this.userAvis = myUserAvis;
					if (olduserAvis != null)
						olduserAvis.removeModule(this);
				}
			}
		}
	}

	public String getName() {
		return this.name;
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

	public Set<Cours> getCours() {
		if(this.cours == null) {
				this.cours = new HashSet<Cours>();
		}
		return (Set<Cours>) this.cours;
	}

	public UserAvis getUserAvis() {
		return this.userAvis;
	}

	public long getModuleId() {
		return this.moduleId;
	}

	public void addAllEvaluation(Set<Evaluation> newEvaluation) {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		for (Evaluation tmp : newEvaluation)
			tmp.setModule(this);
		
	}

	public void addAllCours(Set<Cours> newCours) {
		if (this.cours == null) {
			this.cours = new HashSet<Cours>();
		}
		for (Cours tmp : newCours)
			tmp.setModule(this);
		
	}

	public void removeAllEvaluation(Set<Evaluation> newEvaluation) {
		if(this.evaluation == null) {
			return;
		}
		
		this.evaluation.removeAll(newEvaluation);
	}

	public void removeAllCours(Set<Cours> newCours) {
		if(this.cours == null) {
			return;
		}
		
		this.cours.removeAll(newCours);
	}

	public void setName(String myName) {
		this.name = myName;
	}

	public void setDescription(String myDescription) {
		this.description = myDescription;
	}

	public void addEvaluation(Evaluation newEvaluation) {
		if(this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		
		if (this.evaluation.add(newEvaluation))
			newEvaluation.basicSetModule(this);
	}

	public void addCours(Cours newCours) {
		if(this.cours == null) {
			this.cours = new HashSet<Cours>();
		}
		
		if (this.cours.add(newCours))
			newCours.basicSetModule(this);
	}

	public void setUserAvis(UserAvis myUserAvis) {
		this.basicSetUserAvis(myUserAvis);
		myUserAvis.addModule(this);
	}

	public void unsetName() {
		this.name = null;
	}

	public void unsetDescription() {
		this.description = null;
	}

	public void removeEvaluation(Evaluation oldEvaluation) {
		if(this.evaluation == null)
			return;
		
		if (this.evaluation.remove(oldEvaluation))
			oldEvaluation.unsetModule();
		
	}

	public void removeCours(Cours oldCours) {
		if(this.cours == null)
			return;
		
		if (this.cours.remove(oldCours))
			oldCours.unsetModule();
		
	}

	public void unsetUserAvis() {
		if (this.userAvis == null)
			return;
		UserAvis olduserAvis = this.userAvis;
		this.userAvis = null;
		olduserAvis.removeModule(this);
	}

}

