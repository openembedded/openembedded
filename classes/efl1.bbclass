inherit autotools pkgconfig

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

SECTION = "e/libs"
HOMEPAGE = "http://www.enlightenment.org"
SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-native', '')}"
SRC_URI = "http://download.enlightenment.org/snapshots/2007-06-17/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

libdirectory = "src/lib"
libraries = "lib${SRCNAME}"
headers = "${@bb.data.getVar('SRCNAME',d,1).capitalize()}.h"

def efl_is_native(d):
    import bb
    return ["","-native"][bb.data.inherits_class('native', d)]

do_stage() {
	autotools_stage_all
}

efl_stage_bin() {
            rm -rf ${STAGE_TEMP}
            mkdir -p ${STAGE_TEMP}
            make DESTDIR="${STAGE_TEMP}" install
            cp -pPR ${STAGE_TEMP}/${bindir}/* ${STAGING_BINDIR_CROSS}
            rm -rf ${STAGE_TEMP}
}

PACKAGES = "${PN}-dbg ${PN} ${PN}-themes ${PN}-dev ${PN}-examples"
FILES_${PN}-dev += "${bindir}/${PN}-config ${libdir}/pkgconfig/* ${libdir}/lib*.?a ${libdir}/lib*.a"
FILES_${PN}-examples = "${bindir} ${datadir}"
