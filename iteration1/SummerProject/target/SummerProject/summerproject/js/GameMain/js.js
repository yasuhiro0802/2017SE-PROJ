// JavaScript Document

// 1. Scrolling From Slide to Slide and everything concerning that

jQuery(document).ready(function ($) {

    //initialise Stellar.js
    $(window).stellar();

    //Cache some variables
    var links = $('.nav').find('li');
    slide = $('.scroll-slide');
    button = $('.button');
    mywindow = $(window);
    htmlbody = $('html,body');


    //Setup waypoints plugin
    slide.waypoint(function (event, direction) {

        //cache the variable of the data-move attribute associated with each slide
        dataslide = $(this).attr('data-move');

        //If the user scrolls up change the navigation link that has the same data-move attribute as the slide to active and 
        //remove the active class from the previous navigation link 
        if (direction === 'down') {
            $('.nav li[data-move="' + dataslide + '"]').addClass('active').prev().removeClass('active');
        }
        // else If the user scrolls down change the navigation link that has the same data-move attribute as the slide to active and 
        //remove the active class from the next navigation link 
        else {
            $('.nav li[data-move="' + dataslide + '"]').addClass('active').next().removeClass('active');
        }

    });

    //waypoints doesnt detect the first slide when user scrolls back up to the top so we add this little bit of code, that removes the class 
    //from navigation link slide 2 and adds it to navigation link slide 1. 
    mywindow.scroll(function () {
        if (mywindow.scrollTop() == 0) {
            $('.nav li[data-move="1"]').addClass('active');
            $('.nav li[data-move="2"]').removeClass('active');
        }
    });

    //Create a function that will be passed a slide number and then will scroll to that slide using jquerys animate. The Jquery
    //easing plugin is also used, so we passed in the easing method of 'easeInOutQuint' which is available throught the plugin.
    function goToByScroll(dataslide) {
        htmlbody.animate({
            scrollTop: $('.scroll-slide[data-move="' + dataslide + '"]').offset().top
        }, 1500, 'easeInOutQuint');
    }



    //When the user clicks on the navigation links, get the data-move attribute value of the link and pass that variable to the goToByScroll function
    links.click(function (e) {
        e.preventDefault();
        dataslide = $(this).attr('data-move');
        goToByScroll(dataslide);
    });

    //When the user clicks on the button, get the get the data-move attribute value of the button and pass that variable to the goToByScroll function
    button.click(function (e) {
        e.preventDefault();
        dataslide = $(this).attr('data-move');
        goToByScroll(dataslide);

    });


});



// 2. Portfolio Isotope Filtering

if($('#portfolio-filtering').length && jQuery()) {
   
$(window).load(function(){
var $container = $('#portfolio-filtering');
$container.isotope({
	filter: '*',
	animationOptions: {
	duration: 150,
	easing: 'linear',
	queue: false,
	resizable: false,
	masonry: { columnWidth: $container.width() / 4 }
   } 
});

$(window).smartresize(function(){
	$container.isotope({
	masonry: { columnWidth: $container.width() / 4 }
  });
});

$('#filtering a').click(function(){
	var selector = $(this).attr('data-filter');
	$container.isotope({ 
	filter: selector,
  });
  return false;
});

});
}

// 3. Carousel Enchancments

 $(document).ready(function() {
    $('.carousel').carousel({interval: 3000});
  });


//PrettyPhoto Init
$(document).ready(function(){
    $("a[rel^='prettyPhoto']").prettyPhoto();
  });
  
//Fixing Pretty Photo Validation Fail
$('a[data-rel]').each(function() {    $(this).attr('rel', $(this).data('rel'));});  
  

// 4. Scrolling Mania
$(document).ready(

  function() { 

    $("html").niceScroll({cursorcolor:"#FFF",cursorwidth:"6px", cursoropacitymax:"0.5"});

  }

);



// 5. Making Animated Skills Bars in About Us Area
setTimeout(function(){

    $('.progress .bar').each(function() {
        var me = $(this);
        var perc = me.attr("data-percentage");

        var current_perc = 0;

        var progress = setInterval(function() {
            if (current_perc>=perc) {
                clearInterval(progress);
            } else {
                current_perc +=1;
                me.css('width', (current_perc)+'%');
            }

            me.text((current_perc)+'%');

        }, 70);

    });

},300);


//6. Quotes Rotator
$( function() {
/*
			- how to call the plugin:
			$( selector ).cbpQTRotator( [options] );
			- options:
			{
				// default transition speed (ms)
				speed : 700,
				// default transition easing
				easing : 'ease',
				// rotator interval (ms)
				interval : 8000
				}
				- destroy:
				$( selector ).cbpQTRotator( 'destroy' );
				*/

			$( '#cbp-qtrotator' ).cbpQTRotator();

} );