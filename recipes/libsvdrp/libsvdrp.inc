DESCRIPTION = "libsvdrp is an interface library to allow C programs to interact with a running VDR, using the SVDRP protocol."
HOMEPAGE = "http://hg.geexbox.org/${PN}"
SECTION = "libs/multimedia"
LICENSE = "LGPLv2.1+"

INC_PR = "r0"

SRC_URI = "http://${PN}.geexbox.org/releases/${P}.tar.bz2;name=${PN}"

inherit autotools pkgconfig

PACKAGES =+ "${PN}-bin"

FILES_${PN}-bin = "${bindir}/*"
