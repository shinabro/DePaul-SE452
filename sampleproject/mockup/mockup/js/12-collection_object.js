$(function () {
	var e = $( 'td > a' );

	console.log(e.length);
	
	e.each( function(idx, item) {
		console.log(idx);
		console.log('Val: ' + $(item).val());
		console.log('Text: ' + $(item).text());
		console.log('Attr: ' + $(item).attr("href"));
	});

// implied item	
	e.each( function(idx) {
		console.log(idx);
		console.log('Val: ' + $(this).val());
		console.log('Text: ' + $(this).text());
		console.log('Attr: ' + $(this).attr("href"));
	});
	
	
});
