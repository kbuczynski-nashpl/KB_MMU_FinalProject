function getSearchWindow() {
	let searchValue = $("#search_navBar").val();
	searchValue = encodeURI(searchValue);
	// MAY NEED TO CHANGE THIS WHEN DEPLOYING
	let url = window.location.origin + "/AppV2/search/" + searchValue
	$.ajax({
		type : "POST",
		url : url,
		contentType : "application/html",
		async : false,
		success : function(data) {
			$('#modalContent').append(data);
		}
	});
}
function toggleNav() {
	if ($("#panel-main").css("display") == "none") {
		+$("#panel-main").fadeIn();
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
	$("#modalContent").html("");
});

$("#search_navBar").on('keyup', function(e) {
	if (e.keyCode == 13) {
		getSearchWindow();
		$('#searchModal').modal('toggle');
	}
});
