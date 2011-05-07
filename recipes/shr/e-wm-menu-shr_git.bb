DESCRIPTION = "illume SHR applications.menu config"
SECTION = "e/utils"
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f523ab5986cc79b52a90d2ac3d5454a2"

SRCREV = "e1dc24ceb49e09f051a5d12b839572fb33de8b48"
PV = "1.2+gitr${SRCPV}"
PR = "r2"
PACKAGE_ARCH = "all"

RCONFLICTS_${PN} = "e-wm-menu"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master \
"

S = "${WORKDIR}/git/e-wm/${PN}"

FILES_${PN} = "${sysconfdir}/xdg/menus/applications.menu"

do_install() {
    install -d ${D}${sysconfdir}/xdg/menus
    install -m 0755 ${S}/applications.menu ${D}${sysconfdir}/xdg/menus/applications.menu
}
