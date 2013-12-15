<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error tolerant query auto suggest </title>
<style type = "text/css">
body{

 background-color: #fff;
font-family: HelveticaNeue-Light;
overflow:hidden;
background-position: no-repeat center center;
    background-size:cover;
background-image:url('http://farm6.staticflickr.com/5495/10750221524_77190a52ed_o.jpg');

}
#frmUser{

 margin-left:400px;
 margin-right:400px;
 
}
p{
font-family: HelveticaNeue-Thin;
font-size:60px;
 margin-top:5px;
text-align:center;
 font-size: 72px;
 font-color:white;
  background: -webkit-linear-gradient(#fff, #ffe);
  -webkit-background-clip: text;
  -webkit-text-fill-color: white;
  -webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.9);
-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.3);
}
#txtName{
height:20%;
width:70%;
 margin-left:100px;
 margin-top:10px;
 margin-right:900px;
 display:block;
border: 1px solid #999;
height: 25px;
-webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.8);
-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.8);
box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.8);
}
#label{
font-family: HelveticaNeue-Light;
font-size:20px;
text-align:center;
margin-top:200px;
 font-color:white;
}
#welcometext{
font-family: HelveticaNeue-Light;
font-size:20px;
text-align:center;
margin-top:100px;
 color:white;
 background: rgba(0, 0, 10, 0.3);
 -webkit-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.8);
-moz-box-shadow: 0px 0px 8px rgba(0, 0, 0, 0.8);
}


</style>
<script type="text/javascript"
            src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript"
            src="AutoC.js"> 
</script>
</head>
<body>

<p>Error Tolerant Efficient Query Auto Complete</p>

        <form id="frmUser">
                <div id="label">Enter an input string here </div> 
                <input type="text" id="txtName" /> 
                <br />
                <br />
                <div id="welcometext"></div>
        </form>
         
</body>
</html>