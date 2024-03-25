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
<script type='text/javascript'>

  // set your channel id here
  var channel_id =  746704;
  // set your channel's read api key here if necessary
  var api_key = 'MMXNI1ONF7O5ZHVM';
  // maximum value for the gauge
  var max_gauge_value = 600;
  // name of the gauge
  var gauge_name = 'Temperature';

  // global variables
  var chart, charts, data;

  // load the google gauge visualization
  google.load('visualization', '1', {packages:['gauge']});
  google.setOnLoadCallback(initChart);

  // load the data
  function loadData() {
    // variable for the data point
    var p1,p2,p3,p4;

    // get the data from thingspeak
    $.getJSON('https://api.thingspeak.com/channels/' + channel_id + '/feed/last.json?api_key=' + api_key, function(data) {

      // get the data point
      p1 = data.field1;
      p2 = data.field2;
	 p3 = data.field3;
	 p4 = data.field4;


      if (p1||p2||p3||p4) {
document.getElementById("demo1").innerHTML = p1;
document.getElementById("demo2").innerHTML = p2;
document.getElementById("demo3").innerHTML = p3;
document.getElementById("demo4").innerHTML = p4;

 if (p1> 30) {
  // alert("You can only have 400 words.");
document.getElementById('demo1').style.color = 'red'
}
else
{
document.getElementById('demo1').style.color = 'green'
}

if (p2> 30) {
  // alert("You can only have 400 words.");
document.getElementById('demo2').style.color = 'red'
}
else
{
document.getElementById('demo2').style.color = 'green'
}

if (p3> 30) {
  // alert("You can only have 400 words.");
document.getElementById('demo3').style.color = 'red'
}
else
{
document.getElementById('demo3').style.color = 'green'
}

 if (p4> 30) {
  // alert("You can only have 400 words.");
document.getElementById('demo4').style.color = 'red'
}
else
{
document.getElementById('demo4').style.color = 'green'
}


   
}


    }



);
  }

  // initialize the chart
  function initChart() {
    
    //document.getElementById('gauge_div');
 
    loadData();

    setInterval('loadData()', 15000);

  }

</script>
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
.style26 {
	color: #006600;
	font-size: 14px;
	font-weight: bold;
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
          <img src="images/img1.jpg" width="201" height="146" alt="" class="fl" />
          <form id="form1" name="form1" method="post" action="ApplyHash">
            <table width="371" height="174" border="0">
              <tr>
                <td width="361" height="84"><div align="center" class="style14">  SENSOR VALUES </div></td>
              </tr>
              <tr>
                <td height="84"><div align="center" class="style26">The hash value is : <%=session.getAttribute("hashvalue")%></div></td>
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
