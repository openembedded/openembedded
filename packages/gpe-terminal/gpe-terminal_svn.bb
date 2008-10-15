DESCRIPTION = "GPE terminal wrapper"
SECTION = "gpe"
LICENSE = "GPL"
RRECOMMENDS = "rxvt-unicode"
PR = "r1"
PV = "1.1+svn-${SRCDATE}" 

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GPE_EXTRA_SVN} \
	   file://svn-build.patch;patch=1 \
           file://${PN}.desktop \
           file://${PN}.png"

S = "${WORKDIR}/${PN}"

do_install() {
        install -d ${D}${datadir}/applications
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${WORKDIR}/${PN}.desktop ${D}${datadir}/applications/
        install -m 0644 ${WORKDIR}/${PN}.png ${D}${datadir}/pixmaps/
}
