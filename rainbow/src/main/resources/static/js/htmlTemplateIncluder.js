var hostName;

function preLoadHeader(){
	var url="http://"+hostName+":8080"+"/header.html";
	$("#header").load(url);
}


$(document).ready(function(){
	hostName=window.location.hostname;
	preLoadHeader();
	homePage();
	callIconLoader();
	loadFooter();

});

function loadFooter(){
	var url="http://"+hostName+":8080"+"/footer.html";
	$("#footer").load(url);
}
function callIconLoader(){
	var url="http://"+hostName+":8080"+"/calllogoinallpages.html";
	$("#calllogoinallpages").load(url);
}

function homePage(){
	var url="http://"+hostName+":8080"+"/homepage.html";
	$("#welcome").load(url);
}

function loadAboutUs(){
	$("#welcome").load("");
}	

function loadCalculator(){
	var url="http://"+hostName+":8080"+"/emiCalculator.html";
	$("#welcome").empty();
	$("#welcome").load(url);
}

function loadContactUs(){
	var url="http://"+hostName+":8080"+"/contactUSForm.html";
	$("#welcome").empty();
	$("#welcome").load(url);
}

function loadFaq(){
	var url="http://"+hostName+":8080"+"/faq.html";
	$("#welcome").empty();
	$("#welcome").load(url);
}