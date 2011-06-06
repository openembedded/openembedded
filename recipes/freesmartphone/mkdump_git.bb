require cornucopia.inc

DESCRIPTION = "mkdump is a kernel message dumper"
HOMEPAGE = "http://www.freesmartphone.org/index.php/Implementations/mkdump"
AUTHOR = "Michael 'Mickey' Lauer <mlauer@vanille-media.de>"
SECTION = "console/network"
DEPENDS = "libfsoframework"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=59530bdf33659b29e73d4adb9f9f6552"

SRCREV = "${FSO_CORNUCOPIA_SRCREV}"
PV = "1.0.0+gitr${SRCPV}"
PR = "${INC_PR}.0"

S = "${WORKDIR}/git/tools/${PN}"
