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

SRC_URI[md5sum] = "14c7de0702a5bd5e45924bd166ae5ee2"
SRC_URI[sha256sum] = "9370d4e6a7166c03c8838edc9defd5c9c637b0a2a2f765e2a0d7ec4ed9079fb8"
