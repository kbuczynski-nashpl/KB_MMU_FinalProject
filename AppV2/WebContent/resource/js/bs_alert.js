/**
 * A function to create bootstrap4 alert box with usage of JQUERY
 */

function createNewAlert(alertType, alertMessage, autodismiss){
	let alertBoxDiv = $("<div>", {
		id: "alertbox",
		class: "alert alert-dismissible fade show",
		role: "alert"
	});
	
	switch(alertType){
		case "WARNING":
			alertBoxDiv.addClass('alert-warning');
			break;
		case "SUCCESS":
			alertBoxDiv.addClass('alert-success');
			break;
		case "ERROR":
			alertBoxDiv.addClass('alert-danger');
			break;
		case "INFO":
			alertBoxDiv.addClass('alert-info');
			break;
	}

	let alertBoxMessage = $("<strong>").html(alertMessage).appendTo(alertBoxDiv);
	let alertBoxCloseBtn = $("<button>",{
		type: "button",
		"data-dismiss": "alert",
		"aria-label": "Close",
		class: "close"
	}).html('<span aria-hidden="true">&times;</span>').appendTo(alertBoxDiv);
	alertBoxDiv.appendTo('html');
	if(autodismiss){
		$("#alertbox").fadeTo(2000, 500).slideUp(500, function(){
			$("#alertbox").slideUp(500);
			$("#alertbox").remove();
		});
	}
}