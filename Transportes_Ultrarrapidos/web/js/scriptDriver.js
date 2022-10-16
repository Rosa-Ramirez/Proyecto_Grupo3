/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/ClientSide/javascript.js to edit this template
 */
 function sendForm(){
	const XHR = new XMLHttpRequest();
	  var formData = new URLSearchParams(new FormData(document.getElementById('form'))).toString();

	  // Define what happens in case of error
	  XHR.addEventListener('error', (event) => {
	    alert('Oops! Something went wrong.');
	  });

	  // Set up our request
	  XHR.open('POST', 'DriverController', true);
                    XHR.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                    
                    XHR.onload = () => {
                        if (XHR.readyState === XHR.DONE && XHR.status === 200) {
                            console.log("response => " + XHR.response);
                            showMessage("Registrado");
                            
                        }
                    };
                    
	  XHR.send(formData);
	console.log(formData);
}

