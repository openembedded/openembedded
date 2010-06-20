require cornucopia.inc

DESCRIPTION = "mkdump is a kernel message dumper"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/mkdump"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "libfsoframework"
LICENSE = "GPL"

SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "1.0.0+gitr${SRCPV}"
PR = "${INC_PR}.0"

S = "${WORKDIR}/git/tools/${PN}"
