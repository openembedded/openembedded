DESCRIPTION = "SHR splash screen - OM2009 theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
SRCREV = "ebf38849a2328ed4dab1ad143214c6b8c90bed35"
PV = "1.0+gitr${SRCPV}"
PR = "${INC_PR}.0"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

ALTERNATIVE_PRIORITY = 4

require shr-splash-theme.inc

