require bug-app.inc

DESCRIPTION = "v1.0.9 - May 20, 2008\
Throttled motion events to a maximum of one every 10 seconds (defined by BUGerApplication.MIN_EVENT_SPACING_MS), as on the real bug you could get a large number of events in a short time frame otherwise.\
\
v1.0.8 - Apr 30, 2008\
Tested on a real bug\
Updated to use com.buglabs.bug.base.pub.ITimeProvider now that the SDK (I'm using production 1.0.0.5) has switched to making that available again.\
Made initial webpage show image at reduced size with link to full size image\
\
v1.0.7 - Feb 12, 2008\
Removed explicit reference and inclusion of servlet.jar now that it's available in the SDK (was necessary with older versions of the SDK).\
Added stop() method on BUGerServlet that gets called by BUGerApplication on shutdown. stop() unregisters the HTTP resources previously registered in the servlet's ctor, so that if you remove a module the app is dependent on (camera or motion detector) and then reinsert it, the app will restart properly.\
\
v1.0.6 - Feb 1, 2008\
Got dynamic image display working, so now the images captured when motion is detected will be displayed on the webpage (which was kind of the whole point of this app in the first place).\
v1.0.5 - Jan 31, 2008\
Added a logo. This serves as an example of how you can include static images in pages served up by a Servlet on the bug.\
v1.0.4 - Jan 31, 2008\
Fixed the servlet side to point to the log file in its new place. (It was still pointing to the old place in 1.0.3).\
v1.0.3 - Jan 29, 2008\
Updated to use BundleContext.getDataFile to store log file and images in OSGi-designated persistent storage rather than just in the current working directory. This should now do the right thing on the real Bug too. See this forum article for background information.\
v1.0.2 - Jan 26, 2008\
Changed references to com.buglabs.bug.base.pub. to com.buglabs.bug.emulator.base.pub.* because the package got renamed and so references to ITimeProvider in the app could no longer be resolved.\
v1.0.1\
Updated to use Ken's servlet.jar from the SimpleServlet app instead of the one from my eclipse plugin dir.\
v1.0.0\
Notes:\
This version is using javax.servlet_2.4.0.v200706111738.jar from my eclipse plugin directory for now, until the one in the SDK is working. See Ken's post from 8:38 Oct 15th on this forum post\
The ALT attribute of the IMG tag shows up for now rather than the actual image, because the servlet container doesn't support static resources at this point. When it does I can fix the path to the image and you should be able to see it. See this forum post\
The log file will be created in your current working directory (when you start eclipse or the VirtualBUG) and is called buger.BUGerApplication.log. Images named the-time-as-a-long.jpg will also be created in the same directory.\
\
Instructions:\
Start the VirtualBUG.\
Enable the MOTION and CAMERA services.\
Turn on motion tracking by selecting the Enable Logging option on the BUG menu. To do this press DOWN then RIGHT (to Services), RIGHT (to Programs), RIGHT (to Modules) RIGHT (to Enable Logging) then DOWN (to actually enable logging). You should see BUGerApplication enabled - motion tracker activated in your Eclipse BUG console.\
Fake motion by entering motion in the console and hitting return a few times. Each time you do this you should see a message like :BUGerApplication motion detected at Mon Oct 15 21:44:18 EDT 2007.\
Point your browser at http://localhost:8082/buger\
With any luck, you should see a page similar to the one above.\
\
"
HOMEPAGE = "http://buglabs.net/applications/BUGer"

DEPENDS += "com.buglabs.bug.base com.buglabs.bug.menu com.buglabs.bug.module.camera com.buglabs.bug.module.motion com.buglabs.common com.buglabs.osgi com.buglabs.osgi.http com.sun.javax.servlet service-tracker "

PV = "12"

SRC_LINK = "http://buglabs.net/program_version/download/606"

APIVERSION = ""
