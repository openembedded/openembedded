DESCRIPTION = "This is a library to handle the LCD and extra keys on the Logitech G15 Gaming Keyboard."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libusb"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15tools/libg15-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-gnu-ld"

do_stage () {
	autotools_stage_all
}

