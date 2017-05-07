package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@javax.persistence.Entity 
public class VTeacher extends UserAvis implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3067304248397921682L;
	@javax.persistence.OneToMany (mappedBy = "vTeacher")
	protected Set<Form> form;

	public VTeacher(){
		super();
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
			tmp.setVTeacher(this);
		
	}

	public void removeAllForm(Set<Form> newForm) {
		if(this.form == null) {
			return;
		}
		
		this.form.removeAll(newForm);
	}

	public void addForm(Form newForm) {
		if(this.form == null) {
			this.form = new HashSet<Form>();
		}
		
		if (this.form.add(newForm))
			newForm.basicSetVTeacher(this);
	}

	public void removeForm(Form oldForm) {
		if(this.form == null)
			return;
		
		if (this.form.remove(oldForm))
			oldForm.unsetVTeacher();
		
	}

}

