DESCRIPTION = "A gtk theme that looks like e17"
LICENSE = "MIT BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=f523ab5986cc79b52a90d2ac3d5454a2"
SRCREV = "9b92a3d095ef1b53f55026cc292771d1507e6800"
PV = "0.1.1+gitr${SRCPV}"
PR = "r8"
PACKAGE_ARCH = "all"

SRC_URI = "git://git.shr-project.org/repo/shr-themes.git;protocol=http;branch=master \
"

S = "${WORKDIR}/git/gtk/${PN}"

require gtk-theme.inc
