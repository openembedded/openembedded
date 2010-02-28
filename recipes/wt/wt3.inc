DESCRIPTION = "A C++ Web Toolkit"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "GPL"
HOMEPAGE = "http://www.webtoolkit.eu/wt"
DEPENDS = "boost zlib openssl"

INC_PR = "r1"

# package wt3 is for wt 2.99 and wt 3.*
# the api of these versions is incompatible with 2.*

SRC_URI = "${SOURCEFORGE_MIRROR}/witty/wt-${PV}.tar.gz;name=tarball \
	file://ext.patch;patch=1 \
	file://wgooglemap.patch;patch=1"

CXXFLAGS += "-Dsinl=sin -Dcosl=cos -Dasinl=asin"

FILES_${PN} += "${datadir}/Wt"
FILES_${PN}-dev += "${datadir}/cmake-2.*"

S = "${WORKDIR}/wt-${PV}"

OECMAKE_BUILDPATH = "build"

inherit cmake


EXTRA_OECMAKE = "-DBOOST_DIR=${STAGING_DIR_HOST}${prefix} \
		 -DUseQt4=0 ../ \
                "
