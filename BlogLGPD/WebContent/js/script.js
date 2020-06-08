function openPage(pageURL) {
	window.location = pageURL;
}

$(document).ready(function() {
	$(".owl-carousel").owlCarousel({
		margin: 10,
		loop: true,
		autoplay: true,
		autoplayHoverPause: true,
		autoplayTimeout: 2500,
		responsive:{
			0:{
				items:1
			},
			600:{
				items:2
			},
			1000:{
				items:3
			}
		}
	});
});
