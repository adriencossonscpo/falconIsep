package com.falcon.avisep.model;

import java.util.List;

import com.falcon.avisep.util.utilMethod;

public class ModelViewAnsForm {
	protected Cours cours;
	protected Form forms;
	protected List<Question> question;
	protected List<String> options;
	
	protected String formTitle;

	
	public ModelViewAnsForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelViewAnsForm(Cours cours, Form forms, List<Question> question, String formTitle) {
		super();
		this.cours = cours;
		this.forms = forms;
		this.question = question;
		this.options = getOptions();
		this.formTitle = formTitle;
	}
	public String getFormTitle() {
		return formTitle;
	}
	public void setFormTitle(String formTitle) {
		this.formTitle = formTitle;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public Form getForms() {
		return forms;
	}
	public void setForms(Form forms) {
		this.forms = forms;
	}
	public List<Question> getQuestion() {
		return question;
	}
	public void setQuestion(List<Question> question) {
		this.question = question;
	}
	public List<String> getOptions() {
		for(int i=0;i<this.question.size();i++)
		{
			this.options=utilMethod.parseOptions(this.question.get(i).getOptions());

		}
		return this.options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	@Override
	public String toString() {
		return "ModelViewAnsForm [cours=" + cours + ", forms=" + forms + ", question=" + question + ", options="
				+ options + ", formTitle=" + formTitle + "]";
	}
	
	
	
	
}
