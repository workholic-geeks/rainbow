/**
 * 
 */

	function emi() {
		var pay1 = '';
		var princ1 = numeral(document.getElementById('displayLoanAmount').value).value();
		var term1 = document.getElementById('displayRepaymentmonth').value;
		var intr1 = document.getElementById('rate1').value / 1200;
		document.getElementById('pay1').value = numeral(Math.round(princ1 * intr1
				/ (1 - (Math.pow(1 / (1 + intr1), term1))) * 100) / 100).format('0,0.00');
	}
	function displayValue() {
		var slider = document.getElementById("loan1");
		var output = document.getElementById("displayLoanAmount");
		output.value = numeral(slider.value).format('0,0.00');
	}
	function displaymonth() {
		var slider = document.getElementById("months1");
		var output = document.getElementById("displayRepaymentmonth");
		output.value = slider.value;
		
	}
	function calculteEMI(){
	emi();
	}
	var validNumber = new RegExp(/^\d*\.?\d*$/);
	var lastValid ;
	var lastTenor ;
	function validateNumber(elem,maxLimit) {
		  if (validNumber.test(elem.value)) {
			 /* if(maxLimit<elem.value){
				  elem.value=maxLimit;
			  }else*/
		    lastValid = numeral(elem.value).format('0,0.00');
		  } else {
		    elem.value = numeral(lastValid).format('0,0.00');
		  }
		}
	function validateNumberTenor(elem,maxLimit) {
		  if (validNumber.test(elem.value)) {
			  if(maxLimit < elem.value){
				  elem.value=lastTenor;
			  }else
			  lastTenor = elem.value;
		  } else {
		    elem.value = lastTenor;
		  }
		}
