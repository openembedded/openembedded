DESCRIPTION = "etk SHR theme"
LICENSE = "MIT BSD"
PV = "1.1.1-${EFL_SRCREV}+gitr${SRCREV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

require etk-theme.inc
