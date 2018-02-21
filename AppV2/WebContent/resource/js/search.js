function ajaxCall(path, data){
	let url = window.location.origin + "/AppV2/" + path;
	$.ajax({
		type: "POST",
		url : url,
		contentType : data.contentType,
		data: data,
		async: true,
		success: function(returnData){
			if(data.isModal === true){
				$(data.modalId).html(returnData);
			}
			if(data.responseRequired === true){
				return returnData.responseValue;
			}
		}
	})
	
}

function toggleNav() {
	if ($("#panel-main").css("display") == "none") {
		$("#panel-main").fadeIn();
		$("#panel-main").fadeIn("slow");
		$("#panel-main").fadeIn(3000);
		$("#panel-main").css("display", "block");

	} else {
		$("#panel-main").fadeOut();
		$("#panel-main").fadeOut("slow");
		$("#panel-main").fadeOut(3000);
		$("#panel-main").css("display", "none");
	}
}
$(".modal").on("hidden.bs.modal", function() {
	$(".modal-body").html("");
});

$("#add_new_btn").on('click', function(e) {
		let data = {};
		data.contentType = "application/html";
		data.isModal = true;
		data.modalId = "#modalAddBody"; 
		ajaxCall("add", data);
		$('#addModal').modal('show');
});


$("#search_navBar").on('keyup', function(e) {
	if (e.keyCode == 13) {
		let data = {};
		data.contentType = "application/html";
		data.isModal = true;
		data.modalId = "#modalSearchBody"; 
		ajaxCall("search/", data);
		$('#searchModal').modal('toggle');
	}
});
