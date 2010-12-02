require bug-osgi.inc
DEPENDS += "com.buglabs.common servlet2.3 felix-configadmin com.buglabs.osgi.http"
RDEPENDS += "com.buglabs.osgi.http"
EXTRA_CP += "servlet-2.3.1"

PR = "${INC_PR}.7+svnr${SRCREV}"
