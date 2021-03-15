<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 
<head>  
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
  <h1>${obj}</h1>
  <label> FullName </label>   
<input type="text" name=" fullName " placeholder= "FullName" size="15" value="something" required />   
<label> Email Id: </label>   
<input type="text" name="emailid" placeholder="Email Id" size="15" required />   
<label> Appointment Date: </label>   
<input type="date" id="appointmentDate" name="appointmentDate">
<div>  
<label>   
Move Forward  :  
</label>   
  
<select>  
<option value="select">--Select--</option>  
<option value="New">New</option>  
<option value="1st Round">First Round</option>  
<option value="2nd Round">Second Round</option>  
<option value="Managerial Round">Managerial Round</option>  
<option value="HR Round">HR Round</option>  
</select>  
</div>  

  
Interview Transcription :  
<textarea cols="80" rows="5" placeholder="Interview Transcription" value="Interview Transcription " required>  
</textarea>  

 <label for="email"><b>Action Result</b></label>  
 <input type="text" placeholder="Action Resultl" name="actionResult" required>  
  
 <button type="submit" class="registerbtn">Submit</button>    
</form>  
</body>  
</html>  