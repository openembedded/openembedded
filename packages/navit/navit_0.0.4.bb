require navit.inc

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/navit/navit-${PV}.tar.gz"

SRC_URI_append +=  "file://navit.xml-so.patch;patch=1"
