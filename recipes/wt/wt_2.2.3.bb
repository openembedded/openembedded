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

SRC_URI[md5sum] = "2f4c34f1e092451d3c4d2e7f8c250015"
SRC_URI[sha256sum] = "c6f692956d93765f12402a0b22617566decc52a9bb1a707b4e8d12affd1528d3"
