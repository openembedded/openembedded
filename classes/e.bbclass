HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/apps"
SRC_URI = "${E_CVS};module=e17/apps/${SRCNAME}"
S = "${WORKDIR}/${SRCNAME}"

inherit autotools pkgconfig binconfig

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

export CURL_CONFIG = "${STAGING_BINDIR_CROSS}/curl-config"
export FREETYPE_CONFIG = "${STAGING_BINDIR_CROSS}/freetype-config"

PACKAGES = "${PN}-dbg ${PN}-themes ${PN} ${PN}-dev ${PN}-lib"
FILES_${PN}-lib = "${libdir}/lib*.so.*"
FILES_${PN}-themes = "${datadir}/${PN}/themes ${datadir}/${PN}/data ${datadir}/${PN}/fonts ${datadir}/${PN}/pointers ${datadir}/${PN}/images ${datadir}/${PN}/users ${datadir}/${PN}/images ${datadir}/${PN}/styles"
FILES_${PN}-dev += "${includedir} ${libdir}/lib*.so"
