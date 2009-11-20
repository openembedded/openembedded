DESCRIPTION = "nEo etk theme - a very fast, high contrast etk theme"
HOMEPAGE = "http://jmccloud.jm.funpic.de"
AUTHOR = "Jesus McCloud <bernd.pruenster@gmail.com"
RRECOMMENDS = "elementary-theme-neo e-wm-theme-illume-neo gtk-theme-neo libframeworkd-phonegui-efl-theme-neo gpe-theme-neo icon-theme-neo"
LICENSE = "unknown"

PV = "0.2-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

require etk-theme.inc
