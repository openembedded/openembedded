DESCRIPTION = "nEo etk theme - a very fast, high contrast etk theme"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RSUGGESTS = "elementary-theme-neo e-wm-theme-illume-neo gtk-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

SRCREV = "1cc80e26a4558dfc2268b349d9a1f468e515bcfb"
PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r4"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

require etk-theme.inc
