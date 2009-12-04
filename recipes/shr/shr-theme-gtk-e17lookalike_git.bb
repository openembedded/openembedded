DESCRIPTION = "A gtk theme that looks like e17"
LICENSE = "MIT BSD"
PV = "0.1.1+gitr${SRCREV}"
PR = "r5"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/gtk/${PN}"

require gtk-theme.inc
