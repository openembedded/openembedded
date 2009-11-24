DESCRIPTION = "SHR splash screen - SHR Tux theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "0.1+gitr${SRCREV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

require shr-splash-theme.inc

