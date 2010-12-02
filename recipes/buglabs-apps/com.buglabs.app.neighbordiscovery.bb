require bug-app.inc

DESCRIPTION = "Java-based BUG Discovery application. It allows the discovery of neighbor BUGs using bluetooth or Avahi if BUGs are connected to the same IP network.\
Requires OpenJDK installed on target BUG. This application is a demo of the software that searches for a BUG and send a message to it.\
"
HOMEPAGE = "http://buglabs.net/applications/NeighborDiscovery"

DEPENDS += "com.buglabs.bug.jni.bluetooth com.buglabs.bug.module.lcd com.buglabs.common com.buglabs.osgi service-tracker "

PV = "1"

SRC_LINK = "http://buglabs.net/program_version/download/1063"

APIVERSION = "1.4.3"
