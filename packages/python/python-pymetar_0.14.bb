DESCRIPTION = "Access NOAA's METAR weather reports"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "pymetar"
PR = "ml1"

SRC_URI = "http://www.schwarzvogel.de/pkgs/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
