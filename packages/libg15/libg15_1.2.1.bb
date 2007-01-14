DESCRIPTION = "This is a library to handle the LCD and extra keys on the Logitech G15 Gaming Keyboard."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "console/utils"
PRIORITY = "optional"
DEPENDS = "libusb"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15tools/libg15-${PV}.tar.bz2"

inherit autotools

