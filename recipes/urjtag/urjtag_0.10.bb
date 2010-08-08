DESCRIPTION = "UrJTAG is a universal JTAG library, servers and tools"
HOMEPAGE = "http://urjtag.org/"
LICENSE = "GPLv2"
DEPENDS = "libftdi libusb gettext readline"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/urjtag/${P}.tar.bz2 \
	file://Makefile.am-remove-dups.patch \
	"

inherit autotools

SRC_URI[md5sum] = "c685c9bb33bbfa73d6ab7bacb92e6268"
SRC_URI[sha256sum] = "7b740416240923ce3610c5253112ee4eac890461b7af982859ff24d41c5778b7"
