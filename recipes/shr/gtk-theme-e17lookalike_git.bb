DESCRIPTION = "A gtk theme that looks like e17"
LICENSE = "MIT BSD"
SRCREV = "5c01117b97ab823b5dd298c08759093a81ac5456"
PV = "0.1.1+gitr${SRCPV}"
PR = "r7"
PACKAGE_ARCH = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master"

S = "${WORKDIR}/git/gtk/${PN}"

require gtk-theme.inc
