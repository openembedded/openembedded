DESCRIPTION = "SHR splash screen - simple SHR theme"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "1.2-gitr${SRCPV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/shr-splash/${PN}"

require shr-splash-theme.inc

