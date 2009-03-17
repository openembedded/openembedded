DESCRIPTION = "program to manage GPS data"
HOMEPAGE = "http://viking.sourceforge.net/"
SECTION = "x11/applications"
DEPENDS = "gpsd gtk+"
LICENSE = "GPLv2"
PRIORITY = "optional"

SRC_URI = "${SOURCEFORGE_MIRROR}/viking/viking-${PV}.tar.gz \
	file://viking-openaerialmap.patch;patch=1 \
	file://viking-parallel-build.patch;patch=1"

# libgps is linked with c++
#export CC='${CC} -lstdc++'
LDFLAGS += "-lstdc++"

inherit autotools
