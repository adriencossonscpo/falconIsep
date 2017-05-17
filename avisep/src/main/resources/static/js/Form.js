/**
 * 
 * Form.js
 * 
 */

$(document).ready(
		function() {
			$("#create-form").click(function() {
				createForm();
			});
			$("#form-title").change(
					function() {
						var newTitle = $(this).val();
						if (newTitle !== "") {
							$("#form-title-preview").attr("class",
									"form-title-preview").html(newTitle);
						} else {
							$("#form-title-preview").attr("class",
									"question-hint").html("Form title");
						}
					});
		});

function addOption(item) {
	var id = checkIndex(0, "option");
	$(item)
			.parent()
			.next()
			.append(
					'<div class="row option" id="' + id + '">' +
						'<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"> ' +
							'<textarea class="form-control question-option" placeholder="Option" rows="1"></textarea>' +
						'</div> ' +
						'<div class="delete-button-parent col-xs-1 col-sm-1 col-md-1 col-lg-1"> ' +
							'<span class="delete-button delete-option-button glyphicon glyphicon-remove-sign" data-id="' + id + '" title="Supprimer l\'option" onclick="deleteOption(this)"></span>' +
						'</div>' +
					'</div>'
			);
}

function deleteOption(item) {
	var id = $(item).attr("data-id");
	$("#" + id).remove();
}

function addPreviewOption(type) {
	
}

function checkIndex(n, type) {
	var newIndex = ($("#" + type + "_" + n).length == 0) ? type + "_" + n : checkIndex(n + 1, type);
	return newIndex;
}

function addQuestion(type) {
	var id = checkIndex(0, "question");
	$('#form-tab a[href="#form"]').tab('show');
	var html;
	$(".question-hint").hide();
	switch (type) {
	case "text":
		html = '<div class="well question text-question" data-type="text" id="'	+ id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id	+ '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Text Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	case "checkbox":
		html = '<div class="well question checkbox-question" data-type="checkbox" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id + '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Checkbox Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
					'<div class="row question-form question-options">' +
						'<div class="col-xs-0 col-sm-1 col-md-1 col-lg-1"></div>' +
						'<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Options :</label>' +
						'</div>' +
						'<div class="col-xs-6 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-success btn-add-option" type="button" data-id="' + id	+ '" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	case "radio":
		html = '<div class="well question radio-question" data-type="radio" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id	+ '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Radio Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
					'<div class="row question-form question-options">' +
						'<div class="col-xs-0 col-sm-1 col-md-1 col-lg-1"></div>' +
						'<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Options :</label>' +
						'</div>' +
						'<div class="col-xs-6 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-success btn-add-option" type="button" data-id="' + id	+ '" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	case "yn":
		html = '<div class="well question yn-question" data-type="yn" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id + '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Yes/No Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	case "roti":
		html = '<div class="well question yn-question" data-type="roti" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id + '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">ROTI Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	}
	$("#create-form").parent().before(html);
	addQuestionPreview(type, id)
}

//Supprime également le preview correspondant
function deleteQuestion(item) {
	var id = $(item).attr("data-id");
	$("#" + id + ", #" + id + "_preview").remove();
	if ($(".question").length == 0) {
		$(".question-hint").show();
	}
}

function addQuestionPreview(type, id) {
	var html = "";
	switch (type) {
	case "text":
		html = '<div class="form-group row question-preview" id="' + id + '_preview" data-type="text">' +
					'<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">' +
						'<label class="question-title-preview form-hint">Ajoutez un titre à votre question</label>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">' +
						'<textarea class="form-control question-answer-preview" placeholder="Type your answer" rows="1" disabled="disabled"></textarea>' +
					'</div>' +
				'</div>'
		break;
	case "checkbox":
		html = '<div class="form-group row question-preview" id="' + id + '_preview" data-type="text">' +
					'<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">' +
						'<label class="question-title-preview form-hint">Ajoutez un titre à votre question</label>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">' +
						'<label class="question-title-preview form-hint">Ajoutez des options à votre question</label>' +
					'</div>' +
				'</div>'
		break;
	case "radio":
		html = '<div class="well question radio-question" data-type="radio" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id	+ '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Radio Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
					'<div class="row question-form question-options">' +
						'<div class="col-xs-0 col-sm-1 col-md-1 col-lg-1"></div>' +
						'<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Options :</label>' +
						'</div>' +
						'<div class="col-xs-6 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-success btn-add-option" type="button" data-id="' + id	+ '" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	case "yn":
		html = '<div class="well question yn-question" data-type="yn" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id + '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">Yes/No Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	case "roti":
		html = '<div class="well question yn-question" data-type="roti" id="' + id + '">' +
					'<div class="form-group row question-form">' +
						'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
							'<button class="btn btn-danger btn-delete-question" type="button" data-id="' + id + '" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
						'</div>' +
						'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
							'<label class="question-type">ROTI Question :</label>' +
						'</div>' +
						'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
							'<textarea class="form-control question-title" placeholder="Type the Question" rows="1"></textarea>' +
						'</div>' +
					'</div>' +
				'</div>'
		break;
	}
	$("#form-preview-group").append(html);
}

function createForm() {
	var form, form_title = $("#form-title").val(), questions = [], n = $(".question").length;
	if (n == 0) {
		var windowWidth = $(window).width();
		var placement = (windowWidth > 420) ? "left" : "top";
		$("#create-form")
				.attr(
						{
							"data-toggle" : "tooltip",
							"data-placement" : placement || "top",
							"title" : "Vous devez ajouter au moins une question à votre formulaire"
						});
		$("#create-form").tooltip("show");
		setTimeout(function() {
			$("#create-form").tooltip("destroy").attr({
				"title" : "Create your form !"
			});
		}, 5000);
		return;
	} else {
		$(".question")
				.each(
						function() {
							var this_qst = $(this), type = this_qst
									.attr("data-type"), title = this_qst.find(
									".question-title").val();
							if (type == "checkbox" || type == "radio") {
								var options = [];
								this_qst.find(".question-option").each(
										function() {
											options.push($(this).val());
										})
								questions.push(new Core[type](title, options));
							} else if (type == "text" || type == "yn") {
								questions.push(new Core[type](title, options));
							}
						})
	}
	form = new Core.form(form_title, questions);
	$.ajax({
		url : '/createF',
		data : JSON.stringify(form),
		type : "POST",
		beforeSend : function(xhr) {
			xhr.setRequestHeader("Accept", "application/json");
			xhr.setRequestHeader("Content-Type", "application/json");
		},
		success : function(data) {
			alert(data);
		}
	});
	return form;
}
