DESCRIPTION = "nEo GTK theme - a very fast, high contrast GTK theme"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RDEPENDS += "icon-theme-neo"
RRECOMMENDS = "elementary-theme-neo e-wm-theme-illume-neo libframeworkd-phonegui-efl-theme-neo etk-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r3"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/gtk/${PN}/"

require gtk-theme.inc
