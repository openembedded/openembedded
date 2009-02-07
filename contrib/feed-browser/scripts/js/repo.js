/* The following function creates an XMLHttpRequest object... */

function createRequestObject(){
	var request_o; //declare the variable to hold the object.
	var browser = navigator.appName; //find the browser name
	if(browser == "Microsoft Internet Explorer"){
		/* Create the object using MSIE's method */
		request_o = new ActiveXObject("Microsoft.XMLHTTP");
	} else {
		/* Create the object using other browser's method */
		request_o = new XMLHttpRequest();
	}
	return request_o; //return the object
}

/* The variable http will hold our new XMLHttpRequest object. */
var sectionHTTP = createRequestObject();
var queryHTTP = createRequestObject(); 
var http = createRequestObject(); 

var qsParm = new Array();
qsParm['pkgsearch'] = null;
qsParm['arch'] = null;
qsParm['section'] = null;
qsParm['pkgname'] = null;


function qs() {
	var query = window.location.search.substring(1);
	var parms = query.split('&');
	for (var i=0; i<parms.length; i++) {
		var pos = parms[i].indexOf('=');
		if (pos > 0) {
			var key = parms[i].substring(0,pos);
			var val = parms[i].substring(pos+1);
			qsParm[key] = val;
		}
	}
	if (qsParm['pkgsearch']) {
		document.getElementById('pkgsearch').value = qsParm['pkgsearch'];
		pkgQuery();
	}
	if (qsParm['pkgname']) {
		document.getElementById('pkgsearch').value = qsParm['pkgname'];
		pkgQuery();
	}
	if (qsParm['section']) {
		pkgQuery();
	}
	
}

function pkgQuery() {
	var action = 'pkgquery';
	var params = '';
	
	if (qsParm['pkgname']) {
		action = 'pkgname';
		params = '&pkgname=' + qsParm['pkgname'];
		qsParm['pkgname'] = null;
	} 
	
	if (document.getElementById('pkgsearch').value != "") {
		params = params + '&pkgsearch=' + document.getElementById('pkgsearch').value;
	} else {
		if (qsParm['pkgsearch']) {
			params = params + '&pkgsearch=' + qsParm['pkgsearch'];
		}
	}
	if (qsParm['arch']) {
		params = params + '&arch=' + qsParm['arch'];
		qsParm['arch'] = null;
	}
	if (qsParm['section']) {
		action = 'section';
		params = params + '&section=' + qsParm['section'];
		qsParm['section'] = null;
	}
	
	params = '&action=' + action + params;
	
	queryHTTP.open('post', 'section.php');
	queryHTTP.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	queryHTTP.onreadystatechange = queryProgress; 
	queryHTTP.send(params);
	
}

function getLetter() {
	var params = 'action=searchletter';
	http.open('post', 'section.php');
	http.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	http.onreadystatechange = letterProgress; 
	http.send(params);
	
} 

function getSection() {
	var params = 'action=sectionslist';
	sectionHTTP.open('post', 'section.php');
	sectionHTTP.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	sectionHTTP.onreadystatechange = sectionProgress; 
	sectionHTTP.send(params);
	
} 

function letterProgress() {
	if(http.readyState == 4){ 
		var response = http.responseText;
		document.getElementById('searchletter').innerHTML = response;
		
	}
}

function sectionProgress() {
	if(sectionHTTP.readyState == 4){ 
		var response = sectionHTTP.responseText;
		document.getElementById('sectionslist').innerHTML = response;
		
	}
}

function queryProgress() {
	document.getElementById('opkgoutput').innerHTML = "loading, please wait";
	if(queryHTTP.readyState == 4){ 
		var response = queryHTTP.responseText;
		document.getElementById('opkgoutput').innerHTML = response;
		
	}
}
