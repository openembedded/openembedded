// ==UserScript==
// @name Flash AI
// @description Flash AI add-on
// @include *
// ==/UserScript==


var firefox = true;
if (navigator.userAgent.match("midori")) firefox = false;

if (!firefox){
	window.addEventListener("load", function() { myExtension.onPageLoad(); }, true);
}else{
	window.addEventListener("load", function() { myExtension.init(); }, false);
}
var myExtension = {
	init: function() {
		var appcontent = document.getElementById("appcontent");   // browser
		if(appcontent)
			appcontent.addEventListener("DOMContentLoaded", myExtension.onPageLoad, true);
		var messagepane = document.getElementById("messagepane"); // mail
		if(messagepane)
			messagepane.addEventListener("load", function () { myExtension.onPageLoad(); }, true);
	},
	
	onPageLoad: function(aEvent) {
		checkPageOnLoad(aEvent);
	}
}


var idInterval=-1;
var stUrl = "";
var timeout=2000;

var width = 0;
var height = 0;

function rev(str) {
	if(!str)
		return'';
	var revstr='';
	for(i=str.length-1;i>=0;i--) {
		revstr+=str.charAt(i);
	}
	return revstr;
}

function getDocuments(aFrame,aArray) {
        const frames = aFrame.frames;
        aArray.push(aFrame.document);
        for(var i = 0; i < frames.length; i++)
		this.getDocuments(frames[i],aArray);
        return aArray;
}

function getBrowserForDocument(aDocument) {
        // This function can return the browser for not only top level documents
        // but also documents contained in subframes
	
        // If the document is top level then return its browser here
        var browsers = gBrowser.browsers;
        for(var i = 0; i < browsers.length; i++) {
		if(aDocument == browsers[i].contentDocument) return browsers[i];
        }
	
        // Else it must be in a subframe, so check all frames in each browser
        // to find the parent browser
        var documents;
        for(var j = 0; j < browsers.length; j++) {
		documents = this.getDocuments(browsers[j].contentWindow,new Array());
		for(var k = 0; k < documents.length; k++) {
			if(aDocument == documents[k]) return browsers[j];
		}
        }
	
        // Else the browser could not be determined
        return null;
}

function checkPageOnLoad(aEvent) {
	var doc;	
	if(firefox){
		doc=aEvent.originalTarget;
	}else{
		doc=document;
	}
	var loc=doc.location.href;
	var host=doc.location.hostname;
	idInterval=-1;

	if (host.match(/video.google\./i)!=null) {
		// Get the browser for the document (if required)
	   
	        var browser = this.getBrowserForDocument(doc);
        	if(!browser){
			return;
		}

		embmedia=doc.getElementById("embed_player_1");
		if ((embmedia!=null)&&(idInterval==-1)) {
		
		        // Extract video URL (look at clive code in parse.py for probably stabler code)
		        source=unescape(embmedia.getAttribute('src'));
			stUrl=source.substr(source.indexOf('videoUrl=')+9);
			stUrl=stUrl.split("&thumbnailUrl=")[0];
			idInterval = setInterval(replaceTag, timeout, doc, "embed_player_1", new Array(embmedia));

			return;
		}

		setTimeout(checkPageOnLoad, timeout,aEvent);
	}

	if (host.match(/youtube\./i)!=null) {
		embmedia=doc.embeds;		
		if ((embmedia!=null)&&(idInterval==-1)) {
			embid=embmedia[0].getAttribute('id');
			flashvars=unescape(embmedia[0].getAttribute('flashvars'));
			if ((embid==null)||(flashvars==null)){
				setTimeout(checkPageOnLoad,timeout,aEvent);
			        return;
			}

			if ((embid=='movie_player')||(flashvars.match(/video_id=/i)!=null)) {
			        id = flashvars.split("video_id=")[1].split("&")[0];
				valid = flashvars.split("&t=")[1].split("&")[0];
				stUrl = "http://www.youtube.com/get_video?video_id="+id+"&t="+valid;//&"&fmt=18"; for quality control
				idInterval = setInterval(replaceTag, timeout, doc, "movie_player", embmedia);			    
			}
					      
		}
		setTimeout(checkPageOnLoad,timeout,aEvent);
	}

	if (host.match(/myspace\./i)!=null) {

	        embmedia=doc.embeds;
		if ((embmedia!=null)&&(idInterval==-1)) {
				    
			// Myspace loves embedded flash ads, so we have to find the good one for the video...
			for(i=0;i<embmedia.length;i++){
				source=unescape(embmedia[i].getAttribute('src'));
				if (source==null){
					return;
				}else{
					id=-1;
					if(source.match(/videoid=/i)!=null){
						// regular video
						id = (source.split("videoid=")[1]).split("&")[0];
					
					}else if (source.match(/m=/i)!=null){
						// video channels myspace or hot stuff
						id = (source.split("m=")[1]).split("&")[0].split(",")[0];				
					}
					if(id!=-1){
						stUrl=getMySpaceURL(doc, id);
						idInterval = setInterval(replaceTag, timeout, doc, " ", new Array(embmedia[i]));
						return;
					}
				}
			}
		}

	}
	
	if (host.match(/video.yahoo\./i)!=null) {
		embmedia=doc.embeds;

		if ((embmedia!=null)&&(idInterval==-1)) {
			for(i=0;i<embmedia.length;i++){
				embid = embmedia[i].getAttribute('id');
				if(embid=="video1"){
					stUrl = getURLfromKeepVid(loc);
					if (stUrl != null){
						this.replaceTag(doc, embid, new Array(embmedia[i]));
						return;
					}
				}
			}
		}
		setTimeout(checkPageOnLoad,timeout,aEvent);			    
		return;
	}


	//if (loc.match(/my\.yahoo\..*\/\?rd\=nux/i)!=null) {
	//       atag=doc.getElementsByTagName('a');
       	//        for (i=0;i<atag.length;++i) {
	//		if (atag[i].text.match(/Continue to My Yahoo! Beta/i)) {
	//			url = atag[i].href;
	//			doc.location.href = url;
	//		}
	//	}
	//}

	if (host.match(/dailymotion\./i)!=null) {
	        embmedia=doc.embeds;
		if ((embmedia!=null)&&(idInterval==-1)) {
			embid=embmedia[0].getAttribute('id');

			// regular video
			if (embid=='videoplayer') {
			        // current player
				source='&'+unescape(embmedia[0].getAttribute('flashvars'));
			        stUrl=source.substr(source.indexOf("http://www.dailymotion.com/cdn/H264-512x384"));
				stUrl=stUrl.split("@@")[0];
				idInterval = setInterval(replaceTag, timeout, doc, "videoplayer", embmedia);
			}
		}
		setTimeout(checkPageOnLoad,timeout,aEvent);
	}
}



function replaceTagFrame(doc, frame, stTag) {
	replaceTag(doc, stTag, frame.document.embeds);
}


function replaceTag(doc, stTag, embeds) {
	for (i=0; i < embeds.length; i++) {
		if ((stTag == " ")||(embeds[i].id == stTag)) {
			var obj = embeds[i];
			if (obj.id != "pconrails") {
				var rails = doc.createElement("embed");
				rails.setAttribute("type", "video/x-flv");
				rails.setAttribute("id", "pconrails");
				rails.setAttribute("width", obj.clientWidth);
				rails.setAttribute("height", obj.clientHeight);
				rails.setAttribute("src", stUrl);
				rails.setAttribute("autostart", "true");
				doc.body.appendChild(rails);
				obj.parentNode.replaceChild(rails, obj);
				clearInterval(idInterval);
			}
		}
	}
}


function getURLfromKeepVid(loc){
        if(loc.match(/watch\//i)!=null){
		url = escape(loc);
		while (url.match("/")){
			url = url.replace("/","%2F"); 
		}
		url = "http://keepvid.com/?url="+url;

		var req = new XMLHttpRequest();
		req.open('GET', url, false);
		req.send(null);
	    
		var res = req.responseText;

		/* should better parse DOM tree, but first have to build it, and this code does not work...
		   var dom = document.createElement('div');
		   dom.innerHTML = res.replace(/<script(.|\s)*?\/script>/g, '');
		   alert(dom+"    "+dom.innerHTML);
		   atag = dom.getElementsByTagName("h2");
		   alert("atag.length="+atag.length+" atag="+atag);
		   for (i=0;i<atag.length;i++) {
		   alert("atag["+i+"]= "+atag[i]);
		   if (atag[i].text.match(">> Download <<")) {
		    
		   return atag[i].href;
		   }
		   }
		*/
		// ... so we parse the HTML instead
		matchString = "&rsaquo;&rsaquo; Download &lsaquo;&lsaquo;";
		if (res.match(matchString)){
			indexEnd = res.indexOf(matchString)-1;
			indexStart = 0;
			tag = "<a href=\"";
			var url = res;
			while(url.match(tag)){
				indexStart = url.indexOf(tag)+tag.length;
				url = url.substring(indexStart,indexEnd);
				indexEnd -= indexStart;
			}
			url = url.split("\"")[0];
			while(url.match("&amp;")){
				url = url.replace("&amp;","&");
			}
			return url;
		}
	    
	}
	return null;
}

function getMySpaceURL(doc, id) {
	url = 'http://mediaservices.myspace.com/services/rss.ashx?type=video&videoID=' + id; 

	var req = new XMLHttpRequest();
	req.open('GET', url, false);
	req.send(null);

	var xml = req.responseText;
	return xml.split('media:content url="')[1].split('"')[0];
}	

function getFeaturedYouTubeURL(doc, id) {
	var url = "http://www.youtube.com/watch?v=" + id;

	var req = new XMLHttpRequest();
	req.open('GET', url, false);
	req.send(null);

	var html = req.responseText;

	source=html.match(/video_id=\S+&.+&t=.+&f/i);
	return String(source).replace(/(video_id=\S+)&.+(&t=.+)&f/i,'http:\/\/www.youtube.com\/get_video?$1$2');
}

function replaceInnerHTML_Yahoo(doc) {
	var obj = doc.getElementById("y_embed");

	if (obj == null)
		return;

	var src = obj.innerHTML;

	if (src.indexOf("makeplaylist.dll") != -1) {
		var indexStart = obj.innerHTML.indexOf("pList=")+6;
		var indexEnd = obj.innerHTML.indexOf("&", indexStart);

		var newSrc = unescape(obj.innerHTML.substring(indexStart, indexEnd));

		var req = new XMLHttpRequest();
		req.open('GET', newSrc, false);
		req.send(null);
		
		var newEmbed = req.responseText;

		newEmbed = newEmbed.replace(/application\/x\-shockwave\-flash/, "video/x-flv");

		indexStart = newEmbed.indexOf("<EMBED");
		indexEnd = newEmbed.indexOf("</EMBED>")+8;

		newHTML = newEmbed.substring(indexStart, indexEnd);

		if (width != 0) {
			newHTML = newHTML.replace(/width=(\S+)\s/i, "width=" + width + " ");
		}
		if (height != 0) {			
			newHTML = newHTML.replace(/height=(\S+)\s/i, "height=" + height + " ");
		}

		obj.innerHTML = newHTML;
		clearInterval(idInterval);
	}
}


