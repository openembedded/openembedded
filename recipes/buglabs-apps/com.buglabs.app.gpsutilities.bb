require bug-app.inc

DESCRIPTION = "OSGi service that wraps Finsprings's PositionHelper class, and adds a bit more. Several other applications depend on this one. See GPSAlarmClock for an implementation of the service. Soon to be an HTTP service as well so that it is available for languages other than Java. As always, email or comment any problems you encounter or any features you would like added, I am looking for ways to improve it."
HOMEPAGE = "http://buglabs.net/applications/GPSUtilities"

DEPENDS += "com.buglabs.bug.module.gps "

PV = "5"

SRC_LINK = "http://buglabs.net/program_version/download/186"

APIVERSION = ""
