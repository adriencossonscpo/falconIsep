package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


@javax.persistence.Entity 
public class UserAvis implements Serializable 
{
	private static final long serialVersionUID = -6183024539774889410L;

	@javax.persistence.Column 
	protected String lastName;
	 
	@javax.persistence.Column 
	protected String login;

	@javax.persistence.Column 
	protected String firstName;

	@javax.persistence.Column 
	protected String email;

	 
	@javax.persistence.Column 
	protected String passwd;

	@javax.persistence.Enumerated(javax.persistence.EnumType.STRING) 
	@javax.persistence.ElementCollection(targetClass = RoleAvis.class) 
	protected Set<RoleAvis> roleAvis;

	 
	@javax.persistence.OneToMany(mappedBy = "user", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Evaluation> evaluation;

	 
	@javax.persistence.ManyToMany(cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Classe> classe;

	 
	@javax.persistence.OneToMany(mappedBy = "userAvis", cascade = javax.persistence.CascadeType.ALL) 
	protected Set<Module> module;

	@javax.persistence.Id 
	@javax.persistence.Column(nullable = false) 
	protected final Long id = 0L;

	public UserAvis(){
		super();
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPasswd() {
		return this.passwd;
	}

	public Set<RoleAvis> getRoleAvis() {
		if(this.roleAvis == null) {
				this.roleAvis = new HashSet<RoleAvis>();
		}
		return (Set<RoleAvis>) this.roleAvis;
	}

	public Set<Evaluation> getEvaluation() {
		if(this.evaluation == null) {
				this.evaluation = new HashSet<Evaluation>();
		}
		return (Set<Evaluation>) this.evaluation;
	}
	public Set<Classe> getClasse() {
		if(this.classe == null) {
				this.classe = new HashSet<Classe>();
		}
		return (Set<Classe>) this.classe;
	}

	public Set<Module> getModule() {
		if(this.module == null) {
				this.module = new HashSet<Module>();
		}
		return (Set<Module>) this.module;
	}

	public long getId() {
		return this.id;
	}

	public void addAllRoleAvis(Set<RoleAvis> newRoleAvis) {
		if (this.roleAvis == null) {
			this.roleAvis = new HashSet<RoleAvis>();
		}
		this.roleAvis.addAll(newRoleAvis);
	}

	public void addAllEvaluation(Set<Evaluation> newEvaluation) {
		if (this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		for (Evaluation tmp : newEvaluation)
			tmp.setUser(this);
		
	}
	public void addAllClasse(Set<Classe> newClasse) {
		if (this.classe == null) {
			this.classe = new HashSet<Classe>();
		}
		for (Classe tmp : newClasse)
			tmp.addUserAvis(this);
		
	}
	public void addAllModule(Set<Module> newModule) {
		if (this.module == null) {
			this.module = new HashSet<Module>();
		}
		for (Module tmp : newModule)
			tmp.setUserAvis(this);
		
	}
	public void removeAllRoleAvis(Set<RoleAvis> newRoleAvis) {
		if(this.roleAvis == null) {
			return;
		}
		
		this.roleAvis.removeAll(newRoleAvis);
	}
	public void removeAllEvaluation(Set<Evaluation> newEvaluation) {
		if(this.evaluation == null) {
			return;
		}
		
		this.evaluation.removeAll(newEvaluation);
	}

	public void removeAllClasse(Set<Classe> newClasse) {
		if(this.classe == null) {
			return;
		}
		
		this.classe.removeAll(newClasse);
	}

	public void removeAllModule(Set<Module> newModule) {
		if(this.module == null) {
			return;
		}
		
		this.module.removeAll(newModule);
	}

	public void setLastName(String myLastName) {
		this.lastName = myLastName;
	}

	public void setLogin(String myLogin) {
		this.login = myLogin;
	}

	public void setFirstName(String myFirstName) {
		this.firstName = myFirstName;
	}

	public void setEmail(String myEmail) {
		this.email = myEmail;
	}

	public void setPasswd(String myPasswd) {
		this.passwd = myPasswd;
	}
	public void addRoleAvis(RoleAvis newRoleAvis) {
		if(this.roleAvis == null) {
			this.roleAvis = new HashSet<RoleAvis>();
		}
		
		this.roleAvis.add(newRoleAvis);
	}

	public void addEvaluation(Evaluation newEvaluation) {
		if(this.evaluation == null) {
			this.evaluation = new HashSet<Evaluation>();
		}
		
		if (this.evaluation.add(newEvaluation))
			newEvaluation.basicSetUser(this);
	}
	public void addClasse(Classe newClasse) {
		if(this.classe == null) {
			this.classe = new HashSet<Classe>();
		}
		
		if (this.classe.add(newClasse))
			newClasse.addUserAvis(this);
	}

	public void addModule(Module newModule) {
		if(this.module == null) {
			this.module = new HashSet<Module>();
		}
		
		if (this.module.add(newModule))
			newModule.basicSetUserAvis(this);
	}

	public void unsetLastName() {
		this.lastName = null;
	}

	public void unsetLogin() {
		this.login = null;
	}

	public void unsetFirstName() {
		this.firstName = null;
	}

	public void unsetEmail() {
		this.email = null;
	}
	public void unsetPasswd() {
		this.passwd = null;
	}

	public void removeRoleAvis(RoleAvis oldRoleAvis) {
		if(this.roleAvis == null)
			return;
		
		this.roleAvis.remove(oldRoleAvis);
	}

	public void removeEvaluation(Evaluation oldEvaluation) {
		if(this.evaluation == null)
			return;
		
		if (this.evaluation.remove(oldEvaluation))
			oldEvaluation.unsetUser();
		
	}
	public void removeClasse(Classe oldClasse) {
		if(this.classe == null)
			return;
		
		if (this.classe.remove(oldClasse))
			oldClasse.removeUserAvis(this);
		
	}
	public void removeModule(Module oldModule) {
		if(this.module == null)
			return;
		
		if (this.module.remove(oldModule))
			oldModule.unsetUserAvis();
		
	}

}

