require bug-app.inc

DESCRIPTION = "This app gives you a lot of detailed information regarding your bug.\
from the kernel version to the memory usage , partitions and so much more.\
This app could not have be written if it wasn't for the sewing."
HOMEPAGE = "http://buglabs.net/applications/BugAdmin"

DEPENDS += "service-tracker com.buglabs.osgi com.buglabs.osgi.sewing com.sun.javax.servlet com.buglabs.common "

PV = "9"

SRC_LINK = "http://buglabs.net/program_version/download/858"

APIVERSION = "1.4"
