$(function() {


	
	$(".detail").click(function(e) {
		var dataset = e.currentTarget.dataset;

		$('#checkitout').html("Question Options");
		$('#showTitle').html(dataset.a);
		$('#showAuthor').html(dataset.b);
		$('#showPic').html(dataset.c);
		$('#showD').html(dataset.d);

		$('#eg2').modal('show');

	});

});
