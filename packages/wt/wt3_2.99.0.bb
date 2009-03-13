DESCRIPTION = "A C++ Web Toolkit"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "GPL"
HOMEPAGE = "http://www.webtoolkit.eu/wt"
DEPENDS = "boost zlib openssl"
PR = "r0"

# package wt3 is for wt 2.99 and wt 3.*
# the api of these versions is incompatible with 2.*

SRC_URI = "${SOURCEFORGE_MIRROR}/witty/wt-${PV}.tar.gz \
	file://src.patch;patch=1 \
	file://ext.patch;patch=1 \
	file://wgooglemap.patch;patch=1"

CXXFLAGS += "-Dsinl=sin -Dcosl=cos -Dasinl=asin"

FILES_${PN} += "${datadir}/Wt"
FILES_${PN}-dev += "${datadir}/cmake-2.*"

S = "${WORKDIR}/wt-${PV}"

inherit cmake

STAGE_TEMP = "${WORKDIR}/temp-staging"

do_configure_append() {
	${BUILD_CXX} ${BUILD_CXXFLAGS} -o src/filetostring src/web/skeleton/FileToString.C
}

do_stage() {
	rm -rf ${STAGE_TEMP}
	mkdir -p ${STAGE_TEMP}
	oe_runmake DESTDIR="${STAGE_TEMP}" install
	cp -pPR ${STAGE_TEMP}/${includedir}/* ${STAGING_INCDIR}
	cp -pPR ${STAGE_TEMP}/${libdir}/* ${STAGING_LIBDIR}
	cp -pPR ${STAGE_TEMP}/${datadir}/cmake-2.* ${STAGING_DATADIR}
	rm -rf ${STAGE_TEMP}
}

