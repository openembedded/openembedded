DESCRIPTION = "A gtk theme that looks like e17"
SECTION = "x11/data"
LICENSE = "MIT BSD"
PV = "0.1-gitr${SRCPV}"
PR = "r2"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"
S = "${WORKDIR}/git/gtk/${PN}"

require shr-theme-gtk.inc
