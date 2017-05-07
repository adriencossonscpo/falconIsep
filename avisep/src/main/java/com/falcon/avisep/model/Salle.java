package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



@javax.persistence.Entity 
public class Salle implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8828244291063532926L;
	@javax.persistence.Column 
	protected String name;
	@javax.persistence.Column 
	protected String location;

	@javax.persistence.OneToMany(mappedBy = "salle", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Evaluation> evaluation;

	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected Cours cours;
	
	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long salleId = 0L;

	public Salle(){
		super();
	}

	public void basicSetCours(Cours myCours) {
		if (this.cours != myCours) {
			if (myCours != null){
				if (this.cours != myCours) {
					Cours oldcours = this.cours;
					this.cours = myCours;
					if (oldcours != null)
						oldcours.removeSalle(this);
				}
			}
		}
	}

	public String getName() {
		return this.name;
	}

	public String getLocation() {
		return this.location;
	}

	public Set<Evaluation> getEvaluation() {
		if(this.evaluation == null) {
				this.evaluation = new HashSet<Evaluation>();
		}
		return (Set<Evaluation>) this.evaluation;
	}

	public Cours getCours() {
		return this.cours;
	}
	public long getSalleId() {
		return this.salleId;
	}

	public void addAllEvaluation(Set<Evaluation> newEvaluation) {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		for (Evaluation tmp : newEvaluation)
			tmp.setSalle(this);
		
	}

	public void removeAllEvaluation(Set<Evaluation> newEvaluation) {
		if(this.evaluation == null) {
			return;
		}
		
		this.evaluation.removeAll(newEvaluation);
	}

	public void setName(String myName) {
		this.name = myName;
	}

	public void setLocation(String myLocation) {
		this.location = myLocation;
	}
	public void addEvaluation(Evaluation newEvaluation) {
		if(this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		
		if (this.evaluation.add(newEvaluation))
			newEvaluation.basicSetSalle(this);
	}

	public void setCours(Cours myCours) {
		this.basicSetCours(myCours);
		myCours.addSalle(this);
	}

	public void unsetName() {
		this.name = null;
	}

	public void unsetLocation() {
		this.location = null;
	}

	public void removeEvaluation(Evaluation oldEvaluation) {
		if(this.evaluation == null)
			return;
		
		if (this.evaluation.remove(oldEvaluation))
			oldEvaluation.unsetSalle();
		
	}

	public void unsetCours() {
		if (this.cours == null)
			return;
		Cours oldcours = this.cours;
		this.cours = null;
		oldcours.removeSalle(this);
	}

}

