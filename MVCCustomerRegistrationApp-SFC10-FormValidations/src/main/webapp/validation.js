function  validate(frm){
	alert("client side form validations");
	//set vflag to true indicating  client side form validations are done
	frm.vflag.value="on";
	
	//empty previous  validation error messages
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("addrsErr").innerHTML="";
	document.getElementById("mobileErr").innerHTML="";
	document.getElementById("amtErr").innerHTML="";
	

	//read form data
	let name=frm.cname.value;
	let addrs=frm.cadd.value;
	let mobile=frm.mobileNo.value;
	let amt=frm.billAmt.value;
	
	//form validation logic (client side)
	if(name==""){
		document.getElementById("nameErr").innerHTML="name is mandatory";
		frm.cname.focus();
		return false;
	}
	
	if(addrs==""){
		document.getElementById("addrsErr").innerHTML="Address is mandtory";
		frm.cadd.focus();
		return false;
	}
	else if(addrs.length<10){
		document.getElementById("addrsErr").innerHTML="Address must have min of 10 chars";
		frm.cadd.focus();
		return false;
	}
	
	
	if(mobile==""){
		document.getElementById("mobileErr").innerHTML="Mobile Number is required";
		frm.mobileNo.focus();
		return false;
	}
	else if(mobile.length!=10){
	   document.getElementById("mobileErr").innerHTML="Mobile Number must have min of 10 digits";
	    frm.mobileNo.focus();
	     return false;
      }
	else if(isNaN(mobile)){
		document.getElementById("mobileErr").innerHTML="Mobile Number must have only  digits";
	    frm.mobileNo.focus();
	     return false;
	}
	
	if(amt==""){
		document.getElementById("amtErr").innerHTML="Bill Amount is required";
		frm.billAmt.focus();
		return false;
	}
	else if(amt<1 || amt>10000){
		document.getElementById("amtErr").innerHTML="Bill Amount must be there in the range 1 through 10000";
		frm.billAmt.focus();
		return false;
	}
	else if(isNaN(amt)){
		document.getElementById("amtErr").innerHTML="Bill Amount must have only  digits";
	    frm.billAmt.focus();
	     return false;
	}
	return true;
}//method