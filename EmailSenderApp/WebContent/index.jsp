<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Email Sender</title>
</head>
<body>
<form name="loginForm" method="post" action="emailsender">
							<div align="center">

								<!-- <div class="col-md-12">
									<input style="width: 243px;height: 25px;" class="form-control" placeholder="subject" required=""
										type="text" name="subject">
								</div><br><br>
								<div class="col-md-12">
									<textarea style="width:310px;height: 100px;"  placeholder="Enter message here" required=""
										 name="desciption"></textarea>
								</div><br> -->
								<div class="col-md-12">
									<input style="width: 243px;height: 25px;" class="form-control" placeholder="From Email ID" required=""
										type="text" name="fromemail">
								</div><br>
								<div class="col-md-12">
									<input style="width: 243px;height: 25px;" class="form-control" placeholder="Password" required=""
										type="password" name="pass">
								</div>
								
								<br> <br /> <br />
								<div class="col-md-12">
									<button class="btn btn-default simple-btn" type="submit" style="width: 65px;height: 30px; padding: 5px">Send
									</button>
								</div>
								<br>
								 <h style="color: #6AB4FF"> </a> 
							</div>

						</form>
</body>
</html>