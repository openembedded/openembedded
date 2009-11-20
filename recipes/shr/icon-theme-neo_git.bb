DESCRIPTION = "nEo icon theme - a high contrast icon theme which looks especially well when using all the other nEo themes"
SECTION = "e/utils"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RDEPENDS = "e-wm"
RRECOMMENDS = "elementary-theme-neo e-wm-theme-illume-neo gtk-theme-neo libframeworkd-phonegui-efl-theme-neo etk-theme-neo gpe-theme-neo"
LICENSE = "unknown"

PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/icons/icon-theme-neo"

do_install() {
        install -d ${D}${datadir}/icons/
        install -d ${D}${datadir}/icons/nEo/
        cp -r ${S}/* "${D}${datadir}/icons/nEo/"
}

FILES_${PN} = "${datadir}/icons/nEo/"

pkg_postinst() {
        echo "To activate this theme select it under ICON THEME in the LOOK tab of enlightenment settings"
        echo "Restart enlightenment for the changes to take affect"
}
