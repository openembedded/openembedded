DESCRIPTION = "A C++ Web Toolkit"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "GPL"
DEPENDS = "boost"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/witty/wt-${PV}.tar.gz \
	file://cmakelist.patch;patch=1"

FILES_${PN} += "${datadir}/Wt"
FILES_${PN}-dev += "${datadir}/cmake-2.*"

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

