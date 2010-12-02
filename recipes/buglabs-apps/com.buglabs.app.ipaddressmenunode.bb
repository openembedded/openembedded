require bug-app.inc

DESCRIPTION = "This app simply provides a menu item under Settings called 'IPAddress' with children having the names of each of the network interfaces available on your BUG.  The children of these devices will display the IP address.  For example:\
Settings=>IPAddress=>usb0=>10.10.10.10\
Settings=>IPAddress=>eth0=>192.168.0.234\
Settings=>IPAddress=>eth1\
In the example above, eth1 has no IP address configured, so it will not display it. "
HOMEPAGE = "http://buglabs.net/applications/IPAddressMenuNode"

DEPENDS += "com.buglabs.bug.menu com.buglabs.common com.buglabs.osgi service-tracker "

PV = "2"

SRC_LINK = "http://buglabs.net/program_version/download/796"

APIVERSION = ""
