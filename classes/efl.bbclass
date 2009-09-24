SECTION = "e/libs"
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "MIT BSD"
SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-native', '')}"
SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=${SRCNAME};proto=http"
S = "${WORKDIR}/${SRCNAME}"
DEPENDS += "pkgconfig-native"

# revision 0d93ec84b30bc1bee2caaee72d667f87bc468a70 made SRCDATE and hence PV go backwards, so we need to up PE to unbreak builds and feeds :(
PE = "2"

ARM_INSTRUCTION_SET = "arm"

AUTOTOOLS_STAGE_PKGCONFIG = "1"
# do NOT inherit pkgconfig here, see note in autotools_stage_all
inherit autotools

do_configure_prepend() {
	touch config.rpath
}

do_stage() {
	autotools_stage_all
}

# This construction is stupid, someone with more E knowledge should change it to =+ or something
PACKAGES = "${PN}-dbg ${PN} ${PN}-themes ${PN}-dev ${PN}-doc ${PN}-tests"

FILES_${PN} = "${libdir}/*.so.*"

FILES_${PN}-themes = "${datadir}/${PN}/themes \
                      ${datadir}/${PN}/data \
                      ${datadir}/${PN}/fonts \
                      ${datadir}/${PN}/pointers \
                      ${datadir}/${PN}/images \
                      ${datadir}/${PN}/users \
                      ${datadir}/${PN}/images \
                      ${datadir}/${PN}/styles"

FILES_${PN}-dev   += "${bindir}/${PN}-config \
                      ${libdir}/pkgconfig/* \
                      ${libdir}/lib*.la \
                      ${libdir}/lib*.a \
                      ${libdir}/*.so \
                      ${libdir}/${PN}/*.a \
                      ${libdir}/${PN}/*.la \
                      ${libdir}/${PN}/*/*.a \
                      ${libdir}/${PN}/*/*.la"

FILES_${PN}-dbg +=   "${libdir}/${PN}/.debug \
                      ${libdir}/${PN}/*/.debug"

FILES_${PN}-tests  = "${bindir}/${PN} \
                      ${bindir}/*_* \
                      ${datadir}"

