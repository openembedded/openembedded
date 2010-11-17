DESCRIPTION = "Meta-package for mythtv "
PR = "r0"

inherit task

RDEPENDS_${PN} = " \
	mythtv \
	mythplugins \
	myththemes \
	mythweb-lighttpd \
	lirc \
	"

LICENSE = "MIT"
