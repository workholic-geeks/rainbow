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

function contactUs(){
	submitRequest();
}
function submitRequest(){
	var name=$("#li_display_name").val();
	var city=$("#edit-city").val();
	var phoneNumber=$("#li_display_mobileNo").val();
	var emailId=$("#li_display_email").val();
	var query=$("#query-query").val();
	var contactUs={
	phoneNumber:phoneNumber,
	comments:query,
	name:name,
	city:city,
	personEmail:emailId};
	 $.ajax({
           type: "post",
           url: "/rainbow/sendMail.json",
           dataType: "json",
           contentType: 'application/json',
           success: function (msg) {
        	   $("#div1").html(result);
           },

           data: JSON.stringify(contactUs)
       });
}
