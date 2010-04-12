DESCRIPTION = "This is a library to handle the LCD and extra keys on the Logitech G15 Gaming Keyboard."
HOMEPAGE = "http://g15tools.sourceforge.net"
LICENSE = "GPLv2"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libusb0"
PR = "r3"

SRC_URI = "${SOURCEFORGE_MIRROR}/g15tools/libg15-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--with-gnu-ld"

do_stage () {
	autotools_stage_all
}


SRC_URI[md5sum] = "51d42e50ec00315f71be184ba1ddf32b"
SRC_URI[sha256sum] = "fd9468704d55fc6796604380ee63454e954720519f827e5ac563e2144b719155"
