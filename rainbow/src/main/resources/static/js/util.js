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
	jQuery("#aboutUsLink").removeClass("active");
}

