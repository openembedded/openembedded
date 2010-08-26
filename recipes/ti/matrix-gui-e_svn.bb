DESCRIPTION = "Matrix GUI for Qt Embedded"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_gui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

SRCREV = "58"
PV = "1.0"
PR = "r16+svnr${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/matrix_gui/;module=trunk;proto=https;user=anonymous;pswd='' \
	file://init \
"

S = "${WORKDIR}/trunk"

INITSCRIPT_NAME = "matrix-gui-e"
INITSCRIPT_PARAMS = "defaults 99"
#INITSCRIPT_PARAMS = "start 99 3 . stop 99 3 ."

inherit qt4e update-rc.d

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/matrix_gui ${D}/${bindir}/matrix_guiE
	install -d ${D}${sysconfdir}/init.d/
	install -c -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/matrix-gui-e
}

RRECOMMENDS_${PN} = "qt4-embedded-plugin-mousedriver-tslib qt4-embedded-fonts"
RDEPENDS_${PN} += "matrix-gui-common"
