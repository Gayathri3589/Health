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
          <img src="images/img1.jpg" width="201" height="146" alt="" class="fl" />
          <form id="form1" name="form1" method="post" action="Decryption">
            <table width="371" height="219" border="0">
              <tr>
                <td height="84" colspan="2"><div align="center" class="style14">  SENSOR VALUES </div></td>
              </tr>
              <tr>
                <td width="172"><span class="style25">Pulse</span></td>
                <td width="189"><label>
                  <input name="sensor1" type="text" id="sensor1" value="<%=session.getAttribute("e1")%>" />
                </label></td>
              </tr>
              <tr>
                <td><span class="style25">Temperature </span></td>
                <td><label>
                  <input name="sensor2" type="text" id="sensor2" value="<%=session.getAttribute("e2")%>" />
                </label></td>
              </tr>
              <tr>
                <td><span class="style25">
                  <label></label>                
                  <label></label>                
                  <a href="admin.jsp">
                  <label></label>
                  </a>Blood Oxygen  </span></td>
                <td><label>
                  <input name="sensor3" type="text" id="sensor3" value="<%=session.getAttribute("e3")%>" />
                </label></td>
              </tr>
              <tr>
                <td colspan="2"><div align="center">
                  <label>
                  <input type="submit" name="Submit" value="Decrypt" />
                  </label>
                </div></td>
              </tr>
            </table>
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
