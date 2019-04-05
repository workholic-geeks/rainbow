var hostName;

function preLoadHeader(){
	var url="http://"+hostName+":8080"+"/header.html";
	$("#header").load(url);
}


$(document).ready(function(){
	hostName=window.location.hostname;
	preLoadHeader();
	//loadFooter();

});

function loadFooter(){
	var url="http://"+hostName+":8080"+"/footer.html";
	$("#footer").load(url);
}

function loadAboutUs(){
	$("#welcome").load("");
}	