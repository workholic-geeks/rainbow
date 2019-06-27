/**
 * @author Anish Singh(anish2u2@gmail.com)
 */

function active(elementId) {
	jQuery(elementId).addClass("active");
}

function removeAll() {
	jQuery("#homeLink").removeClass("active");
	jQuery("#loanProduct").removeClass("active");
	jQuery("#calculatorLink").removeClass("active");
	jQuery("#faqLink").removeClass("active");
	jQuery("#contactUsLink").removeClass("active");
	jQuery("#shortTermLoan").removeClass("active");
	jQuery("#mediumTermLoan").removeClass("active");
	jQuery("#longTermLoan").removeClass("active");
}

/**
 * auto slider code start
 * 
 */

var slideIndex = 0;

function showSlides() {
	if( document.getElementsByClassName("mySlides")!==undefined && document.getElementsByClassName("dot")!==undefined){
	var i;
	var slides = document.getElementsByClassName("mySlides");
	var dots = document.getElementsByClassName("dot");

	for (i = 0; i < slides.length; i++) {
		$(slides[i]).delay(4000);
		slides[i].style.display = "none";
	}
	slideIndex++;
	if (slideIndex > slides.length) {
		slideIndex = 1;
	}
	for (i = 0; i < dots.length; i++) {
		dots[i].className = dots[i].className.replace(" active", "");
	}
	slides[slideIndex - 1].style.display = "block";
	dots[slideIndex - 1].className += " active";
	setInterval(showSlides, 2000); // Change image every 5 seconds
	}
}


// When you've got what you need, you should call this function to trigger a disconnect 

/**
 * End of Auto slider code.
 */
