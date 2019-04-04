var hostName;

function preLoadHeader(){
	var url="http://"+hostName+":8080"+"/header.html";
	$("#header").load(url);
}


$(document).ready(function(){
	hostName=window.location.hostname;
	preLoadHeader();

});

function loadAboutUs(){
	$("#welcome").load("");
}	