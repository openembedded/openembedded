DESCRIPTION = "SHR splash screen - SHR logo theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "0.1+gitr${SRCREV}"
PR = "r1"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

ALTERNATIVE_PRIORITY = 3

require shr-splash-theme.inc

