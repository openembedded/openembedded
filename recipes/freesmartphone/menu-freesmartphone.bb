DESCRIPTION = "XDG menu file for the freesmartphone.org project"
LICENSE = "PD"
PV = "0.1"
PR = "r0"

SRC_URI = "file://applications.menu"

do_install() {
    install -d ${D}/${sysconfdir}/xdg/menus
    install -m 644 ${WORKDIR}/applications.menu ${D}/${sysconfdir}/xdg/menus/
}

RPROVIDES_${PN} = "e-wm-menu"
CONFFILES_${PN} = "${sysconfdir}/xdg/menus/applications.menu"
FILES_${PN} = "${sysconfdir}/xdg/menus/applications.menu"

PACKAGE_ARCH_${PN} = "all"

