/**
 * 
 * Form.js
 * 
 */

$(document).ready(function() {
	
})


function addOption(item) {
	$(item).parent().next().append(
		'<div class="row">' +
			'<div class="col-xs-10 col-sm-10 col-md-10 col-lg-10"> ' +
				'<textarea class="form-control question-option" placeholder="Option" rows="1"></textarea>' +
			'</div> ' +
			'<div class="delete-button-parent col-xs-1 col-sm-1 col-md-1 col-lg-1"> ' +
				'<span class="delete-button delete-option-button glyphicon glyphicon-remove-sign" title="Supprimer l\'option" onclick="deleteOption(this)"></span>' +
			'</div>' +
		'</div>'
	);
}

function deleteOption(item) {
	$(item).parent().parent().remove();
}

function addQuestion(type) {
	var html;
	$("#add-question-hint").remove();
	switch(type) {
		case "text":
			html =
			'<div class="well question text-question" data-type="text">' +
			   	'<div class="form-group row question-form">' +
				'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" type="button" title="Delete question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
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
			html =
			'<div class="well question checkbox-question" data-type="checkbox">' +
		   		'<div class="form-group row question-form">' +
		   			'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" type="button" title="Delete question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
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
						'<button class="btn btn-success btn-add-option" type="button" title="Add an option" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
					'</div>' +
				'</div>' +
			'</div>'
		break;
		case "radio":
			html =
			'<div class="well question radio-question" data-type="radio">' +
		   		'<div class="form-group row question-form">' +
		   			'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" type="button" title="Delete question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
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
						'<button class="btn btn-success btn-add-option" type="button" title="Add an option" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
					'</div>' +
				'</div>' +
			'</div>'
		break;
		case "yn":
			html =
			'<div class="well question yn-question" data-type="yn">' +
			   	'<div class="form-group row question-form">' +
			   		'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" type="button" title="Delete question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
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
	}
	$("#create-form").parent().before(html);
}


function deleteQuestion(item) {
	$(item).parent().parent().parent().remove();
	if ($(".question").length == 0) {
		$("#create-form").parent().before('<p id="add-question-hint">Add question to your form by choosing its type</p>');
	}
}


$("#create-form").click(function() {
	var form;
	var form_title = $("#form-title").val();
	var questions = [];
	var n = $(".question").length;
	if (n == 0) {
		var windowWidth = $(window).width();
		alert(windowWidth);
		var placement = (windowWidth > 420) ? "left" : "top";
		$("#create-form").attr({
			"data-toggle" : "tooltip",
			"data-placement" : placement || "top",
			"title" : "Vous devez ajouter au moins une question à votre formulaire"
		});
		$("#create-form").tooltip("show");
		setTimeout(function() {
			$("#create-form")
				.tooltip("destroy")
				.attr({
				"title" : "Create your form !"
			});
		}, 5000);
		return;
	} else {
		$(".question").each(function() {
			var this_qst = $(this);
			var type = this_qst.attr("data-type");
			var title = this_qst.find(".question-title").val();
			if (type == "checkbox" || type == "radio") {
				var options = [];
				this_qst.find(".question-option").each(function() {
					options.push($(this).val());
				})
				questions.push(new Core[type](title, options));
			} else if (type == "text" || type == "yn") {
				questions.push(new Core[type](title, options));
			}
		})
	}
	//alert(JSON.stringify(new Core.form(form_title, questions)));
	form = new Core.form(form_title, questions);
	alert(JSON.stringify(form));
	return form;
})









