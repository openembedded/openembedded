DESCRIPTION = "A C++ Web Toolkit"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "GPL"
HOMEPAGE = "http://www.webtoolkit.eu/wt"
DEPENDS = "boost zlib openssl"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/witty/wt-${PV}.tar.gz \
	file://cmakelist.patch;patch=1"

FILES_${PN} += "${datadir}/Wt"
FILES_${PN}-dev += "${datadir}/cmake-2.*"

ARM_INSTRUCTION_SET = "arm"

inherit cmake

STAGE_TEMP = "${WORKDIR}/temp-staging"

do_configure_append() {
	${BUILD_CXX} ${BUILD_CXXFLAGS} -o src/filetostring src/web/skeleton/FileToString.C
}
