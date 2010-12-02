require bug-app.inc

DESCRIPTION = "EasyUp is a very simple upload page for putting stuff in the /tmp/ folder on your BUG.  It relies on the sewing framework, which you can get at 'http://buglabs.net/applications/com.buglabs.osgi.sewing(Sewing)':http://buglabs.net/applications/com.buglabs.osgi.sewing if you have R1.4.2 and earlier.  If you have R1.4.3, sewing comes pre-installed on the BUG.\
After installing go to http://[my BUG's ip address]/easyup\
The application image is a CC image from flickr.  Info below:\
http://www.flickr.com/photos/tchelseat/ / CC BY-NC 2.0"
HOMEPAGE = "http://buglabs.net/applications/EasyUp"

DEPENDS += "service-tracker com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.bug.program com.sun.javax.servlet com.buglabs.common com.buglabs.osgi "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/946"

APIVERSION = "1.4.2"
