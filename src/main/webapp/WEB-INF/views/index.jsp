<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
<head>  
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">

function onSelectChange(e){
	
	if(confirm('Are you sure to submit new Data?')){
		console.log('close alert box');
		
		var temp = {};
		temp.name = document.getElementById('name').value;
		temp.emailId = document.getElementById('emailid').value;
		temp.appDate = document.getElementById('appDate').value;
		temp.moveForward = $('#moveForward').find(":selected").text();
		temp.interviewTranscription = $('#interviewTranscription').val().trim();
		temp.actionResult = document.getElementById('actionResult').value;
		
		console.log('temp object is: ',temp)
		
		$.ajax({  
	        type : 'PUT', 
	        data : JSON.stringify(temp),
	        url : "/senMail",    
            contentType: "application/json",
            success: function (data) {
            	console.log('after success data', data);
            	//location.reload();
            },
			error: function (data) {
				//location.reload();
	      }
	    });
		
		location.reload();
	}
}

</script>
<meta name="viewport" content="width=device-width, initial-scale=1">  
<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
.container {  
    padding: 50px;  
  background-color: lightblue;  
}  
  
input[type=text], input[type=password], textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  
input[type=text]:focus, input[type=password]:focus {  
  background-color: orange;  
  outline: none;  
}  
 div {  
            padding: 10px 0;  
         }  
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}  
.registerbtn:hover {  
  opacity: 1;  
}  
</style>  
</head>  
<body>  
<form>  
  <div class="container">  
  <center>  <h1> Interview Management System</h1> </center>  
  <hr>  
  <label> Name </label>   
<input type="text" name="Name" id="name" placeholder= "Name" size="15" value=${message.name} required />   
<label> Email Id: </label>   
<input type="text" name="emailid" id="emailid" placeholder="Email Id" size="15" value=${message.emailId} required />   
<label> Appointment Date: </label>   
<input type="date" id="appDate" name="appointmentDate" value=${message.appDate}>
<div>  
<label>   
Move Forward  :  
</label>   
  
<select onchange="onSelectChange()" id="moveForward">  
<option value="select">--Select--</option>  
<option value="New">New</option>  
<option value="First Round" selected>First Round</option>  
<option value="Second Round">Second Round</option>  
<option value="Managerial Round">Managerial Round</option>  
<option value="HR Round">HR Round</option>  
</select>  

<span style="color:red">*Change in these field will trigger mail</span>

</div>  

  
Interview Transcription :  
<textarea cols="80" rows="5" placeholder="Interview Transcription" id="interviewTranscription" required>  
${message.interviewTranscription}
</textarea>  

 <label for="email"><b>Action Result</b></label>  
 <input type="text" placeholder="Action Resultl" id="actionResult" name="actionResult" value=${message.actionResult} readonly required/>  
  
 <!-- <button type="submit" class="registerbtn">Submit</button>   -->  
</form>  
<span style="color:red">*After editing all the fields change Move Forward dropdown to update Data</span>


</body>  
</html>  