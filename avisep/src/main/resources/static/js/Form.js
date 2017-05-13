/**
 * 
 * Form.js
 * 
 */


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
	switch(type) {
		case "text":
			html =
			'<div class="well question text-question"  data-type="text">' +
			   	'<div class="form-group row question-form">' +
				'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
				'</div>' +
				'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
					'<label class="question-type">Text Question :</label>' +
				'</div>' +
					'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
						'<textarea class="form-control" placeholder="Type the Question" rows="1"></textarea>' +
					'</div>' +
				'</div>' +
			'</div>'
		break;
		case "checkbox":
			html =
			'<div class="well question checkbox-question"  data-type="checkbox">' +
		   		'<div class="form-group row question-form">' +
		   			'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
					'</div>' +
					'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
						'<label class="question-type">Checkbox Question :</label>' +
					'</div>' +
				'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
					'<textarea class="form-control" placeholder="Type the Question" rows="1"></textarea>' +
				'</div>' +
			'</div>' +
			'<div class="row question-form question-options">' +
				'<div class="col-xs-0 col-sm-1 col-md-1 col-lg-1"></div>' +
					'<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">' +
						'<label class="question-type">Options :</label>' +
						'</div>' +
					'<div class="col-xs-6 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-success btn-add-option" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
					'</div>' +
				'</div>' +
			'</div>'
		break;
		case "radio":
			html =
			'<div class="well question radio-question"  data-type="radio">' +
		   		'<div class="form-group row question-form">' +
		   			'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
					'</div>' +
					'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
						'<label class="question-type">Radio Question :</label>' +
					'</div>' +
				'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
					'<textarea class="form-control" placeholder="Type the Question" rows="1"></textarea>' +
				'</div>' +
			'</div>' +
			'<div class="row question-form question-options">' +
				'<div class="col-xs-0 col-sm-1 col-md-1 col-lg-1"></div>' +
					'<div class="col-xs-6 col-sm-3 col-md-3 col-lg-3">' +
						'<label class="question-type">Options :</label>' +
						'</div>' +
					'<div class="col-xs-6 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-success btn-add-option" onclick="addOption(this)"><span class="glyphicon glyphicon-plus"></span></button>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-7 col-md-7 col-lg-7">' +
						'<!-- Les options sont ajoutées en cliquant sur le bouton ci-dessus @Form.js -->' +
					'</div>' +
				'</div>' +
			'</div>'
		break;
		case "yn":
			html =
			'<div class="well question yn-question"  data-type="yn">' +
			   	'<div class="form-group row question-form">' +
			   		'<div class="col-xs-3 col-sm-1 col-md-1 col-lg-1">' +
						'<button class="btn btn-danger btn-delete-question" onclick="deleteQuestion(this)"><span class="glyphicon glyphicon-minus"></span></button>' +
					'</div>' +
					'<div class="col-xs-9 col-sm-3 col-md-3 col-lg-3">' +
						'<label class="question-type">Yes/No Question :</label>' +
					'</div>' +
					'<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8">' +
						'<textarea class="form-control" placeholder="Type the Question" rows="1"></textarea>' +
					'</div>' +
				'</div>' +
		    '</div>'
		break;
	}
	$("#create-form").before(html);
}


function deleteQuestion(item) {
	$(item).parent().parent().parent().remove();
}

function getData() {
	alert($(".question").length)
}


$("#create-form").click(function() {
	$(".question").each(function() {
		alert($(this).children("."));
	})
	/*var getData = new Promise(function(resolve, reject) {
		resolve(getData());
	})*/
})