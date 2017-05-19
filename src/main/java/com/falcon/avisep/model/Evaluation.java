package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GenerationType;
import javax.persistence.Temporal;

 
@javax.persistence.Entity 
public class Evaluation implements Serializable
{
	private static final long serialVersionUID = 5952622685135836725L;

	 
	@javax.persistence.Column(nullable = false)
	@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	protected Date eData;

	 
	@javax.persistence.ManyToOne 
	protected Salle salle;

	 
	@javax.persistence.ManyToOne 
	protected Cours cours;

	 
	@javax.persistence.ManyToOne 
	protected Module module;

	 
	@javax.persistence.ManyToOne 
	protected Classe classe;

	 
	@javax.persistence.ManyToOne 
	@javax.persistence.JoinColumn(nullable = false) 
	protected UserAvis user;

	 
	@javax.persistence.ManyToOne 
	protected Question question;

	@javax.persistence.Id 
	@javax.persistence.GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Long id;

	public Evaluation(){
		super();
	}
	public void basicSetSalle(Salle mySalle) {
		if (this.salle != mySalle) {
			if (mySalle != null){
				if (this.salle != mySalle) {
					Salle oldsalle = this.salle;
					this.salle = mySalle;
					if (oldsalle != null)
						oldsalle.removeEvaluation(this);
				}
			}
		}
	}
	public void basicSetCours(Cours myCours) {
		if (this.cours != myCours) {
			if (myCours != null){
				if (this.cours != myCours) {
					Cours oldcours = this.cours;
					this.cours = myCours;
					if (oldcours != null)
						oldcours.removeEvaluation(this);
				}
			}
		}
	}

	public void basicSetModule(Module myModule) {
		if (this.module != myModule) {
			if (myModule != null){
				if (this.module != myModule) {
					Module oldmodule = this.module;
					this.module = myModule;
					if (oldmodule != null)
						oldmodule.removeEvaluation(this);
				}
			}
		}
	}
	public void basicSetClasse(Classe myClasse) {
		if (this.classe != myClasse) {
			if (myClasse != null){
				if (this.classe != myClasse) {
					Classe oldclasse = this.classe;
					this.classe = myClasse;
					if (oldclasse != null)
						oldclasse.removeEvaluation(this);
				}
			}
		}
	}
	public void basicSetUser(UserAvis myUser) {
		if (this.user != myUser) {
			if (myUser != null){
				if (this.user != myUser) {
					UserAvis olduser = this.user;
					this.user = myUser;
					if (olduser != null)
						olduser.removeEvaluation(this);
				}
			}
		}
	}

	public void basicSetQuestion(Question myQuestion) {
		if (this.question != myQuestion) {
			if (myQuestion != null){
				if (this.question != myQuestion) {
					Question oldquestion = this.question;
					this.question = myQuestion;
					if (oldquestion != null)
						oldquestion.removeEvaluation(this);
				}
			}
		}
	}

	public Date getEData() {
		return this.eData;
	}

	public Salle getSalle() {
		return this.salle;
	}

	public Cours getCours() {
		return this.cours;
	}

	public Module getModule() {
		return this.module;
	}
	public Classe getClasse() {
		return this.classe;
	}
	public UserAvis getUser() {
		return this.user;
	}
	public Question getQuestion() {
		return this.question;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setEData(Date myEData) {
		this.eData = myEData;
	}

	public void setSalle(Salle mySalle) {
		this.basicSetSalle(mySalle);
		mySalle.addEvaluation(this);
	}

	public void setCours(Cours myCours) {
		this.basicSetCours(myCours);
		myCours.addEvaluation(this);
	}
	public void setModule(Module myModule) {
		this.basicSetModule(myModule);
		myModule.addEvaluation(this);
	}

	public void setClasse(Classe myClasse) {
		this.basicSetClasse(myClasse);
		myClasse.addEvaluation(this);
	}
	public void setUser(UserAvis myUser) {
		this.basicSetUser(myUser);
		myUser.addEvaluation(this);
	}

	public void setQuestion(Question myQuestion) {
		this.basicSetQuestion(myQuestion);
		myQuestion.addEvaluation(this);
	}

	public void unsetEData() {
		this.eData = null;
	}
	public void unsetSalle() {
		if (this.salle == null)
			return;
		Salle oldsalle = this.salle;
		this.salle = null;
		oldsalle.removeEvaluation(this);
	}

	public void unsetCours() {
		if (this.cours == null)
			return;
		Cours oldcours = this.cours;
		this.cours = null;
		oldcours.removeEvaluation(this);
	}
	public void unsetModule() {
		if (this.module == null)
			return;
		Module oldmodule = this.module;
		this.module = null;
		oldmodule.removeEvaluation(this);
	}

	public void unsetClasse() {
		if (this.classe == null)
			return;
		Classe oldclasse = this.classe;
		this.classe = null;
		oldclasse.removeEvaluation(this);
	}

	public void unsetUser() {
		if (this.user == null)
			return;
		UserAvis olduser = this.user;
		this.user = null;
		olduser.removeEvaluation(this);
	}
	public void unsetQuestion() {
		if (this.question == null)
			return;
		Question oldquestion = this.question;
		this.question = null;
		oldquestion.removeEvaluation(this);
	}

}

