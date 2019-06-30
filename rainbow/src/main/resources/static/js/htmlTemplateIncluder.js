var hostName;

var intervalId;
function emptyAllSections(){
	$("#welcome").empty();
	$("#calllogoinallpages").empty();
	$("#homepage").empty();
	if(intervalId!=undefined)
	clearInterval(intervalId);
}
function preLoadHeader() {
	var url = "http://" + hostName + ":8080" + "/rainbow/header.html";
	$("#header").load(url);
}

$(document).ready(function() {
	hostName = window.location.hostname;
	preLoadHeader();
	homePage();
	callIconLoader();
	loadFooter();

});

function loadFooter() {
	var url = "http://" + hostName + ":8080" + "/rainbow/footer.html";
	$("#homepage").empty();
	$("#footer").load(url);
}
function callIconLoader() {
	var url = "http://" + hostName + ":8080" + "/rainbow/calllogoinallpages.html";
	$("#homepage").empty();
	$("#calllogoinallpages").load(url);
}

function homePage() {
	emptyAllSections();
	removeAll();
	var url = "http://" + hostName + ":8080" + "/rainbow/homepage.html";
	$("#welcome").load(url);
	active("#homeLink");
}

function loanProducts() {
	emptyAllSections();
	removeAll();
	active("#loanProduct");
}

function loadCalculator() {
	emptyAllSections();
	removeAll();
	var url = "http://" + hostName + ":8080" + "/rainbow/emiCalculator.html";
	$("#welcome").load(url);	
	active("#calculatorLink");
}

function loadContactUs() {
	emptyAllSections();
	removeAll();
	var url = "http://" + hostName + ":8080" + "/rainbow/contactUSForm.html";
	$("#welcome").load(url);
	active("#contactUsLink");
}

function loadFaq() {
	emptyAllSections();
	removeAll();
	var url = "http://" + hostName + ":8080" + "/rainbow/faq.html";
	$("#welcome").load(url);
	active("#faqLink");
}
function loadAboutUs() {
	emptyAllSections();
	removeAll();
	var url = "http://" + hostName + ":8080" + "/rainbow/aboutUs.html";
	$("#welcome").load(url);
	active("#aboutUsLink");
}

function loadShortTermLoan(){
	emptyAllSections();
	removeAll();
	$("#calllogoinallpages").load("http://" + hostName + ":8080" + "/rainbow/emiCalculator.html",function(){
		$("#rateOfInterest").hide();
		var output = document.getElementById("displayInterest");
		output.value = 42;
		$("#displayRepaymentmonth").val(6);
		$("#displayLoanAmount").val(5000);
		calculteEMI();
	});
	var url = "http://" + hostName + ":8080" + "/rainbow/shortTermLoan.html";
	$("#welcome").load("http://" + hostName + ":8080" + "/rainbow/shortTermSlider.html",function(){
		$("#slideshow > div:gt(0)").hide();
		intervalId=setInterval(function() { 
		  $('#slideshow > div:first')
		    .fadeOut(1000)
		    .next()
		    .fadeIn(1000)
		    .end()
		    .appendTo('#slideshow');
		},  3000);
		active("#shortTermLoan");
	});
	$("#homepage").load(url);
	
}
function loadLongTermLoan(){
	emptyAllSections();
	removeAll();
	$("#calllogoinallpages").load("http://" + hostName + ":8080" + "/rainbow/emiCalculator.html",function(){
		$("#rateOfInterest").hide();
		var output = document.getElementById("displayInterest");
		output.value = 42;
		$("#displayRepaymentmonth").val(24);
		$("#displayLoanAmount").val(10000);
		calculteEMI();
	});
	var url = "http://" + hostName + ":8080" + "/rainbow/longTermLoan.html";
	$("#welcome").load("http://" + hostName + ":8080" + "/rainbow/longTermSlider.html",function(){
		$("#slideshow > div:gt(0)").hide();
		intervalId=setInterval(function() { 
		  $('#slideshow > div:first')
		    .fadeOut(1000)
		    .next()
		    .fadeIn(1000)
		    .end()
		    .appendTo('#slideshow');
		},  3000);
		active("#longTermLoan");
	});
	$("#homepage").load(url);
	
}
function loadMediumTermLoan(){
	emptyAllSections();
	removeAll();
	$("#calllogoinallpages").load("http://" + hostName + ":8080" + "/rainbow/emiCalculator.html",function(){
		$("#rateOfInterest").hide();
		var output = document.getElementById("displayInterest");
		output.value = 42;
		//$("#displayInterest").val(42);
		$("#displayRepaymentmonth").val(12);
		$("#displayLoanAmount").val(10000);
		calculteEMI();
	});
	var url = "http://" + hostName + ":8080" + "/rainbow/mediumTermLoan.html";
	$("#welcome").load("http://" + hostName + ":8080" + "/rainbow/mediumTermSlider.html",function(){
		$("#slideshow > div:gt(0)").hide();

		intervalId=setInterval(function() { 
		  $('#slideshow > div:first')
		    .fadeOut(1000)
		    .next()
		    .fadeIn(1000)
		    .end()
		    .appendTo('#slideshow');
		},  3000);
		active("#mediumTermLoan");
	});
	$("#homepage").load(url);
	
	
}