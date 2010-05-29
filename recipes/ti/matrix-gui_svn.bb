DESCRIPTION = "Matrix GUI for Qt X11"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_gui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

SRCREV = "58"
PV = "1.0"
PR = "r14+svnr${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/matrix_gui/;module=trunk;proto=https;user=anonymous;pswd='' \
    file://0001-Disable-cursor-override-for-X11.patch;patch=1 \
	file://init \
    file://matrix-gui.desktop \
"

S = "${WORKDIR}/trunk"

inherit qt4x11

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/matrix_gui ${D}/${bindir}
	install -d ${D}${sysconfdir}/init.d/
	install -c -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/matrix-gui
    install -d ${D}/${sysconfdir}/xdg/autostart
    install -m 0755 ${WORKDIR}/matrix-gui.desktop ${D}/${sysconfdir}/xdg/autostart
}

FILES_${PN}-autostart = "${sysconfdir}/xdg/autostart/matrix-gui.desktop"

#Make autostart package depend on matrix-gui package.  Doesn't make sense
#to install the autostart package without the underlying matrix-gui package.
RDEPENDS_${PN}-autostart += "${PN}"
PACKAGES =+ "${PN}-autostart"

RDEPENDS_${PN} += "matrix-gui-common"
