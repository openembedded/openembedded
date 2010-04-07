DESCRIPTION = "illume SHR applications.menu config"
SECTION = "e/utils"
LICENSE = "MIT BSD"
SRCREV = "1cc80e26a4558dfc2268b349d9a1f468e515bcfb"
PV = "1.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r1"

RCONFLICTS_${PN} = "e-wm-menu"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/e-wm/${PN}"

FILES_${PN} = "${sysconfdir}/xdg/menus/applications.menu"

do_install() {
    install -d ${D}${sysconfdir}/xdg/menus
    install -m 0755 ${S}/applications.menu ${D}${sysconfdir}/xdg/menus/applications.menu
}
