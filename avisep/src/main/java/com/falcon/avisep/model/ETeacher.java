package com.falcon.avisep.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;



 
@javax.persistence.Entity 
@javax.persistence.DiscriminatorValue("ROLE_ETEACHER")
public class ETeacher extends UserAvis implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2419726689917526461L;
	@javax.persistence.OneToMany(mappedBy = "eTeacher") 
	protected Set<Form> form;

	public ETeacher(){
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
			tmp.setETeacher(this);
		
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
			newForm.basicSetETeacher(this);
	}

	public void removeForm(Form oldForm) {
		if(this.form == null)
			return;
		
		if (this.form.remove(oldForm))
			oldForm.unsetETeacher();
		
	}

}

