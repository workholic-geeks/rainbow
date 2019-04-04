function formValidate() {
		document.getElementById('cityId').innerHTML = "";
		document.getElementById('nameId').innerHTML = "";
		document.getElementById('mobileId').innerHTML = "";
		document.getElementById('emailId').innerHTML = "";
		if ((document.applyform.city.value == "")) {
			document.getElementById('cityId').innerHTML = "Please select your city......";
			applyform.city.focus();
			return (false);
		} else if ((document.applyform.name.value == "")) {
			document.getElementById('nameId').innerHTML = "Please enter you name.......";
			applyform.name.focus();
			return (false);
		} else if (document.applyform.mobileno.value == ""
				|| document.applyform.mobileno.value.toString().length() < 11) {
			document.getElementById('mobileId').innerHTML = "Please enter your valid mobile no......";
			applyform.mobileno.focus();
			return (false);
		} else if (document.applyform.email.value == "") {
			document.getElementById('emailId').innerHTML = "Please enter your valid mail id......";
			applyform.email.focus();
			return (false);
		} else {
			return (true);
		}
	}