require bug-app.inc

DESCRIPTION = "From the remote OSGi website (http://r-osgi.sourceforge.net):\
 R-OSGi runs as an OSGi bundle and facilitates distribution for arbitrary OSGi framework implementations.\
All that a service provider framework has to do is registering a service for remote access. Subsequently, other peers can connect to the service provider peer and get access to the service. Remote services are accessed in an entirely transparent way. For every remote service, a local proxy bundle is generated that registers the same service. Local service clients can hence access the remote service in the same way and without regarding distribution. \
R-OSGi was written by Jan Rellermeyer and Michael Duller"
HOMEPAGE = "http://buglabs.net/applications/Remote+OSGi"

DEPENDS += "service-tracker com.buglabs.app.eventadmin com.buglabs.osgi "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/462"

APIVERSION = ""
