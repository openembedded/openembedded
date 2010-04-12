DESCRIPTION =	"NX is an exciting new technology for remote display. It provides near local speed application responsiveness over high latency, low bandwidth links."
LICENSE =	"GPL"
HOMEPAGE =	"http://freenx.berlios.de/"

DEPENDS = 	""

SRC_URI =	"http://download.berlios.de/freenx/freenx-${PV}.tar.gz"
inherit autotools

SRC_URI[md5sum] = "4b74709736ab1784403a61ba06cbde50"
SRC_URI[sha256sum] = "a2042885cd246a49d980892b2f574d7d3b046143e96357240dd653d8ff2fdfba"
