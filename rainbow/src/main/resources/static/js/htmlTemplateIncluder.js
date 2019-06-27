var hostName;

function preLoadHeader() {
	var url = "http://" + hostName + ":8080" + "/header.html";
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
	var url = "http://" + hostName + ":8080" + "/footer.html";
	$("#homepage").empty();
	$("#footer").load(url);
}
function callIconLoader() {
	var url = "http://" + hostName + ":8080" + "/calllogoinallpages.html";
	$("#homepage").empty();
	$("#calllogoinallpages").load(url);
}

function homePage() {
	var url = "http://" + hostName + ":8080" + "/homepage.html";
	$("#welcome").load(url);
	removeAll();
	$("#homepage").empty();
	active("#homeLink");
}

function loanProducts() {
	$("#welcome").load("");
	removeAll();
	$("#homepage").empty();
	active("#loanProduct");
}

function loadCalculator() {
	$("#homepage").empty();
	var url = "http://" + hostName + ":8080" + "/emiCalculator.html";
	$("#welcome").empty();
	$("#welcome").load(url);
	removeAll();
	
	active("#calculatorLink");
}

function loadContactUs() {
	$("#homepage").empty();
	var url = "http://" + hostName + ":8080" + "/contactUSForm.html";
	$("#welcome").empty();
	$("#welcome").load(url);
	removeAll();
	active("#contactUsLink");
}

function loadFaq() {
	$("#homepage").empty();
	var url = "http://" + hostName + ":8080" + "/faq.html";
	$("#welcome").empty();
	$("#welcome").load(url);
	removeAll();
	active("#faqLink");
}
function loadShortTermLoan(){
	$("#calllogoinallpages").load("http://" + hostName + ":8080" + "/emiCalculator.html",function(){
		$("#rateOfInterest").hide();
		var output = document.getElementById("displayInterest");
		output.value = 42;
		$("#displayRepaymentmonth").val(6);
		$("#displayLoanAmount").val(5000);
		calculteEMI();
	});
	var url = "http://" + hostName + ":8080" + "/shortTermLoan.html";
	$("#welcome").empty();
	$("#welcome").load("http://" + hostName + ":8080" + "/shortTermSlider.html",function(){
		$("#slideshow > div:gt(0)").hide();

		setInterval(function() { 
		  $('#slideshow > div:first')
		    .fadeOut(1000)
		    .next()
		    .fadeIn(1000)
		    .end()
		    .appendTo('#slideshow');
		},  3000);
		removeAll();
		active("#shortTermLoan");
	});
	$("#homepage").empty();
	$("#homepage").load(url);
	
}
function loadLongTermLoan(){
	$("#calllogoinallpages").load("http://" + hostName + ":8080" + "/emiCalculator.html",function(){
		$("#rateOfInterest").hide();
		var output = document.getElementById("displayInterest");
		output.value = 42;
		$("#displayRepaymentmonth").val(24);
		$("#displayLoanAmount").val(10000);
		calculteEMI();
	});
	var url = "http://" + hostName + ":8080" + "/longTermLoan.html";
	$("#welcome").empty();
	$("#welcome").load("http://" + hostName + ":8080" + "/longTermSlider.html",function(){
		$("#slideshow > div:gt(0)").hide();

		setInterval(function() { 
		  $('#slideshow > div:first')
		    .fadeOut(1000)
		    .next()
		    .fadeIn(1000)
		    .end()
		    .appendTo('#slideshow');
		},  3000);
		removeAll();
		active("#longTermLoan");
	});
	$("#homepage").empty();
	$("#homepage").load(url);
	
}
function loadMediumTermLoan(){
	$("#calllogoinallpages").load("http://" + hostName + ":8080" + "/emiCalculator.html",function(){
		$("#rateOfInterest").hide();
		var output = document.getElementById("displayInterest");
		output.value = 42;
		//$("#displayInterest").val(42);
		$("#displayRepaymentmonth").val(12);
		$("#displayLoanAmount").val(10000);
		calculteEMI();
	});
	var url = "http://" + hostName + ":8080" + "/mediumTermLoan.html";
	$("#welcome").empty();
	$("#welcome").load("http://" + hostName + ":8080" + "/mediumTermSlider.html",function(){
		$("#slideshow > div:gt(0)").hide();

		setInterval(function() { 
		  $('#slideshow > div:first')
		    .fadeOut(1000)
		    .next()
		    .fadeIn(1000)
		    .end()
		    .appendTo('#slideshow');
		},  3000);
		removeAll();
		active("#mediumTermLoan");
	});
	$("#homepage").empty();
	$("#homepage").load(url);
	
	
}