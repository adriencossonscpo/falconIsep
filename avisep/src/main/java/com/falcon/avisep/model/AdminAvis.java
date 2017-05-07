package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@javax.persistence.Entity 
public class AdminAvis  extends UserAvis implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1509526703375926269L;

	@javax.persistence.Column 
	protected Integer adminId;
	
	@javax.persistence.OneToMany(mappedBy = "admin") 
	protected Set<Form> form;

	public AdminAvis(){
		super();
	}

	public Integer getAdminId() {
		return this.adminId;
	}

	public Set<Form> getForm() {
		if(this.form == null) {
				this.form = new HashSet<Form>();
		}
		return (Set<Form>) this.form;
	}

	public void addAllForm(Set<Form> newForm) {
		if (this.form == null) {
			this.form = new HashSet<Form>();
		}
		for (Form tmp : newForm)
			tmp.setAdmin(this);
		
	}

	public void removeAllForm(Set<Form> newForm) {
		if(this.form == null) {
			return;
		}
		
		this.form.removeAll(newForm);
	}

	public void setAdminId(Integer myAdminId) {
		this.adminId = myAdminId;
	}

	public void addForm(Form newForm) {
		if(this.form == null) {
			this.form = new HashSet<Form>();
		}
		
		if (this.form.add(newForm))
			newForm.basicSetAdmin(this);
	}

	public void unsetAdminId() {
		this.adminId = null;
	}

	public void removeForm(Form oldForm) {
		if(this.form == null)
			return;
		
		if (this.form.remove(oldForm))
			oldForm.unsetAdmin();
		
	}

}

