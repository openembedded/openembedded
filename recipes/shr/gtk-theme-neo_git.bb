DESCRIPTION = "nEo GTK theme - a very fast, high contrast GTK theme"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RDEPENDS += "icon-theme-neo"
RSUGGESTS = "elementary-theme-neo e-wm-theme-illume-neo etk-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

SRCREV = "f847105c5ef5d488a4bce0c0a85d572c3509d56f"
PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r4"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/gtk/${PN}/"

require gtk-theme.inc
