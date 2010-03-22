DESCRIPTION = "etk SHR theme"
LICENSE = "MIT BSD"
PV = "1.1.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r2"

SRCREV = "1cc80e26a4558dfc2268b349d9a1f468e515bcfb"
SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

require etk-theme.inc
