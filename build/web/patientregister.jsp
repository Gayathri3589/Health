<%@page import="java.sql.*"%>
<%@page import="java.net.*"%>
<%@page import="java.io.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>HEALTH MONITORING</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link href="style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="js/cufon-yui.js"></script>
<script type="text/javascript" src="js/arial.js"></script>
<script type="text/javascript" src="js/cuf_run.js"></script>
<script type="text/javascript" src="js/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src="js/radius.js"></script>
<script type='text/javascript' src='https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js'></script>
<script type='text/javascript' src='https://www.google.com/jsapi'></script>

<style type="text/css">
<!--
.style4 {font-size: 18px}
.style5 {font-size: 14px}
.style6 {font-size: 16px}
.style7 {font-size: 16}
.style10 {color: #0099CC}
.style14 {
	font-size: 18px;
	color: #0099FF;
	font-weight: bold;
}
.style18 {font-size: 16px; color: #339900; }
.style25 {color: #0000FF; font-weight: bold; font-size: 14px; }
.style16 {font-size: large}
.style3 {font-size: large;
	font-weight: bold;
	color: #FFFFFF;
}
-->
</style>
</head>
<body>
<div class="main">
  <div class="header">
    <div class="header_resize">
      <div class="menu_nav">
        <ul>
          <li class="active"><a href="index.htm">Home</a></li>
        </ul>
      </div>
      <div class="logo">
        <h1><a href="#">HEALTH MONITORING</a></h1>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  
  <div class="content">
    <div class="content_resize">
      <div class="mainbar">
        <div class="article">
          <h2>HEALTH MONITORING</h2>
          <div class="clr"></div>
          <p class="infopost">&nbsp;</p>
          <form id="form1" name="form1" method="post" action="PatientRegister">
            <table width="519" height="371" border="0">
              <tr>
                <td height="64" colspan="2" bgcolor="#01B6FB"><div align="center" class="style3">Patient Registration </div></td>
              </tr>
              <tr>
                <td width="212"><span class="style16">Username</span></td>
                <td width="214"><label>
                  <input name="username" type="text" id="username" />
                </label></td>
              </tr>
              <tr>
                <td><span class="style16">Password</span></td>
                <td><label>
                  <input name="password" type="password" id="password" />
                </label></td>
              </tr>
              <tr>
                <td><span class="style16">Full Name </span></td>
                <td><label>
                  <input name="fullname" type="text" id="fullname" />
                </label></td>
              </tr>
              <tr>
                <td><span class="style16">Mobile</span></td>
                <td><label>
                  <input name="mobile" type="text" id="mobile" />
                </label></td>
              </tr>
              <tr>
                <td><span class="style16">Doctor name </span></td>
                <td><label>
                  <input name="emailid" type="text" id="emailid" />
                </label></td>
              </tr>
              <tr>
                <td colspan="2"><div align="center">
                    <label>
                    <input type="submit" name="Submit222" value="Registration" />
                    </label>
                </div></td>
              </tr>
            </table>
            <h3 align="center"><a href="patientlogin.jsp">Goto Login </a></h3>
          </form>
          <p align="center" class="style10"><a href="register.jsp" class="style18"></a></p>
          <p class="spec"><a href="#" class="rm"></a></p>
        </div>
      </div>
	  
      <div class="sidebar">
        <div class="searchform">
          
        </div>
        <div class="gadget">
          <h2 class="star"><span>Sidebar</span> Menu</h2>
          <div class="clr"></div>
          <ul class="sb_menu">
            <li class="style10"></li>
            <li class="style10"><span class="style5"><span class="style6"><span class="style7"><span class="style4"><a href="index.jsp">Home</a></span></span></span></span></li>
            <li class="style10"><span class="style4"><a href="donatorlogin.jsp"></a></span></li>
            <li></li>
          </ul>
        </div>
      </div>
      <div class="clr"></div>
    </div>
  </div>
  <div class="fbg">
    <div class="fbg_resize">
      <div class="clr"></div>
    </div>
  </div>
  <div class="footer">
    <div class="footer_resize">
      <div class="clr"></div>
    </div>
  </div>
</div>
<div align=center></div>
</body>
</html>
