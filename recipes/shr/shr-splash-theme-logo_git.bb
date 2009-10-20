DESCRIPTION = "SHR splash screen - SHR logo theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "0.1-gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

ALTERNATIVE_PRIORITY = 2

require shr-splash-theme.inc

