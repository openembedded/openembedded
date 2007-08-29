inherit autotools pkgconfig

SECTION = "e/libs"
HOMEPAGE = "http://www.enlightenment.org"
SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-native', '')}"
SRC_URI = "http://download.enlightenment.org/snapshots/2007-07-10/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

do_stage() {
	autotools_stage_all
}

PACKAGES = "${PN}-dbg ${PN} ${PN}-themes ${PN}-dev"
FILES_${PN}-dev += "${bindir}/${PN}-config ${libdir}/pkgconfig/* ${libdir}/lib*.?a ${libdir}/lib*.a"
