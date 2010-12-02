require bug-osgi.inc
PR = "${INC_PR}.2+svnr${SRCREV}"
DEPENDS += "com.buglabs.common com.buglabs.osgi.http"
RDEPENDS += "com.buglabs.osgi.http"
DEPENDS += "servlet2.3"
EXTRA_CP += "servlet-2.3.1"


