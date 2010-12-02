require bug-app.inc

DESCRIPTION = "It seem like the google map tile urls this app used are no longer valid.\
Check out GpsLogger_1.1 by Koolatron. It's a much prettier version of this app.\
v1.0.5 - Jan 11, 2009\
Ran on an actual bug with R1.4RC on it. Moved start position logic out of start() and folded it into update(); made update() cope with getting a null Position back.\
v1.0.5 - Feb 29, 2008\
Actually updated to use the updated version of IPositionProvider.getLatitudeLongitude (used to be typo'd in the SDK version that was out when I wrote GpsLogger).\
v1.0.4:\
Updated for latlon typo fix in new SDK.\
v1.0.3:\
Added call to OSGI ServiceTracker.close() in MyActivator.stop().\
v1.0.2:\
No new functionality, but I refactored the code so it should be clearer to follow. I also added a lot of javadoc to hopefully explain what's going on. I made a util package to put the purloined Google Tile stuff into, as well as the PositionHelper class that I wrote. This keeps the main gpslogger package tidy.\
v1.0.1:\
I added in the GPS tile code (thanks Angel) so you can see where you are on your route. I also made some sample GPS log files available:\
Round Aberdeen (a bit fast)\
Round Pittsburgh (medium)\
Walking The Strip (great food shopping area in Pittsburgh) (slow)\
\
You can use these or make your own; see this post in the forums.\
v1.0.0:\
A very simple test application that makes use of the GPS and LCD modules. It displays a start position, current position, distance travelled and Google Maps tile, updated every 3 seconds. You can't yet start or stop and it doesn't show you a map or a history of your route or anything yet either. So the name is a bit of a misnomer at this point, since it doesn't log anything yet, but the idea would be that it would save your route for later perusal.\
"
HOMEPAGE = "http://buglabs.net/applications/GpsLogger"

DEPENDS += "com.buglabs.bug.module.gps com.buglabs.osgi com.buglabs.common service-tracker com.buglabs.bug.module.lcd "

PV = "10"

SRC_LINK = "http://buglabs.net/program_version/download/476"

APIVERSION = ""

BROKEN = "1"
