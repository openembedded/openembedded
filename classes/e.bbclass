HOMEPAGE = "http://www.enlightenment.org"
SECTION = "e/apps"
SRC_URI = "http://download.enlightenment.org/snapshots/2007-06-17/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig binconfig

do_prepsources () {
  make clean distclean || true
}
addtask prepsources after do_fetch before do_unpack

export CURL_CONFIG		= "${STAGING_BINDIR_CROSS}/curl-config"
export EDB_CONFIG		= "${STAGING_BINDIR_CROSS}/edb-config"
export EET_CONFIG		= "${STAGING_BINDIR_CROSS}/eet-config"
export EVAS_CONFIG		= "${STAGING_BINDIR_CROSS}/evas-config"
export ECORE_CONFIG		= "${STAGING_BINDIR_CROSS}/ecore-config"
export EMBRYO_CONFIG		= "${STAGING_BINDIR_CROSS}/embryo-config"
export ENGRAVE_CONFIG		= "${STAGING_BINDIR_CROSS}/engrave-config"
export ENLIGHTENMENT_CONFIG	= "${STAGING_BINDIR_CROSS}/enlightenment-config"
export EPSILON_CONFIG		= "${STAGING_BINDIR_CROSS}/epsilon-config"
export EPEG_CONFIG		= "${STAGING_BINDIR_CROSS}/epeg-config"
export ESMART_CONFIG		= "${STAGING_BINDIR_CROSS}/esmart-config"
export FREETYPE_CONFIG		= "${STAGING_BINDIR_CROSS}/freetype-config"
export IMLIB2_CONFIG		= "${STAGING_BINDIR_CROSS}/imlib2-config"

#do_compile_prepend() {
#	find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
#	find ${S} -name Makefile | xargs sed -i 's:/usr/X11R6/include:${STAGING_INCDIR}:'
#}

PACKAGES = "${PN}-dbg ${PN}-themes ${PN} ${PN}-dev"
FILES_${PN} += "${libdir}/lib*.so.*"
FILES_${PN}-themes = "${datadir}/${PN}/themes ${datadir}/${PN}/data ${datadir}/${PN}/fonts ${datadir}/${PN}/pointers ${datadir}/${PN}/images ${datadir}/${PN}/users ${datadir}/${PN}/images ${datadir}/${PN}/styles"
FILES_${PN}-dev += "${includedir} ${libdir}/lib*.so"

