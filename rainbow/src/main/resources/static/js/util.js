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
	jQuery("#checkListQuestionLink").removeClass("active");
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
	
	if(isValid())
    {
	 $.ajax({
           type: "post",
           url: "/rainbow/sendMail.json",
           dataType: "json",
           contentType: 'application/json',
           success: function (msg) {
			        	   if (msg.response.result == "success") {
				$("#myResponse").modal('toggle');
				$(".modal-backdrop").remove();
			} else {
				$(".modal-backdrop").remove();
			}
           },

           data: JSON.stringify(contactUs)
       });
    }
   function isValid()
     {
		var result = true;
		if (isEmpty(name) || isEmpty(city) || isEmpty(phoneNumber)
				|| isEmpty(emailId)) {
			alert("Please enter the valid required data");
			result = false;
		} else {
			if (isNaN(phoneNumber) || phoneNumber.length < 10) {
				alert("Please enter a valid mobile number");
				result = false;
			} else {
				var atposition = emailId.indexOf("@");
				var dotposition = emailId.lastIndexOf(".");
				if (atposition < 1 || dotposition < atposition + 2
						|| dotposition + 2 >= emailId.length) {
					alert("Please enter a valid e-mail address");
					result = false;
				}
			}
		}
		return result;
	}
   
   function isEmpty(val){
	    return (val === undefined || val == null || val.length <= 0) ? true : false;
	}
}
