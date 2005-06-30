DESCRIPTION = "PyWeather is a collection of weather related modules \
that are capable of performing conversion calculations for many common meteorological units."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
SRCNAME = "pyweather"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/meta-tools/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/weather-${PV}"

inherit distutils
