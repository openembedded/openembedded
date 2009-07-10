DESCRIPTION = "Chronometer"
HOMEPAGE = "http://www.mikecrash.com/index.php?name=News&file=article&id=103"
AUTHOR = "Mike Crash"
LICENSE  = "GPLv3"
SECTION = "x11/application"
PR = "r0"

inherit autotools

SRC_URI = "http://www.mikecrash.com/download/neo/chronometer_${PV}.tar.gz"
S = "${WORKDIR}/${PN}-${PV}"
