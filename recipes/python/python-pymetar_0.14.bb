DESCRIPTION = "Access NOAA's METAR weather reports"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "pymetar"
PR = "ml1"

SRC_URI = "http://www.schwarzvogel.de/pkgs/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "024fb0b46c0cb8cf21d63c68d2014796"
SRC_URI[sha256sum] = "46d21122cd200099271e8377cf40c7a4dd005b0a3867a792632715de812c47fe"
