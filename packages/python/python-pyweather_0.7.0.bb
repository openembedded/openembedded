DESCRIPTION = "PyWeather is a collection of weather related modules \
that are capable of performing conversion calculations for many common meteorological units."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "GPL"
SRCNAME = "weather"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/meta-tools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
