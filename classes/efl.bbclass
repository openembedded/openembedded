SECTION = "e/libs"
HOMEPAGE = "http://www.enlightenment.org"
LICENSE = "MIT BSD"
SRCNAME = "${@bb.data.getVar('PN', d, 1).replace('-native', '')}"
SRC_URI = "${E_CVS};module=e17/libs/${SRCNAME}"
S = "${WORKDIR}/${SRCNAME}"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

PACKAGES = "${PN}-dbg ${PN} ${PN}-themes ${PN}-dev ${PN}-tests"

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

FILES_${PN}-tests  = "${bindir}/${PN} \
                      ${bindir}/*_* \
                      ${datadir}"

