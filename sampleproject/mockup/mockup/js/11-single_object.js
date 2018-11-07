$(function () {
	var e = $( 'td > a' );
	console.log('Length: ' + e.length);
	console.log('Val: ' + e.val());
	console.log('Text: ' + e.text());
	console.log('Attr: ' + e.attr("href"));

	// returns 4th DOM element
	var t = $( 'td > a' )[3];
	console.log('element Html: ' + t.innerHTML);
	
	// converts DOM element to jQuery object
	var x = $(t);
	console.log('Val: ' + x.val());
	console.log('Text: ' + x.text());
	console.log('Attr: ' + x.attr("href"));
	console.log('html: ' + x.html());
	console.log('context Html: ' + x.parent().html());
});
